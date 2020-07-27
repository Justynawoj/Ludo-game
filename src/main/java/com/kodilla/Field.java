package com.kodilla;

import static com.kodilla.FillUtils.fill;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class Field extends Rectangle {

    private int col, row = 0;
    int position;
    Pawn pawn;

    public Field(Image image) {
        super(65, 65, new ImagePattern(image));

    /*    setOnMouseClicked(mouseEvent -> {
            System.out.println(String.format("Element clicked col %s, row %s", -1, -1));
            setFill(new ImagePattern(new Image("black.png",65,65,false,false)));
        });
  */  }

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
