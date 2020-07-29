package com.kodilla;

import static com.kodilla.FillUtils.fill;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    /**
     * dice -> nothing
     * play move -> move -> computer dice -> comp move
     *
     */

    public int thowDice() {
        diceResult = RANDOM.nextInt(6) + 1;
        System.out.println("Dice result " + diceResult);

        Label diceLabel2 = new Label(String.format("Dice: %s", DiceService.getInstance().getDiceResult()));
        Field field200 = new Field(16, 0, 200);
        this.grid.add(field200, 16, 0);
        field200.setFill(fill("yellow.png"));
        this.grid.add(diceLabel2, 16, 0, 1, 1);

        return diceResult;
    }

    public void addGrid(GridPane grid) {
        this.grid = grid;
        this.throwDiceButton = new Button("Throw dice");
        grid.add(throwDiceButton, 12, 1, 1, 1);

        throwDiceButton.setOnAction(event -> thowDice());
    }
}
