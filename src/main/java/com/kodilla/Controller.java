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
//        public int clicked(Field field, Player player) {
//            int pawnChosen = 0;
//            if (player.color.equalsIgnoreCase("blue")) {
//                if (field.position == player.p1) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition1).setFill(new ImagePattern(new Image("blue pawn.png", 70, 70, false, false)));
//                    pawnChosen = 1;
//                }
//                if (field.position == player.p2) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition2).setFill(new ImagePattern(new Image("blue pawn.png", 70, 70, false, false)));
//                    pawnChosen = 2;
//                }
//                if (field.position == player.p3) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition3).setFill(new ImagePattern(new Image("blue pawn.png", 70, 70, false, false)));
//                    pawnChosen = 3;
//                }
//                if (field.position == player.p4) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition4).setFill(new ImagePattern(new Image("blue pawn.png", 70, 70, false, false)));
//                    pawnChosen = 4;
//                }
//            }
//            if (player.color.equalsIgnoreCase("red")) {
//                if (field.position == player.p1) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition1).setFill(new ImagePattern(new Image("red pawn.png", 70, 70, false, false)));
//                    pawnChosen = 1;
//                }
//                if (field.position == player.p2) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition2).setFill(new ImagePattern(new Image("red pawn.png", 70, 70, false, false)));
//                    pawnChosen = 2;
//                }
//                if (field.position == player.p3) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition3).setFill(new ImagePattern(new Image("red pawn.png", 70, 70, false, false)));
//                    pawnChosen = 3;
//                }
//                if (field.position == player.p4) {
//                    field.setFill(new ImagePattern(new Image("circle.png", 70, 70, false, false)));
//                    fieldsInArray.get(player.newAvailablePosition4).setFill(new ImagePattern(new Image("red pawn.png", 70, 70, false, false)));
//                    pawnChosen = 4;
//                }
//            }
//            return pawnChosen;

        System.out.println(String.format("Element clicked col %s, row %s", field.getRow(), field.getCol()));
        //   field.setFill(new ImagePattern(new Image("black.png",70,70,false,false)));
        System.out.println("you clicked" + field.getPosition());
        //    fields.entrySet().stream()
        //             .forEach(stringFieldEntry -> stringFieldEntry.getValue().setFill(new ImagePattern(new Image("circle.png",70,70,false,false))));

        }





//    public void setPawns(Player player1, Player player2) {
//        int number = player1.p1;
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
//
//        for (int i = 0; i<fieldsInArray.size();i++){
//            System.out.println(fieldsInArray.get(i).position + " " +i);
//        }
////        for (int i = 0; i<fieldsInArray.size();i++){
////            if(fieldsInArray.get(i).getPosition() == number){
////                fieldsInArray.get(i).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
////
////            }
////
////        }
////
//    }

}
