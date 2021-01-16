package com.kodilla;

import static com.kodilla.view.FillUtils.fill;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class DiceService {

    private static final Random RANDOM = new Random();
    private static final DiceService INSTANCE = new DiceService();
    private int diceResult;
    private Button throwDiceButton;
    private GridPane grid;

    public static DiceService getInstance() {
        return INSTANCE;
    }

    private DiceService() {
    }

    public int getDiceResult() {
        return diceResult;
    }

    public int thowDice() {
        diceResult = RANDOM.nextInt(6) + 1;
        System.out.println("Dice result " + diceResult);

        Field diceHolder = new Field(5, 5, 555);
        this.grid.add(diceHolder, 5, 5);
        switch (diceResult) {
            case 1:
                diceHolder.setFill(fill("dice1.png"));
                break;
            case 2:
                diceHolder.setFill(fill("dice2.png"));
                break;
            case 3:
                diceHolder.setFill(fill("dice3.png"));
                break;
            case 4:
                diceHolder.setFill(fill("dice4.png"));
                break;
            case 5:
                diceHolder.setFill(fill("dice5.png"));
                break;
            case 6:
                diceHolder.setFill(fill("dice6.png"));
                break;
        }
        return diceResult;
    }

    public void addGrid(GridPane grid) {
        this.grid = grid;
        this.throwDiceButton = new Button("Throw dice");
        grid.add(throwDiceButton, 12, 1, 1, 1);
        throwDiceButton.setOnAction(event -> thowDice());
    }
}
