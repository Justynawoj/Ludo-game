package com.kodilla;


import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Player extends ActionEvent {

    int p1;
    int p2;
    int p3;
    int p4;

    int newAvailablePosition1;
    int newAvailablePosition2;
    int newAvailablePosition3;
    int newAvailablePosition4;

    int startingPosition;
    int endingPosition;
    int startingWinningPosition;
    int endingWinningPosition;

    Color color;
    int thrownDice;

    public Player(int p1, int p2, int p3, int p4, Color color) {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.color = color;

        this.setPositions();
    }

    public void setPositions() {
        if (color == Color.BLUE) {
             startingPosition = 1;
             endingPosition = 40;
             startingWinningPosition = 91;
             endingWinningPosition = 94;

              p1 = 101;
              p2 = 102;
              p3 = 103;
              p4 = 104;
        }
         if (color == Color.RED) {
             startingPosition = 11;
             endingPosition = 10;
             startingWinningPosition = 61;
             endingWinningPosition = 64;

              p1 = 111;
              p2 = 112;
              p3 = 113;
              p4 = 114;
         }
         if (color == Color.YELLOW) {
             startingPosition = 21;
             endingPosition = 20;
             startingWinningPosition = 71;
             endingWinningPosition = 74;

             p1 = 121;
             p2 = 122;
             p3 = 123;
             p4 = 124;
          }
         if (color == Color.GREEN) {
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

    public static void startGame(Player player1, Player player2, Label label) {


        while (!player1.hasWon() && (!player2.hasWon())) {
        //    player1.setBluePawns(player1,player2);
        //    Controller.getController().setPawns(player1,player2);
		//	for (int i = 0; i < 100; i++) {


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
        thrownDice = DiceService.getInstance().getDiceResult();
        System.out.println(thrownDice);
        resetNewPosition();
        calculateNewAvailablePositions(thrownDice);

        chooseNewAvailablePositions();
        changeOppontentsPosition(player1, player2);
        resetNewPosition();

    }

//    public void setBluePawns(Player player1, Player player2){
//
//        Controller.getController().setPawns(player1, player2);
//
//    }


    public void calculateNewAvailablePositions(int rolledDiceNumber) {

        // if thrown 6 goes out of home

        if ((p1 >100) && (rolledDiceNumber == 6)) {
            newAvailablePosition1 = startingPosition;
        }
        if ((p2 >100) && (rolledDiceNumber == 6)) {
            newAvailablePosition2 = startingPosition;
        }
        if ((p3 >100) && (rolledDiceNumber == 6)) {
            newAvailablePosition3 = startingPosition;
        }
        if ((p4 >100) && (rolledDiceNumber == 6)) {
            newAvailablePosition4 = startingPosition;
        }

        if (this.color != Color.BLUE) {
            if (p1 <100) {
                if (p1IsDifferent(rolledDiceNumber)) {

                    if ((p1 >= startingPosition) && (p1 + rolledDiceNumber <= 40)) {
                        newAvailablePosition1 = p1 + rolledDiceNumber;

                    }
                    if ((p1 >= startingPosition) && (p1 + rolledDiceNumber > 40) && (p1 < 60)) {
                        newAvailablePosition1 = p1 + rolledDiceNumber - 40;

                    }
                    if (p1 < startingPosition) {
                        if (p1 + rolledDiceNumber <= endingPosition) {
                            newAvailablePosition1 = p1 + rolledDiceNumber;
                        }
                        if ((p1 + rolledDiceNumber > endingPosition) && (p1 + rolledDiceNumber + 50 <= endingWinningPosition) && p1 < 41) {
                            newAvailablePosition1 = p1 + rolledDiceNumber + 50;
                        }

                        if ((p1 + rolledDiceNumber <= endingWinningPosition) && (p1 > 40)) {
                            newAvailablePosition1 = p1 + rolledDiceNumber;
                        }
                    }
                }

            }

            if (p2 <100) {
                if (p2IsDifferent(rolledDiceNumber)) {

                    if ((p2 >= startingPosition) && (p2 + rolledDiceNumber <= 40)) {
                        newAvailablePosition2 = p2 + rolledDiceNumber;

                    }
                    if ((p2 >= startingPosition) && (p2 + rolledDiceNumber > 40) && (p2 < 60)) {
                        newAvailablePosition2 = p2 + rolledDiceNumber - 40;

                    }
                    if (p2 < startingPosition) {
                        if (p2 + rolledDiceNumber <= endingPosition) {
                            newAvailablePosition2 = p2 + rolledDiceNumber;
                        }
                        if ((p2 + rolledDiceNumber > endingPosition) && (p2 + rolledDiceNumber + 50 <= endingWinningPosition) && p2 < 41) {
                            newAvailablePosition2 = p2 + rolledDiceNumber + 50;
                        }

                        if ((p2 + rolledDiceNumber <= endingWinningPosition) && (p2 > 40)) {
                            newAvailablePosition2 = p2 + rolledDiceNumber;
                        }
                    }

                }

            }
            if (p3 <100) {
                if (p3IsDifferent(rolledDiceNumber)) {

                    if ((p3 >= startingPosition) && (p3 + rolledDiceNumber <= 40)) {
                        newAvailablePosition3 = p3 + rolledDiceNumber;
                    }
                    if ((p3 >= startingPosition) && (p3 + rolledDiceNumber > 40) && (p3 < 60)) {
                        newAvailablePosition3 = p3 + rolledDiceNumber - 40;

                    }
                    if (p3 < startingPosition) {
                        if (p3 + rolledDiceNumber <= endingPosition) {
                            newAvailablePosition3 = p3 + rolledDiceNumber;
                        }
                        if ((p3 + rolledDiceNumber > endingPosition) && (p3 + rolledDiceNumber + 50 <= endingWinningPosition) && p3 < 41) {
                            newAvailablePosition3 = p3 + rolledDiceNumber + 50;
                        }

                        if ((p3 + rolledDiceNumber <= endingWinningPosition) && (p3 > 40)) {
                            newAvailablePosition3 = p3 + rolledDiceNumber;
                        }
                    }

                }

            }

            if (p4 <100) {
                if (p4IsDifferent(rolledDiceNumber)) {

                    if ((p4 >= startingPosition) && (p4 + rolledDiceNumber <= 40)) {
                        newAvailablePosition4 = p4 + rolledDiceNumber;
                    }
                    if ((p4 >= startingPosition) && (p4 + rolledDiceNumber > 40) && (p4 < 60)) {
                        newAvailablePosition4 = p4 + rolledDiceNumber - 40;

                    }
                    if (p4 < startingPosition) {
                        if (p4 + rolledDiceNumber <= endingPosition) {
                            newAvailablePosition4 = p4 + rolledDiceNumber;
                        }
                        if ((p4 + rolledDiceNumber > endingPosition) && (p4 + rolledDiceNumber + 50 <= endingWinningPosition) && p4 < 41) {
                            newAvailablePosition4 = p4 + rolledDiceNumber + 50;
                        }

                        if ((p4 + rolledDiceNumber <= endingWinningPosition) && (p4 > 40)) {
                            newAvailablePosition4 = p4 + rolledDiceNumber;
                        }
                    }

                }

            }

        }

        if (this.color != Color.BLUE) {
            if (this.p1IsDifferent(rolledDiceNumber) && p1 <100) {
                if (p1 + rolledDiceNumber < endingPosition) {
                    newAvailablePosition1 = p1 + rolledDiceNumber;
                } else if ((p1 + rolledDiceNumber > endingPosition) && (p1 + rolledDiceNumber + 50 < endingWinningPosition) && (p1 < 41)) {
                    newAvailablePosition1 = p1 + rolledDiceNumber + 50;
                } else if ((p1 > 41) && (p1 + rolledDiceNumber <= endingWinningPosition)) {
                    newAvailablePosition1 = p1 + rolledDiceNumber;
                }
            }

            if (this.p2IsDifferent(rolledDiceNumber) && p2 <100) {
                if (p2 + rolledDiceNumber < endingPosition) {
                    newAvailablePosition2 = p2 + rolledDiceNumber;
                } else if ((p2 + rolledDiceNumber > endingPosition) && (p2 + rolledDiceNumber + 50 < endingWinningPosition) && (p2 < 41)) {
                    newAvailablePosition2 = p2 + rolledDiceNumber + 50;
                } else if ((p2 > 41) && (p2 + rolledDiceNumber <= endingWinningPosition)) {
                    newAvailablePosition2 = p2 + rolledDiceNumber;
                }
            }
            if (this.p3IsDifferent(rolledDiceNumber) && p3 <100) {
                if (p3 + rolledDiceNumber < endingPosition) {
                    newAvailablePosition3 = p3 + rolledDiceNumber;
                } else if ((p3 + rolledDiceNumber > endingPosition) && (p3 + rolledDiceNumber + 50 < endingWinningPosition) && (p3 < 41)) {
                    newAvailablePosition3 = p3 + rolledDiceNumber + 50;
                } else if ((p3 > 41) && (p3 + rolledDiceNumber <= endingWinningPosition)) {
                    newAvailablePosition3 = p3 + rolledDiceNumber;
                }
            }
            if (this.p4IsDifferent(rolledDiceNumber) && p4 <100) {
                if (p4 + rolledDiceNumber < endingPosition) {
                    newAvailablePosition4 = p4 + rolledDiceNumber;
                } else if ((p4 + rolledDiceNumber > endingPosition) && (p4 + rolledDiceNumber + 50 < endingWinningPosition) && (p4 < 41)) {
                    newAvailablePosition4 = p4 + rolledDiceNumber + 50;
                } else if ((p4 > 41) && (p4 + rolledDiceNumber <= endingWinningPosition)) {
                    newAvailablePosition4 = p4 + rolledDiceNumber;
                }

            }

        }
        System.out.println("aktualne pozycje pionkow " + p1 + " " + p2 + " " + p3 + " " + p4);

        System.out.println("mozliwe pozycje pionkow " + newAvailablePosition1 + " " + newAvailablePosition2 + " "
                + newAvailablePosition3 + " " + newAvailablePosition4);

    }


 //   public void chooseNewAvailablePositions(Player player, Field field) {
    public void chooseNewAvailablePositions() {

        Random randomNumber = new Random();
        int wybor = randomNumber.nextInt(4) + 1;



  //  int wybor = Controller.getController().clicked(field, player);
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

    public boolean p1IsDifferent(int rolledDiceNumber) {

        return (p1 + rolledDiceNumber != p2) && (p1 + rolledDiceNumber != p3) && (p1 + rolledDiceNumber != p4) && (p1 + rolledDiceNumber - 40 != p2)
                && (p1 + rolledDiceNumber - 40 != p3) && (p1 + rolledDiceNumber - 40 != p4) && (p1 + rolledDiceNumber + 50 != p2) && (p1 + rolledDiceNumber + 50 != p3)
                && (p1 + rolledDiceNumber + 50 != p4);
    }

    public boolean p2IsDifferent(int rolledDiceNumber) {
        return (p2 + rolledDiceNumber != p1) && (p2 + rolledDiceNumber != p3) && (p2 + rolledDiceNumber != p4) && (p2 + rolledDiceNumber - 40 != p1)
                && (p2 + rolledDiceNumber - 40 != p3) && (p2 + rolledDiceNumber - 40 != p4) && (p2 + rolledDiceNumber + 50 != p1) && (p2 + rolledDiceNumber + 50 != p3)
                && (p2 + rolledDiceNumber + 50 != p4);
    }

    public boolean p3IsDifferent(int rolledDiceNumber) {
        return (p3 + rolledDiceNumber != p1) && (p3 + rolledDiceNumber != p2) && (p3 + rolledDiceNumber != p4) && (p3 + rolledDiceNumber - 40 != p1)
                && (p3 + rolledDiceNumber - 40 != p2) && (p3 + rolledDiceNumber - 40 != p4) && (p3 + rolledDiceNumber + 50 != p1) && (p3 + rolledDiceNumber + 50 != p2)
                && (p3 + rolledDiceNumber + 50 != p4);
    }

    public boolean p4IsDifferent(int rolledDiceNumber) {
        return (p4 + rolledDiceNumber != p1) && (p4 + rolledDiceNumber != p2) && (p4 + rolledDiceNumber != p3) && (p4 + rolledDiceNumber - 40 != p1)
                && (p4 + rolledDiceNumber - 40 != p2) && (p4 + rolledDiceNumber - 40 != p3) && (p4 + rolledDiceNumber + 50 != p1) && (p4 + rolledDiceNumber + 50 != p2)
                && (p4 + rolledDiceNumber + 50 != p3);
    }

    public Color getColor() {
        return color;
    }
}
