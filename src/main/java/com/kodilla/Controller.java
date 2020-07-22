package com.kodilla;

import static com.kodilla.FillUtils.fill;

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
        try {


            System.out.println(String.format("Element clicked col %s, row %s", field.getRow(), field.getCol()));
            System.out.println("you clicked" + field.getPosition());


            int fieldClicked = field.getPosition();
            System.out.println("field clicked " + fieldClicked);
            int diceValue = DiceService.getInstance().getDiceResult();
            field.getPlayer().resetNewPosition();
            field.getPlayer().calculateNewAvailablePositions(diceValue);
            int newPosition = field.getPlayer().choosePawnToMove(fieldClicked);
            System.out.println("new position " + newPosition + field.getPlayer().color);

            //     System.out.println(String.format("Player dice value is %s", diceValue));
            //   int currentPosition = field.getPosition() % 100;
            //   int currentPosition = field.getPlayer().newAvailablePosition1;
            //   int newPosition = currentPosition + diceValue;

            Field fieldToTake = fieldsInArray.stream()
                    .filter(f -> f.getPosition() == newPosition)
                    .findFirst()
                    .get();

            if(fieldToTake.getPlayer() != null && fieldToTake.getPlayer() != field.getPlayer()) {
                field.getPlayer().changeOpponentsPosition(field.getPlayer(), fieldToTake.getPlayer());
            }
            fieldToTake.setPlayer(field.getPlayer());

            if(fieldToTake != field) {
                field.setFill(fill("circle.png"));
                if (fieldToTake.position == fieldToTake.getPlayer().p1){
                    Player player = fieldToTake.getPlayer();
                    int fieldNUmber = player.p1HomePosition;
                    Field fieldToSetPlayer = fieldsInArray.stream()
                            .filter(f -> f.getPosition() == fieldNUmber)
                            .findFirst()
                            .get();
                    fieldToSetPlayer.player = fieldToTake.getPlayer();
                }
                if (fieldToTake.position == fieldToTake.getPlayer().p2){
                    Player player = fieldToTake.getPlayer();
                    int fieldNUmber = player.p2HomePosition;
                    Field fieldToSetPlayer = fieldsInArray.stream()
                            .filter(f -> f.getPosition() == fieldNUmber)
                            .findFirst()
                            .get();
                    fieldToSetPlayer.player = fieldToTake.getPlayer();
                }
                if (fieldToTake.position == fieldToTake.getPlayer().p3){
                    Player player = fieldToTake.getPlayer();
                    int fieldNUmber = player.p3HomePosition;
                    Field fieldToSetPlayer = fieldsInArray.stream()
                            .filter(f -> f.getPosition() == fieldNUmber)
                            .findFirst()
                            .get();
                    fieldToSetPlayer.player = fieldToTake.getPlayer();
                }
                if (fieldToTake.position == fieldToTake.getPlayer().p4){
                    Player player = fieldToTake.getPlayer();
                    int fieldNUmber = player.p4HomePosition;
                    Field fieldToSetPlayer = fieldsInArray.stream()
                            .filter(f -> f.getPosition() == fieldNUmber)
                            .findFirst()
                            .get();
                    fieldToSetPlayer.player = fieldToTake.getPlayer();
                }
                field.removePlayerFromField();

            }


            /*
             * computerMove?
             */
        }
        catch (Exception e){
            System.out.println("No such move. Try again, choose correct pawn");
        }

    }

}
