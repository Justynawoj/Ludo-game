package com.kodilla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javax.jws.soap.SOAPBinding;

//import static com.kodilla.User.throwDice;

public class Controller {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    private ArrayList<Field> fieldsInArray = new ArrayList<>();
    ArrayList<Field> bluePawns = new ArrayList<>();

    private Controller() {
    }

    public static Controller getController() {
        return INSTANCE;
    }

    void addField(Field field){
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
//    public void setPawns( User user1,User user2){
//        int number = user1.p1;
//
//        for (int i = 0; i<fieldsInArray.size();i++){
//            if(fieldsInArray.get(i).getPosition() == number){
//                fieldsInArray.get(i).setFill(new ImagePattern(new Image("blue pawn.png",70,70,false,false)));
//
//            }
//   //         System.out.println(fieldsInArray.get(i));
//        }
//  //      System.out.println(user1.p1);
//
//    }
//    public void removeOldPawnsPosition(User user1,User user2){
//    /*    Field newField = fieldsInArray.get(user1.p1);
//        for (int i = 0; i<fieldsInArray.size();i++){
//            if((fieldsInArray.get(i).getPosition() != user1.p1)&&(fieldsInArray.get(i).getPosition() != user1.p2)&&
//                    (fieldsInArray.get(i).getPosition() != user1.p3)&&(fieldsInArray.get(i).getPosition() != user1.p4)&&
//                    (fieldsInArray.get(i).getPosition() != user2.p1)&&(fieldsInArray.get(i).getPosition() != user2.p2)&&
//                    (fieldsInArray.get(i).getPosition() != user2.p3)&&(fieldsInArray.get(i).getPosition() != user2.p4)){
//                newField.setFill(new ImagePattern(new Image("circle.png",70,70,false,false)));
//
//            }
//            System.out.println(fieldsInArray.get(i));
//        }
//        System.out.println(user1.p1);
//*/
//    }
//    public void putBluePawnsToArray(User user){
//
//        int pawn1 = user.p1;
//        int pawn2 = user.p2;
//        int pawn3 = user.p3;
//        int pawn4 = user.p4;
//
//        bluePawns.add(fieldsInArray.get(pawn1));
//        bluePawns.add(fieldsInArray.get(pawn2));
//        bluePawns.add(fieldsInArray.get(pawn3));
//        bluePawns.add(fieldsInArray.get(pawn4));
//
//    }

}
