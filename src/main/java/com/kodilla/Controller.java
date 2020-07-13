package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Controller {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    private ArrayList<Field> fieldsInArray = new ArrayList<>();


    private Controller() {
    }

    public static Controller getController() {
        return INSTANCE;
    }

    void addField(Field field) {
        this.fields.put(String.format("%s-%s", field.getCol(), field.getRow()), field);
        this.fieldsInArray.add(field);
    }

    public void clicked(Field field) {
        System.out.println(String.format("Element clicked col %s, row %s", field.getRow(), field.getCol()));
        //   field.setFill(new ImagePattern(new Image("black.png",70,70,false,false)));
        System.out.println("you clicked" + field.getPosition());
        //    fields.entrySet().stream()
        //             .forEach(stringFieldEntry -> stringFieldEntry.getValue().setFill(new ImagePattern(new Image("circle.png",70,70,false,false))));
    }

    public void setPawns(Player player1, Player player2) {
        int number = player1.p1;
//        int pawn1 = player1.p1;
//        int pawn2 = player1.p2;
//        int pawn3 = player1.p3;
//        int pawn4 = player1.p4;
//
//        for (int i = 0; i<fieldsInArray.size();i++){
//            if( i!= pawn1 && i!= pawn2 && i!= pawn3 && i!= pawn4){
//                fieldsInArray.get(i).setFill(new ImagePattern(new Image("circle.png",70,70,false,false)));
//            }
//        }
//
//        fieldsInArray.get(pawn1).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//
//        fieldsInArray.get(pawn2).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//
//        fieldsInArray.get(pawn3).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//
//        fieldsInArray.get(pawn4).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//


//        for (int i = 0; i<fieldsInArray.size();i++){
//            if(fieldsInArray.get(i).getPosition() == number){
//                fieldsInArray.get(i).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//
//            }
//
        //}

    }

}
