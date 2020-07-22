package com.kodilla;

import static com.kodilla.FillUtils.fill;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class Field extends Rectangle {

    private int col, row = 0;
    int position;
    Player player;

    public Field(Image image) {
        super(65, 65, new ImagePattern(image));

        setOnMouseClicked(mouseEvent -> {
            System.out.println(String.format("Element clicked col %s, row %s", -1, -1));
            setFill(new ImagePattern(new Image("black.png",65,65,false,false)));
        });
    }

    public Field(int col, int row, int position) {
        super(65, 65, fill("circle.png"));
        this.col = col;
        this.row = row;
        this.position = position;

        setOnMouseClicked(mouseEvent -> Controller.getController().clicked(this));
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        Color playerColor = player.getColor();
        this.setFill(fill(String.format("%s pawn.png", playerColor.name().toLowerCase())));
    }

    @Override
    public String toString() {
        return "Field{" +
                "position=" + position +
                '}';
    }

    public void removePlayerFromField(){
        this.player = null;
    }
}
