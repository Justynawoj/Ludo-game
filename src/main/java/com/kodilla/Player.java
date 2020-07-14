package com.kodilla;


import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Player extends ActionEvent {

    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    int p4 = 0;

    int newAvailablePosition1;
    int newAvailablePosition2;
    int newAvailablePosition3;
    int newAvailablePosition4;

    int startingPosition;
    int endingPosition;
    int startingWinningPosition;
    int endingWinningPosition;

    String color;
    int thrownDice;


    public Player(int p1, int p2, int p3, int p4, String color) {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.color = color;

    }

//    public void setPositions() {
//        if (color.equalsIgnoreCase("blue")) {
//            startingPosition = 1;
//            endingPosition = 40;
//            startingWinningPosition = 91;
//            endingWinningPosition = 94;
//        }
//        if (color.equalsIgnoreCase("red")) {
//            startingPosition = 11;
//            endingPosition = 10;
//            startingWinningPosition = 61;
//            endingWinningPosition = 64;
//        }
//        if (color.equalsIgnoreCase("yellow")) {
//            startingPosition = 21;
//            endingPosition = 20;
//            startingWinningPosition = 71;
//            endingWinningPosition = 74;
//        }
//        if (color.equalsIgnoreCase("green")) {
//            startingPosition = 31;
//            endingPosition = 30;
//            startingWinningPosition = 81;
//            endingWinningPosition = 84;
//        }
//    }
public void setPositions() {
    if (color.equalsIgnoreCase("blue")) {
        startingPosition = 1;
        endingPosition = 40;
        startingWinningPosition = 91;
        endingWinningPosition = 94;

        p1 = 101;
        p2 = 102;
        p3 = 103;
        p4 = 104;
    }
    if (color.equalsIgnoreCase("red")) {
        startingPosition = 11;
        endingPosition = 10;
        startingWinningPosition = 61;
        endingWinningPosition = 64;

        p1 = 111;
        p2 = 112;
        p3 = 113;
        p4 = 114;
    }
    if (color.equalsIgnoreCase("yellow")) {
        startingPosition = 21;
        endingPosition = 20;
        startingWinningPosition = 71;
        endingWinningPosition = 74;

        p1 = 121;
        p2 = 122;
        p3 = 123;
        p4 = 124;
    }
    if (color.equalsIgnoreCase("green")) {
        startingPosition = 31;
        endingPosition = 30;
        startingWinningPosition = 81;
        endingWinningPosition = 84;

        p1 = 131;
        p2 = 132;
        p3 = 133;
        p4 = 134;
    }
}
    static int trowDice() {
        Random kostka = new Random();
        return kostka.nextInt(6) + 1;
    }

    public static void startGame(Player player1, Player player2, Label label) {

        player1.setPositions();
        player2.setPositions();

        while (!player1.hasWon() && (!player2.hasWon())) {
            player1.setBluePawns(player1,player2);
        //    Controller.getController().setPawns(player1,player2);
//			for (int i = 0; i < 100; i++) {


            player1.newMove(player1, player2);
            player2.newMove(player1,player2);
            System.out.println("------------");
        }
        if(player1.hasWon()){
            label.setText("wygral gracz nr 1");
        } else{
            label.setText("wygral gracz nr 2");
        }
    }

    public boolean hasWon() {

        return (p1 >= startingWinningPosition && p1 <= endingWinningPosition)
                && (p2 >= startingWinningPosition && p2 <= endingWinningPosition)
                && (p3 >= startingWinningPosition && p3 <= endingWinningPosition)
                && (p4 >= startingWinningPosition && p4 <= endingWinningPosition);


    }
    // nowy ruch
    // rzut kostka
    // sprawdzenie pozycji
    // wybor pozycji
    // przypisanie nowej pozycji
    // sprawdzenie czy wygral

    public void newMove(Player player1, Player player2) {
        thrownDice = trowDice();
        System.out.println(thrownDice);
        resetNewPosition();
        calculateNewAvailablePositions(thrownDice);

        chooseNewAvailablePositions(player1,player2);
        changeOppontentsPosition(player1, player2);
        resetNewPosition();

    }

    public void setBluePawns(Player player1, Player player2){

        Controller.getController().setPawns(player1, player2);

    }


    public void calculateNewAvailablePositions(int rzut) {

        // if thrown 6 goes out of home

        if ((p1 >100) && (rzut == 6)) {
            newAvailablePosition1 = startingPosition;
        }
        if ((p2 >100) && (rzut == 6)) {
            newAvailablePosition2 = startingPosition;
        }
        if ((p3 >100) && (rzut == 6)) {
            newAvailablePosition3 = startingPosition;
        }
        if ((p4 >100) && (rzut == 6)) {
            newAvailablePosition4 = startingPosition;
        }

        if (!this.color.equalsIgnoreCase("blue")) {
            if (p1 <100) {
                if (p1IsDifferent(rzut)) {

                    if ((p1 >= startingPosition) && (p1 + rzut <= 40)) {
                        newAvailablePosition1 = p1 + rzut;

                    }
                    if ((p1 >= startingPosition) && (p1 + rzut > 40) && (p1 < 60)) {
                        newAvailablePosition1 = p1 + rzut - 40;

                    }
                    if (p1 < startingPosition) {
                        if (p1 + rzut <= endingPosition) {
                            newAvailablePosition1 = p1 + rzut;
                        }
                        if ((p1 + rzut > endingPosition) && (p1 + rzut + 50 <= endingWinningPosition) && p1 < 41) {
                            newAvailablePosition1 = p1 + rzut + 50;
                        }

                        if ((p1 + rzut <= endingWinningPosition) && (p1 > 40)) {
                            newAvailablePosition1 = p1 + rzut;
                        }
                    }
                }

            }

            if (p2 <100) {
                if (p2IsDifferent(rzut)) {

                    if ((p2 >= startingPosition) && (p2 + rzut <= 40)) {
                        newAvailablePosition2 = p2 + rzut;

                    }
                    if ((p2 >= startingPosition) && (p2 + rzut > 40) && (p2 < 60)) {
                        newAvailablePosition2 = p2 + rzut - 40;

                    }
                    if (p2 < startingPosition) {
                        if (p2 + rzut <= endingPosition) {
                            newAvailablePosition2 = p2 + rzut;
                        }
                        if ((p2 + rzut > endingPosition) && (p2 + rzut + 50 <= endingWinningPosition) && p2 < 41) {
                            newAvailablePosition2 = p2 + rzut + 50;
                        }

                        if ((p2 + rzut <= endingWinningPosition) && (p2 > 40)) {
                            newAvailablePosition2 = p2 + rzut;
                        }
                    }

                }

            }
            if (p3 <100) {
                if (p3IsDifferent(rzut)) {

                    if ((p3 >= startingPosition) && (p3 + rzut <= 40)) {
                        newAvailablePosition3 = p3 + rzut;
                    }
                    if ((p3 >= startingPosition) && (p3 + rzut > 40) && (p3 < 60)) {
                        newAvailablePosition3 = p3 + rzut - 40;

                    }
                    if (p3 < startingPosition) {
                        if (p3 + rzut <= endingPosition) {
                            newAvailablePosition3 = p3 + rzut;
                        }
                        if ((p3 + rzut > endingPosition) && (p3 + rzut + 50 <= endingWinningPosition) && p3 < 41) {
                            newAvailablePosition3 = p3 + rzut + 50;
                        }

                        if ((p3 + rzut <= endingWinningPosition) && (p3 > 40)) {
                            newAvailablePosition3 = p3 + rzut;
                        }
                    }

                }

            }

            if (p4 <100) {
                if (p4IsDifferent(rzut)) {

                    if ((p4 >= startingPosition) && (p4 + rzut <= 40)) {
                        newAvailablePosition4 = p4 + rzut;
                    }
                    if ((p4 >= startingPosition) && (p4 + rzut > 40) && (p4 < 60)) {
                        newAvailablePosition4 = p4 + rzut - 40;

                    }
                    if (p4 < startingPosition) {
                        if (p4 + rzut <= endingPosition) {
                            newAvailablePosition4 = p4 + rzut;
                        }
                        if ((p4 + rzut > endingPosition) && (p4 + rzut + 50 <= endingWinningPosition) && p4 < 41) {
                            newAvailablePosition4 = p4 + rzut + 50;
                        }

                        if ((p4 + rzut <= endingWinningPosition) && (p4 > 40)) {
                            newAvailablePosition4 = p4 + rzut;
                        }
                    }

                }

            }

        }

        if (this.color.equalsIgnoreCase("blue")) {
            if (this.p1IsDifferent(rzut) && p1 <100) {
                if (p1 + rzut < endingPosition) {
                    newAvailablePosition1 = p1 + rzut;
                } else if ((p1 + rzut > endingPosition) && (p1 + rzut + 50 < endingWinningPosition) && (p1 < 41)) {
                    newAvailablePosition1 = p1 + rzut + 50;
                } else if ((p1 > 41) && (p1 + rzut <= endingWinningPosition)) {
                    newAvailablePosition1 = p1 + rzut;
                }
            }

            if (this.p2IsDifferent(rzut) && p2 <100) {
                if (p2 + rzut < endingPosition) {
                    newAvailablePosition2 = p2 + rzut;
                } else if ((p2 + rzut > endingPosition) && (p2 + rzut + 50 < endingWinningPosition) && (p2 < 41)) {
                    newAvailablePosition2 = p2 + rzut + 50;
                } else if ((p2 > 41) && (p2 + rzut <= endingWinningPosition)) {
                    newAvailablePosition2 = p2 + rzut;
                }
            }
            if (this.p3IsDifferent(rzut) && p3 <100) {
                if (p3 + rzut < endingPosition) {
                    newAvailablePosition3 = p3 + rzut;
                } else if ((p3 + rzut > endingPosition) && (p3 + rzut + 50 < endingWinningPosition) && (p3 < 41)) {
                    newAvailablePosition3 = p3 + rzut + 50;
                } else if ((p3 > 41) && (p3 + rzut <= endingWinningPosition)) {
                    newAvailablePosition3 = p3 + rzut;
                }
            }
            if (this.p4IsDifferent(rzut) && p4 <100) {
                if (p4 + rzut < endingPosition) {
                    newAvailablePosition4 = p4 + rzut;
                } else if ((p4 + rzut > endingPosition) && (p4 + rzut + 50 < endingWinningPosition) && (p4 < 41)) {
                    newAvailablePosition4 = p4 + rzut + 50;
                } else if ((p4 > 41) && (p4 + rzut <= endingWinningPosition)) {
                    newAvailablePosition4 = p4 + rzut;
                }

            }

        }
        System.out.println("aktualne pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);

        System.out.println("mozliwe pozycje pionkow " + newAvailablePosition1 + " " + newAvailablePosition2 + " "
                + newAvailablePosition3 + " " + newAvailablePosition4);

    }



    public void chooseNewAvailablePositions(Player player1, Player player2) {

        Random randomNumber = new Random();
        int wybor = randomNumber.nextInt(4) + 1;
        if (wybor == 1) {

            p1 = newAvailablePosition1;
        }
        if (wybor == 2) {
            p2 = newAvailablePosition2;
        }
        if (wybor == 3) {
            p3 = newAvailablePosition3;
        }
        if (wybor == 4) {
            p4 = newAvailablePosition4;
        }
    }

    public void changeOppontentsPosition(Player player1, Player player2) {

        if (this.equals(player1)) {

            if (player1.p1 == player2.p1) {
                player2.p1 = 0;

            }
            if (player1.p1 == player2.p2) {
                player2.p2 = 0;

            }
            if (player1.p1 == player2.p3) {
                player2.p3 = 0;

            }
            if (player1.p1 == player2.p4) {
                player2.p4 = 0;

            }

            if (player1.p2 == player2.p1) {
                player2.p1 = 0;

            }
            if (player1.p2 == player2.p2) {
                player2.p2 = 0;

            }
            if (player1.p2 == player2.p3) {
                player2.p3 = 0;

            }
            if (player1.p2 == player2.p4) {
                player2.p4 = 0;

            }

            if (player1.p3 == player2.p1) {
                player2.p1 = 0;

            }
            if (player1.p3 == player2.p2) {
                player2.p2 = 0;

            }
            if (player1.p3 == player2.p3) {
                player2.p3 = 0;

            }
            if (player1.p3 == player2.p4) {
                player2.p4 = 0;

            }

            if (player1.p4 == player2.p1) {
                player2.p1 = 0;

            }
            if (player1.p4 == player2.p2) {
                player2.p2 = 0;

            }
            if (player1.p4 == player2.p3) {
                player2.p3 = 0;

            }
            if (player1.p4 == player2.p4) {
                player2.p4 = 0;

            }
        }
        if (this.equals(player2)) {

            if (player1.p1 == player2.p1) {
                player1.p1 = 0;

            }
            if (player1.p1 == player2.p2) {
                player1.p1 = 0;

            }
            if (player1.p1 == player2.p3) {
                player1.p1 = 0;

            }
            if (player1.p1 == player2.p4) {
                player1.p1 = 0;

            }

            if (player1.p2 == player2.p1) {
                player1.p2 = 0;

            }
            if (player1.p2 == player2.p2) {
                player1.p2 = 0;

            }
            if (player1.p2 == player2.p3) {
                player1.p2 = 0;

            }
            if (player1.p2 == player2.p4) {
                player1.p2 = 0;

            }

            if (player1.p3 == player2.p1) {
                player1.p3 = 0;

            }
            if (player1.p3 == player2.p2) {
                player1.p3 = 0;

            }
            if (player1.p3 == player2.p3) {
                player1.p3 = 0;

            }
            if (player1.p3 == player2.p4) {
                player1.p3 = 0;

            }

            if (player1.p4 == player2.p1) {
                player1.p4 = 0;

            }
            if (player1.p4 == player2.p2) {
                player1.p4 = 0;

            }
            if (player1.p4 == player2.p3) {
                player1.p4 = 0;

            }
            if (player1.p4 == player2.p4) {
                player1.p4 = 0;

            }
        }

    }

    private void resetNewPosition() {
        newAvailablePosition1 = p1;
        newAvailablePosition2 = p2;
        newAvailablePosition3 = p3;
        newAvailablePosition4 = p4;
        System.out.println(this.toString());
        System.out.println("nowe pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);
    }

    @Override
    public String toString() {
        return "Player [color=" + color + "]";
    }

    public boolean p1IsDifferent(int rzut) {

        return (p1 + rzut != p2) && (p1 + rzut != p3) && (p1 + rzut != p4) && (p1 + rzut - 40 != p2)
                && (p1 + rzut - 40 != p3) && (p1 + rzut - 40 != p4) && (p1 + rzut + 50 != p2) && (p1 + rzut + 50 != p3)
                && (p1 + rzut + 50 != p4);
    }

    public boolean p2IsDifferent(int rzut) {
        return (p2 + rzut != p1) && (p2 + rzut != p3) && (p2 + rzut != p4) && (p2 + rzut - 40 != p1)
                && (p2 + rzut - 40 != p3) && (p2 + rzut - 40 != p4) && (p2 + rzut + 50 != p1) && (p2 + rzut + 50 != p3)
                && (p2 + rzut + 50 != p4);
    }

    public boolean p3IsDifferent(int rzut) {
        return (p3 + rzut != p1) && (p3 + rzut != p2) && (p3 + rzut != p4) && (p3 + rzut - 40 != p1)
                && (p3 + rzut - 40 != p2) && (p3 + rzut - 40 != p4) && (p3 + rzut + 50 != p1) && (p3 + rzut + 50 != p2)
                && (p3 + rzut + 50 != p4);
    }

    public boolean p4IsDifferent(int rzut) {
        return (p4 + rzut != p1) && (p4 + rzut != p2) && (p4 + rzut != p3) && (p4 + rzut - 40 != p1)
                && (p4 + rzut - 40 != p2) && (p4 + rzut - 40 != p3) && (p4 + rzut + 50 != p1) && (p4 + rzut + 50 != p2)
                && (p4 + rzut + 50 != p3);
    }

}
