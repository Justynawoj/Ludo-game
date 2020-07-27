package com.kodilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    private ArrayList<Field> fieldsInArray = new ArrayList<>();

    boolean inProgressToSet;
    boolean endToSet;


    private Controller() {
    }

    public static Controller getController() {
        return INSTANCE;
    }

    void addField(Field field) {
        this.fields.put(String.format("%s-%s", field.getCol(), field.getRow()), field);
        this.fieldsInArray.add(field);
    }

    public void clicked(Field field) {
        try {

            int diceValue = DiceService.getInstance().getDiceResult();

            Pawn clickedPawn = field.getPawn();
            move(clickedPawn, diceValue);
            checkIfHasWon(clickedPawn.getPlayer());


            System.out.println(clickedPawn.getPlayer().getP1().getField().position +" "+ clickedPawn.getPlayer().getP1().getProgress()+ "  " + clickedPawn.getPlayer().getP2().getField().position +" "+ clickedPawn.getPlayer().getP2().getProgress()+ "  "+clickedPawn.getPlayer().getP3().getField().position + " "+ clickedPawn.getPlayer().getP3().getProgress()+ "  " + clickedPawn.getPlayer().getP4().getField().position +" "+ clickedPawn.getPlayer().getP4().getProgress());
            /*
             * computerMove?
             */
        } catch (Exception e) {
            System.out.println("No such move. Try again, choose correct pawn " + e.getMessage());
        }

    }

    private void checkIfHasWon(Player player) {
        if ((player.getP1().getProgress() == Progress.END) &&(player.getP2().getProgress() == Progress.END) &&(player.getP3().getProgress() == Progress.END) &&(player.getP4().getProgress() == Progress.END)){
            System.out.println("Player "+ player.getColor()+" has won!");
        }
    }

    private void move(Pawn pawn, int diceValue) {

        Field oldField = pawn.getField();

        int newFieldPosition = calculatePosition(pawn, diceValue);

        Field newField = fieldsInArray.stream()
                .filter(field -> field.getPosition() == newFieldPosition)
                .findFirst().get();

        changeOpponentPosition( newField, pawn);
        checkIfCanMove(oldField, newField, pawn);
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


    public void checkIfCanMove(Field oldField, Field newField, Pawn pawn) {
        if (newField.getPawn() == null || newField.getPawn().getPlayer() != pawn.getPlayer()) {
            newField.setPawn(pawn);
            oldField.setPawn(null);
            pawn.setField(newField);
            if (inProgressToSet) {
                pawn.setProgress(Progress.IN_PROGRESS);

            }
            if (endToSet) {
                pawn.setProgress(Progress.END);

            }

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
                        }
                        else if (actualPosition + diceValue + 50 <= holder.getLastWinningPosition(playersColor)) {
                            newPosition = actualPosition + diceValue + 50;
                            endToSet = true;

                        }
                    }
                }
                if (playersColor == Color.BLUE) {
                    int lastCircle = holder.getLastCircle(playersColor);
                    System.out.println(lastCircle);

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

