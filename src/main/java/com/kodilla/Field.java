package com.kodilla;

import static com.kodilla.view.FillUtils.fill;

import java.io.Serializable;

import com.kodilla.view.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Field extends Rectangle implements Serializable {

    private int col, row = 0;
    int position;
    Pawn pawn;

    public Field(Image image) {
        super(65, 65, new ImagePattern(image));
    }

    public Field(int col, int row, int position) {
        super(65, 65, fill("circle.png"));
        this.col = col;
        this.row = row;
        this.position = position;
        PositionsHolder holder = new PositionsHolder();

        setOnMouseClicked(mouseEvent -> Controller.getController().clicked(this));
    }

    public Pawn getPawn() {
        return pawn;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getPosition() {
        return position;
    }


    public void setPawn(Pawn pawn) {
        PositionsHolder holder = new PositionsHolder();
        if (pawn == null) {
            this.pawn = null;
            if (this.getPosition() == holder.getHomePositions(Color.YELLOW) ||
                    this.getPosition() == (holder.getHomePositions(Color.YELLOW) + 1) ||
                    this.getPosition() == (holder.getHomePositions(Color.YELLOW) + 2) ||
                    this.getPosition() == (holder.getHomePositions(Color.YELLOW) + 3) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.YELLOW)) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.YELLOW) - 1) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.YELLOW) - 2) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.YELLOW) - 3)) {
                this.setFill(fill(String.format("yellow.png")));

            } else if (this.getPosition() == holder.getHomePositions(Color.BLUE) ||
                    this.getPosition() == (holder.getHomePositions(Color.BLUE) + 1) ||
                    this.getPosition() == (holder.getHomePositions(Color.BLUE) + 2) ||
                    this.getPosition() == (holder.getHomePositions(Color.BLUE) + 3) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.BLUE)) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.BLUE) - 1) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.BLUE) - 2) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.BLUE) - 3)) {
                this.setFill(fill(String.format("blue.png")));

            } else if (this.getPosition() == holder.getHomePositions(Color.RED) ||
                    this.getPosition() == (holder.getHomePositions(Color.RED) + 1) ||
                    this.getPosition() == (holder.getHomePositions(Color.RED) + 2) ||
                    this.getPosition() == (holder.getHomePositions(Color.RED) + 3) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.RED)) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.RED) - 1) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.RED) - 2) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.RED) - 3)) {
                this.setFill(fill(String.format("red.png")));

            } else if (this.getPosition() == holder.getHomePositions(Color.GREEN) ||
                    this.getPosition() == (holder.getHomePositions(Color.GREEN) + 1) ||
                    this.getPosition() == (holder.getHomePositions(Color.GREEN) + 2) ||
                    this.getPosition() == (holder.getHomePositions(Color.GREEN) + 3) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.GREEN)) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.GREEN) - 1) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.GREEN) - 2) ||
                    this.getPosition() == (holder.getLastWinningPosition(Color.GREEN) - 3)) {
                this.setFill(fill(String.format("green.png")));
            } else {
                this.setFill(fill(String.format("circle.png")));
            }
        } else {
            this.pawn = pawn;
            Color playerColor = pawn.getPlayer().getColor();
            this.setFill(fill(String.format("%s pawn.png", playerColor.name().toLowerCase())));
        }
    }

    @Override
    public String toString() {
        return "Im a field number " +
                position +
                ", and a have this pawn: " + pawn;
    }
}
