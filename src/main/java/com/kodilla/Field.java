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
        if(pawn == null){
            this.pawn = null;
            this.setFill(fill(String.format("circle.png")));
        }
        else {
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
