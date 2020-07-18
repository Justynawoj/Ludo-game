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
        System.out.println(String.format("Element clicked col %s, row %s", field.getRow(), field.getCol()));
        System.out.println("you clicked" + field.getPosition());


        /*
         * playerMove
         */
        int diceValue = DiceService.getInstance().getDiceResult();
        System.out.println(String.format("Player dice value is %s", diceValue));
        int currentPosition = field.getPosition() % 100;
        int newPosition = currentPosition + diceValue;
        Field fieldToTake = fieldsInArray.stream()
                .filter(f -> f.getPosition() == newPosition)
                .findFirst()
                .get();
        fieldToTake.setPlayer(field.getPlayer());
        field.setFill(fill("circle.png"));

        /*
         * computerMove?
         */

    }

}
