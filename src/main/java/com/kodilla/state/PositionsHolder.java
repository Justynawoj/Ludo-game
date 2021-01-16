package com.kodilla.state;

import com.kodilla.view.Color;

import java.io.Serializable;

public class PositionsHolder implements Serializable {

    public int getHomePositions(Color color) {
        int position = 0;
        switch (color) {
            case BLUE:
                position = 101;
                break;
            case RED:
                position = 115;
                break;
            case YELLOW:
                position = 125;
                break;
            case GREEN:
                position = 135;

        }
        return position;
    }

    public int getFirstCircle(Color color) {
        int position = 0;
        switch (color) {
            case BLUE:
                position = 1;
                break;
            case RED:
                position = 11;
                break;
            case YELLOW:
                position = 21;
                break;
            case GREEN:
                position = 31;

        }
        return position;
    }

    public int getLastCircle(Color color) {
        int position = 0;
        switch (color) {
            case BLUE:
                position = 40;
                break;
            case RED:
                position = 10;
                break;
            case YELLOW:
                position = 20;
                break;
            case GREEN:
                position = 30;

        }
        return position;
    }

    public int getLastWinningPosition(Color color) {
        int position = 0;
        switch (color) {
            case BLUE:
                position = 94;
                break;
            case RED:
                position = 64;
                break;
            case YELLOW:
                position = 74;
                break;
            case GREEN:
                position = 84;
        }
        return position;
    }
}
