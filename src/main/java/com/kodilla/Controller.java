package com.kodilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    private ArrayList<Field> fieldsInArray = new ArrayList<>();

    boolean inProgressToSet;
    boolean endToSet;
    boolean canMove = false;
    boolean newTry = true;


    private Controller() {
    }

    public static Controller getController() {
        return INSTANCE;
    }

    void addField(Field field) {
        this.fields.put(String.format("%s-%s", field.getCol(), field.getRow()), field);
        this.fieldsInArray.add(field);
    }


    public void calculateAvailabilityOfMoves(Player player, int dice) {
        int newP1Position = calculatePosition(player.getP1(), dice);
        Field newFieldP1 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == newP1Position)
                .findFirst().get();
        if (checkIfCanMove(player.getP1().getField(), newFieldP1, player.getP1())) {
            player.getP1().pawn1CanMove = true;

            System.out.println("Pawn 1 can move");
        }
        Field newFieldP2 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == newP1Position)
                .findFirst().get();
        if (checkIfCanMove(player.getP2().getField(), newFieldP2, player.getP2())) {
            player.getP2().pawn2canMove = true;
            System.out.println("Pawn 2 can move");
        }
        Field newFieldP3 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == newP1Position)
                .findFirst().get();
        if (checkIfCanMove(player.getP3().getField(), newFieldP3, player.getP3())) {
            player.getP3().pawn3canMove = true;
            System.out.println("Pawn 3 can move");
        }
        Field newFieldP4 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == newP1Position)
                .findFirst().get();
        if (checkIfCanMove(player.getP4().getField(), newFieldP4, player.getP4())) {
            player.getP4().pawn4canMove = true;
            System.out.println("Pawn 4 can move");
        }
    }
    public boolean checkIfCanMove(Field oldField, Field newField, Pawn pawn) {
        System.out.print(oldField +" -> "+ newField);
        if (newField.getPawn() == null || newField.getPawn().getPlayer() != pawn.getPlayer()) {
            System.out.println(" Moze");
            return true;
        } else
            System.out.println(" Nie moze");
            return false;

    }

    public void clicked(Field field) {

        int diceValue = DiceService.getInstance().getDiceResult();

        Field playersField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 1000)
                .findFirst().get();
        Player player = playersField.getPawn().getPlayer();
        calculateAvailabilityOfMoves(player,diceValue);

        try {


            Pawn clickedPawn = field.getPawn();
            System.out.println(player.getP1().pawn1CanMove + " "+player.getP2().pawn2canMove + " "+player.getP3().pawn3canMove + " "+player.getP4().pawn4canMove + " ");
                //  if(clickedPawn.getPlayer().equals(player)) {
                if (clickedPawn.equals(player.getP1()) && player.getP1().pawn1CanMove ||
                        clickedPawn.equals(player.getP2()) && player.getP2().pawn2canMove ||
                        clickedPawn.equals(player.getP3()) && player.getP3().pawn3canMove ||
                        clickedPawn.equals(player.getP4()) && player.getP4().pawn4canMove) {

                    //  play(clickedPawn, diceValue);
                    //playing time
                    Field oldField = clickedPawn.getField();

                    int newFieldPosition = calculatePosition(clickedPawn, diceValue);

                    Field newField = fieldsInArray.stream()
                            .filter(f -> f.getPosition() == newFieldPosition)
                            .findFirst().get();

                    changeOpponentPosition(newField, clickedPawn);
                    if (checkIfCanMove(oldField, newField, clickedPawn)) {
                        move(oldField, newField, clickedPawn);
                        resetPawnCanMove(clickedPawn,player);
                    }

                    System.out.println("THIS PAWN CANNOT MOVE");

                    // end of playing time

                    checkIfHasWon(clickedPawn.getPlayer());


                    //    System.out.println(clickedPawn.getPlayer().getP1().getField().position + " " + clickedPawn.getPlayer().getP1().getProgress() + "  " + clickedPawn.getPlayer().getP2().getField().position + " " + clickedPawn.getPlayer().getP2().getProgress() + "  " + clickedPawn.getPlayer().getP3().getField().position + " " + clickedPawn.getPlayer().getP3().getProgress() + "  " + clickedPawn.getPlayer().getP4().getField().position + " " + clickedPawn.getPlayer().getP4().getProgress());


                    /*
                     * computerMove?
                     */
                    int compDiceResult = DiceService.getInstance().thowDice();
                   // System.out.println("Computer has dice value " + compDiceResult);

                    // move(computer.p1,compDiceResult);
                    computerMove();
                } else {
                    System.out.println("CHOOOSE RIGHT YOUR OWN PAWN");
                }


        } catch (Exception e) {
            System.out.println("No such move. Try again, choose correct pawn " + e.getMessage());
        }
    }

    public void resetPawnCanMove(Pawn pawn, Player player){
        if (pawn == player.getP1()){
            pawn.pawn1CanMove = false;
        }
        if (pawn == player.getP2()){
            pawn.pawn2canMove = false;
        }
        if (pawn == player.getP3()){
            pawn.pawn3canMove = false;
        }
        if (pawn == player.getP4()){
            pawn.pawn4canMove = false;
        }
    }
    public void computerMove() {

        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player computer = computerField.getPawn().getPlayer();
        int compDiceResult = DiceService.getInstance().thowDice();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(4) + 1;


        if (compDiceResult == 6) {
            if (computer.getP1().getProgress() == Progress.START) {
                play(computer.p1, compDiceResult);
            } else if (computer.getP2().getProgress() == Progress.START) {
                play(computer.p2, compDiceResult);
            } else if (computer.getP3().getProgress() == Progress.START) {
                play(computer.p3, compDiceResult);
            } else if (computer.getP4().getProgress() == Progress.START) {
                play(computer.p4, compDiceResult);
            }

        } else {


            if (randomNumber == 1) {
                play(computer.p1, compDiceResult);
            }
            if (randomNumber == 2) {
                play(computer.p2, compDiceResult);
            }
            if (randomNumber == 3) {
                play(computer.p3, compDiceResult);
            }
            if (randomNumber == 4) {
                play(computer.p4, compDiceResult);
            }
        }
    }


    private void checkIfHasWon(Player player) {
        if ((player.getP1().getProgress() == Progress.END) && (player.getP2().getProgress() == Progress.END) && (player.getP3().getProgress() == Progress.END) && (player.getP4().getProgress() == Progress.END)) {
            System.out.println("Player " + player.getColor() + " has won!");
        }
    }

    private void play(Pawn pawn, int diceValue) {

        Field oldField = pawn.getField();

        int newFieldPosition = calculatePosition(pawn, diceValue);

        Field newField = fieldsInArray.stream()
                .filter(field -> field.getPosition() == newFieldPosition)
                .findFirst().get();

        changeOpponentPosition(newField, pawn);
        if (checkIfCanMove(oldField, newField, pawn)) {
            move(oldField, newField, pawn);
        }
    }

    public void changeOpponentPosition(Field newField, Pawn pawn) {
        if (newField.getPawn() != null) {
            if (newField.getPawn().getPlayer() != pawn.getPlayer()) {


                if (newField.getPawn().getPlayer().getColor() != pawn.getPlayer().getColor()) {

                    Pawn opponentPawn = newField.getPawn();

                    opponentPawn.setProgress(Progress.START);
                    int newPositionOfOpponent = opponentPawn.getPlayer().getPositionsHolder().getHomePositions(opponentPawn.getPlayer().getColor());


                    Field firstHomePosition = fieldsInArray.stream()
                            .filter(field -> field.getPosition() == newPositionOfOpponent)
                            .findFirst().get();
                    Field secondHomePosition = fieldsInArray.stream()
                            .filter(field -> field.getPosition() == newPositionOfOpponent + 1)
                            .findFirst().get();
                    Field thirdHomePosition = fieldsInArray.stream()
                            .filter(field -> field.getPosition() == newPositionOfOpponent + 2)
                            .findFirst().get();
                    Field fourthHomePosition = fieldsInArray.stream()
                            .filter(field -> field.getPosition() == newPositionOfOpponent + 3)
                            .findFirst().get();
                    Field newFieldOfOpponent = secondHomePosition;
                    if (firstHomePosition.getPawn() == null) {
                        newFieldOfOpponent = firstHomePosition;

                    } else if (secondHomePosition.getPawn() == null) {
                        newFieldOfOpponent = secondHomePosition;
                    } else if (thirdHomePosition.getPawn() == null) {
                        newFieldOfOpponent = thirdHomePosition;
                    } else if (fourthHomePosition.getPawn() == null) {
                        newFieldOfOpponent = fourthHomePosition;
                    }

                    Pawn newOpponentPawn = newField.getPawn();
                    newField.getPawn().setField(newFieldOfOpponent);
                    newFieldOfOpponent.setPawn(newOpponentPawn);
                }
            }
        }

    }




    public void move(Field oldField, Field newField, Pawn pawn) {
        newField.setPawn(pawn);
        oldField.setPawn(null);
        pawn.setField(newField);

        if (inProgressToSet) {
            pawn.setProgress(Progress.IN_PROGRESS);

        }
        if (endToSet) {
            pawn.setProgress(Progress.END);

        }

        inProgressToSet = false;
        endToSet = false;

    }


    private int calculatePosition(Pawn pawn, int diceValue) {

        Progress actualProgress = pawn.getProgress();
        int actualPosition = pawn.getField().getPosition();
        int newPosition = actualPosition;

        PositionsHolder holder = pawn.getPlayer().getPositionsHolder();
        Color playersColor = pawn.getPlayer().getColor();

        switch (actualProgress) {
            case START:
                if (diceValue == 6) {
                    newPosition = holder.getFirstCircle(playersColor);

                    inProgressToSet = true;
                }
                break;

            case IN_PROGRESS:
                if (playersColor != Color.BLUE) {
                    if (actualPosition >= holder.getFirstCircle(playersColor)) {
                        if (actualPosition + diceValue == 40) {
                            newPosition = (actualPosition + diceValue);

                        } else {
                            newPosition = (actualPosition + diceValue) % 40;

                        }
                    }
                    if (actualPosition < holder.getFirstCircle(playersColor)) {
                        if (actualPosition + diceValue <= holder.getLastCircle(playersColor)) {
                            newPosition = actualPosition + diceValue;

                        } else if (actualPosition + diceValue + 50 <= holder.getLastWinningPosition(playersColor)) {
                            newPosition = actualPosition + diceValue + 50;
                            endToSet = true;

                        }
                    }
                }
                if (playersColor == Color.BLUE) {
                    int lastCircle = holder.getLastCircle(playersColor);


                    if (actualPosition + diceValue <= lastCircle) {
                        newPosition = actualPosition + diceValue;


                    } else if (actualPosition + diceValue > lastCircle) {
                        if (actualPosition + diceValue + 50 <= holder.getLastWinningPosition(playersColor)) {
                            newPosition = actualPosition + diceValue + 50;

                            endToSet = true;
                        }
                    }
                }
                break;
            case END:
                if (actualPosition + diceValue <= holder.getLastWinningPosition(playersColor)) {
                    newPosition = actualPosition + diceValue;

                }
        }
        return newPosition;

    }
}

