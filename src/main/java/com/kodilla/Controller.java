package com.kodilla;

import com.kodilla.view.Color;
import com.kodilla.window.AlertBox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller implements Serializable {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    public Map<String, Field> getFields() {
        return fields;
    }

    public ArrayList<Field> getFieldsInArray() {
        return fieldsInArray;
    }

    private ArrayList<Field> fieldsInArray = new ArrayList<>();



    boolean inProgressToSet;
    boolean endToSet;
    boolean playerDidMove = false;

    public  int counter = 0;


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

        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();

        Player computer = computerField.getPawn().getPlayer();


        try {
            int diceValue = DiceService.getInstance().getDiceResult();

            Pawn clickedPawn = field.getPawn();
            play(clickedPawn, diceValue);



            //playing time
         /*   Field oldField = clickedPawn.getField();

            int newFieldPosition = calculatePosition(clickedPawn, diceValue);

            Field newField = fieldsInArray.stream()
                    .filter(f -> f.getPosition() == newFieldPosition)
                    .findFirst().get();
            changeOpponentPosition( newField, clickedPawn);
            checkIfCanMove(oldField,newField,clickedPawn);
            movePawn(oldField,newField,clickedPawn);*/

            //end of playing time


            checkIfHasWon(clickedPawn.getPlayer());


            System.out.println(clickedPawn.getPlayer().getP1().getField().position + " " + clickedPawn.getPlayer().getP1().getProgress() + "  " + clickedPawn.getPlayer().getP2().getField().position + " " + clickedPawn.getPlayer().getP2().getProgress() + "  " + clickedPawn.getPlayer().getP3().getField().position + " " + clickedPawn.getPlayer().getP3().getProgress() + "  " + clickedPawn.getPlayer().getP4().getField().position + " " + clickedPawn.getPlayer().getP4().getProgress());


            /*
             * computerMove?
             */
            int compDiceResult = DiceService.getInstance().thowDice();
            System.out.println("Computer has dice value " + compDiceResult);

//            if(counter == 3 || playerDidMove == true) {
//                counter = 0;
//                playerDidMove = false;

                if(computer.getP1().getProgress()==Progress.START &&
                        computer.getP2().getProgress()==Progress.START &&
                        computer.getP3().getProgress()==Progress.START &&
                        computer.getP4().getProgress()==Progress.START) {

                    computerMove();

                    computerMove();

                    computerMove();

                } else {

                    computerMove();
                    checkIfHasWon(computer);
                }
        GameSaver.getInstance().saveMap();
         //   }
        } catch (Exception e) {
            System.out.println("No such move. Try again, choose correct pawn " + e.getMessage());
        }

    }

    public void newGame(){
        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player computer = computerField.getPawn().getPlayer();


        Field playersField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 1000)
                .findFirst().get();
        Player player = computerField.getPawn().getPlayer();

        int playerHomePosition = player.getPositionsHolder().getHomePositions(player.getColor());
        int computerHomePosition = computer.getPositionsHolder().getHomePositions(computer.getColor());

        Field newPlayersField = fieldsInArray.stream()
                .filter(field -> field.getPosition()==playerHomePosition)
                .findFirst().get();

        player.getP1().setField(newPlayersField);
        player.getP1().setProgress(Progress.START);
    }

    public void computerMove() {
        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player computer = computerField.getPawn().getPlayer();


        System.out.println("computer is moving");
        int compDiceResult = DiceService.getInstance().thowDice();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(4) + 1;


        if (compDiceResult == 6 && computer.getP1().getProgress() == Progress.START) {
            play(computer.p1, compDiceResult);

        } else if (compDiceResult == 6 && computer.getP2().getProgress() == Progress.START) {
            play(computer.p2, compDiceResult);

        } else if (compDiceResult == 6 && computer.getP3().getProgress() == Progress.START) {
            play(computer.p3, compDiceResult);

        } else if (compDiceResult == 6 && computer.getP4().getProgress() == Progress.START) {
            play(computer.p4, compDiceResult);
        }


       else if (randomNumber == 1 && computer.getP1().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p1, compDiceResult);
        }
        else if (randomNumber == 2 && computer.getP2().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p2, compDiceResult);
        }
        else if (randomNumber == 3 && computer.getP3().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p3, compDiceResult);
        }
        else if (randomNumber == 4 && computer.getP4().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p4, compDiceResult);
        }

        else if (computer.getP1().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p1, compDiceResult);

        }
        else if (computer.getP2().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p2, compDiceResult);
        }
        else if (computer.getP3().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p3, compDiceResult);
        }
        else if (computer.getP4().getProgress()==Progress.IN_PROGRESS) {
            play(computer.p4, compDiceResult);
        }
        else if (randomNumber == 1 ) {
            play(computer.p1, compDiceResult);
        }
        else if (randomNumber == 2 ) {
            play(computer.p2, compDiceResult);
        }
        else if (randomNumber == 3) {
            play(computer.p3, compDiceResult);
        }
        else if (randomNumber == 4) {
            play(computer.p4, compDiceResult);
        }
        int playerDiceResult = DiceService.getInstance().thowDice();
        System.out.println("Player dice: "+playerDiceResult);
    }

    private void checkIfHasWon(Player player) {
        if ((player.getP1().getProgress() == Progress.END) && (player.getP2().getProgress() == Progress.END) && (player.getP3().getProgress() == Progress.END) && (player.getP4().getProgress() == Progress.END)) {
            System.out.println("Player " + player.getColor() + " has won!");

            AlertBox.display("We have a winner!","Someone has won!" );
        }
    }

    private void play(Pawn pawn, int diceValue) {

        Field oldField = pawn.getField();

        int newFieldPosition = calculatePosition(pawn, diceValue);

        Field newField = fieldsInArray.stream()
                .filter(field -> field.getPosition() == newFieldPosition)
                .findFirst().get();

        changeOpponentPosition(newField, pawn);
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
            playerDidMove = true;
            if (inProgressToSet) {
                pawn.setProgress(Progress.IN_PROGRESS);

            }
            if (endToSet) {
                pawn.setProgress(Progress.END);

            }


        } else if(pawn.getPlayer().getP1().getProgress()==Progress.START &&
                pawn.getPlayer().getP2().getProgress()==Progress.START &&
                pawn.getPlayer().getP3().getProgress()==Progress.START &&
                pawn.getPlayer().getP4().getProgress()==Progress.START ){
            counter++;
        }
        inProgressToSet = false;
        endToSet = false;
    }

    /*  public void checkIfCanMove(Field oldField, Field newField, Pawn pawn) {
          if (newField.getPawn() == null || newField.getPawn().getPlayer() != pawn.getPlayer()) {
              pawn.setPawnCanMove(true);
   *//*           newField.setPawn(pawn);
            oldField.setPawn(null);
            pawn.setField(newField);
            if (inProgressToSet) {
                pawn.setProgress(Progress.IN_PROGRESS);

            }
            if (endToSet) {
                pawn.setProgress(Progress.END);

            }*//*

        }
     *//*   inProgressToSet = false;
        endToSet = false;
        return false;*//*
    }*/
    public void movePawn(Field oldField, Field newField, Pawn pawn) {
        if (pawn.isPawnCanMove()) {
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
                        } else if (actualPosition + diceValue + 50 <= holder.getLastWinningPosition(playersColor)) {
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

