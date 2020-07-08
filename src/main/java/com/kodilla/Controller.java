package com.kodilla;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Controller {

    private static final Controller INSTANCE = new Controller();
    private Map<String, Field> fields = new HashMap<>();

    private Controller() {
    }

    public static Controller getController() {
        return INSTANCE;
    }

    void addField(Field field){
        this.fields.put(String.format("%s-%s", field.getCol(), field.getRow()), field);
    }

    public void clicked(Field field) {
        System.out.println(String.format("Element clicked col %s, row %s", field.getRow(), field.getCol()));
        field.setFill(new ImagePattern(new Image("black.png",70,70,false,false)));

        fields.entrySet().stream()
                .forEach(stringFieldEntry -> stringFieldEntry.getValue().setFill(new ImagePattern(new Image("yellow.png",70,70,false,false))));
    }
}
