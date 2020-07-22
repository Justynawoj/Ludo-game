package com.kodilla;

public class Pawn {

    private Player player;
    private Field field;

    public Pawn(Player player, Field field) {
        this.player = player;
        this.field = field;

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Player getPlayer() {
        return player;
    }

}
