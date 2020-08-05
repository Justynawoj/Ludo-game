package com.kodilla;

import java.io.Serializable;

public class PositionsHolder implements Serializable {

    Pawn pawn;
    Color color;
    Progress progress;



    int getHomePositions(Color color){
        int position = 0;
        switch (color){
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
    int getFirstCircle(Color color) {
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
    int getLastCircle(Color color) {
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

    int getWinningPosition(Color color) {
        int position = 0;
        switch (color) {
            case BLUE:
                position = 91;
                break;
            case RED:
                position = 61;
                break;
            case YELLOW:
                position = 71;
                break;
            case GREEN:
                position = 81;

        }
        return position;
    }
    int getLastWinningPosition(Color color) {
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
