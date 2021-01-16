package com.kodilla;

import com.kodilla.state.Progress;
import com.kodilla.view.Color;
import com.kodilla.window.ConfirmBox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Controller implements Serializable {

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

        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player computer = computerField.getPawn().getPlayer();

        try {

            System.out.println("new turn");
            int diceValue = DiceService.getInstance().getDiceResult();
            Pawn clickedPawn = field.getPawn();
            play(clickedPawn, diceValue);
            checkIfHasWon(clickedPawn.getPlayer());

            if (computer.getP1().getProgress() == Progress.START &&
                    computer.getP2().getProgress() == Progress.START &&
                    computer.getP3().getProgress() == Progress.START &&
                    computer.getP4().getProgress() == Progress.START) {

                computerMove();
                computerMove();
                computerMove();

                int playerDiceResult = DiceService.getInstance().thowDice();
                System.out.println("Player dice: " + playerDiceResult);
            } else {
                computerMove();
                checkIfHasWon(computer);
                int playerDiceResult = DiceService.getInstance().thowDice();
                System.out.println("Player dice: " + playerDiceResult);
            }
        } catch (Exception e) {
            System.out.println("No such move. Try again, choose correct pawn " + e.getMessage());
        }
    }

    public void newGame() {
        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player comp = computerField.getPawn().getPlayer();

        Field playersField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 1000)
                .findFirst().get();
        Player player = playersField.getPawn().getPlayer();

        player.getP1().setProgress(Progress.START);
        player.getP2().setProgress(Progress.START);
        player.getP3().setProgress(Progress.START);
        player.getP4().setProgress(Progress.START);

        player.getP1().getField().setPawn(null);
        player.getP2().getField().setPawn(null);
        player.getP3().getField().setPawn(null);
        player.getP4().getField().setPawn(null);

        Field field101 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 101)
                .findFirst().get();
        Field field102 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 102)
                .findFirst().get();
        Field field103 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 103)
                .findFirst().get();
        Field field104 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 104)
                .findFirst().get();

        player.getP1().setField(field101);
        player.getP2().setField(field102);
        player.getP3().setField(field103);
        player.getP4().setField(field104);

        player.getP1().getField().setPawn(player.getP1());
        player.getP2().getField().setPawn(player.getP2());
        player.getP3().getField().setPawn(player.getP3());
        player.getP4().getField().setPawn(player.getP4());

        comp.getP1().setProgress(Progress.START);
        comp.getP2().setProgress(Progress.START);
        comp.getP3().setProgress(Progress.START);
        comp.getP4().setProgress(Progress.START);

        comp.getP1().getField().setPawn(null);
        comp.getP2().getField().setPawn(null);
        comp.getP3().getField().setPawn(null);
        comp.getP4().getField().setPawn(null);

        Field field125 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 125)
                .findFirst().get();
        Field field126 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 126)
                .findFirst().get();
        Field field127 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 127)
                .findFirst().get();
        Field field128 = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 128)
                .findFirst().get();

        comp.getP1().setField(field125);
        comp.getP2().setField(field126);
        comp.getP3().setField(field127);
        comp.getP4().setField(field128);

        comp.getP1().getField().setPawn(comp.getP1());
        comp.getP2().getField().setPawn(comp.getP2());
        comp.getP3().getField().setPawn(comp.getP3());
        comp.getP4().getField().setPawn(comp.getP4());
    }

    public void computerMove() {
        //getting computer player from the reference field
        Field computerField = fieldsInArray.stream()
                .filter(f -> f.getPosition() == 3000)
                .findFirst().get();
        Player computer = computerField.getPawn().getPlayer();

        int compDiceResult = DiceService.getInstance().thowDice();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(4) + 1;

        //if 6 go out from home position
        if (compDiceResult == 6 && computer.getP1().getProgress() == Progress.START) {
            play(computer.getP1(), compDiceResult);
        } else if (compDiceResult == 6 && computer.getP2().getProgress() == Progress.START) {
            play(computer.getP2(), compDiceResult);
        } else if (compDiceResult == 6 && computer.getP3().getProgress() == Progress.START) {
            play(computer.getP3(), compDiceResult);
        } else if (compDiceResult == 6 && computer.getP4().getProgress() == Progress.START) {
            play(computer.getP4(), compDiceResult);
        }
        // if out of home position choose random pawn
        else if (randomNumber == 1 && computer.getP1().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP1(), compDiceResult);
        } else if (randomNumber == 2 && computer.getP2().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP2(), compDiceResult);
        } else if (randomNumber == 3 && computer.getP3().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP3(), compDiceResult);
        } else if (randomNumber == 4 && computer.getP4().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP4(), compDiceResult);
        }
        // if chosen random pawn not in progress take first in progress available
        else if (computer.getP1().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP1(), compDiceResult);
        } else if (computer.getP2().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP2(), compDiceResult);
        } else if (computer.getP3().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP3(), compDiceResult);
        } else if (computer.getP4().getProgress() == Progress.IN_PROGRESS) {
            play(computer.getP4(), compDiceResult);
        }
        //if none of above available choose the casual one
        else if (randomNumber == 1) {
            play(computer.getP1(), compDiceResult);
        } else if (randomNumber == 2) {
            play(computer.getP2(), compDiceResult);
        } else if (randomNumber == 3) {
            play(computer.getP3(), compDiceResult);
        } else if (randomNumber == 4) {
            play(computer.getP4(), compDiceResult);
        }
    }

    private void checkIfHasWon(Player player) {
        boolean result = false;
        if ((player.getP1().getProgress() == Progress.END) && (player.getP2().getProgress() == Progress.END) && (player.getP3().getProgress() == Progress.END) && (player.getP4().getProgress() == Progress.END)) {
            if (player.color == Color.BLUE) {
                result = ConfirmBox.display("Won!", "Congratulation, you Won! \nDo you want to start over?");
            } else {
                result = ConfirmBox.display("Game over!", "You loose! \nDo you want to start over?");
            }
            if (result) {
                newGame();
            }
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
