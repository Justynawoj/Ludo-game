package com.kodilla;

import javafx.event.ActionEvent;

public class Player extends ActionEvent {

    PositionsHolder positionsHolder;
    Pawn p1;
    Pawn p2;
    Pawn p3;
    Pawn p4;
    Pawn constant;


    public PositionsHolder getPositionsHolder() {
        return positionsHolder;
    }


    Color color;


    public Pawn getP1() {
        return p1;
    }

    public Pawn getP2() {
        return p2;
    }

    public Pawn getP3() {
        return p3;
    }

    public Pawn getP4() {
        return p4;
    }




    public Player(Field field1, Field field2, Field field3, Field field4, Field constant, Color color) {

        this.positionsHolder = new PositionsHolder();
        this.color = color;
        this.p1 = new Pawn(this, field1);
        field1.setPawn(p1);
        this.p2 = new Pawn(this, field2);
        field2.setPawn(p2);
        this.p3 = new Pawn(this, field3);
        field3.setPawn(p3);
        this.p4 = new Pawn(this, field4);
        field4.setPawn(p4);

        this.constant = new Pawn(this,constant);
        constant.setPawn(this.constant);

    }


      @Override
      public String toString() {
          return "Player [color=" + color + "]";
      }

      public Color getColor() {
        return color;
    }
}
