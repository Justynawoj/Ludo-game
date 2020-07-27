package com.kodilla;

public class Pawn {

    private Player player;
    private Field field;
    private Progress progress;


    @Override
    public String toString() {
        return "im a " +
                  player.getColor() +
                " pawn on the field no" + field.getPosition() + "My progress is "+ getProgress();
    }

    public Pawn(Player player, Field field) {
        this.player = player;
        this.field = field;
        this.progress = Progress.START;

    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
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
