package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Field extends Rectangle {

    private int col, row = 0;

    public Field(Image image) {
        super(70, 70, new ImagePattern(image));

        setOnMouseClicked(mouseEvent -> {
            System.out.println(String.format("Element clicked col %s, row %s", -1, -1));
            setFill(new ImagePattern(new Image("black.png",70,70,false,false)));
        });
    }

    public Field(int col, int row) {
        super(70, 70, new ImagePattern(new Image("circle.png",70,70,false,false)));
        this.col = col;
        this.row = row;

        setOnMouseClicked(mouseEvent -> Controller.getController().clicked(this));
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
