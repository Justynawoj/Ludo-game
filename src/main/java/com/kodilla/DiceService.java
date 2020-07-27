package com.kodilla;

import java.util.Random;

public class DiceService {

    private static final Random RANDOM = new Random();
    private static final DiceService INSTANCE = new DiceService();
    private int diceResult;

    public static DiceService getInstance(){
        return INSTANCE;
    }

    private DiceService(){
        trowDice();
    }

    void trowDice() {
        diceResult = RANDOM.nextInt(6) + 1;
    }

    public int getDiceResult() {
        return diceResult;
    }

}
