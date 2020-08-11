package com.kodilla.window;

import com.kodilla.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.*;

public class SaveService {

    private GridPane gridPane;
    private Button saveButton;



    private Button loadButton;
    static Controller controllerReturned2;




    //public Controller SaveService(GridPane gridPane, Controller controller) {
    public  SaveService(GridPane gridPane, Controller controller) {
        this.gridPane = gridPane;
        saveButton = new Button();
        saveButton.setOnAction(actionEvent -> {
            writeObjectToFile(controller);
            System.out.println("save !");
            System.out.println(controller);
            controllerReturned2 = controller;

            System.out.println(controllerReturned2 + "saved gius");
        });
        saveButton.setText("SAVE");

        loadButton = new Button();
        loadButton.setOnAction(actionEvent -> {
            System.out.println("load !");
             Controller controllerReturned = loadObjectFromFile();
            controllerReturned2 = controllerReturned;

            System.out.println(controllerReturned2 + "loaded gius");

          //  System.out.println(controllerReturned + "controller returned");
         //
            //  controllerReturned.getFields().forEach((s, field) -> field.);
        //    controllerReturned2.getFieldsInArray();
         //   controllerReturned2.getFields();

        });
        loadButton.setText("LOAD");

        gridPane.add(saveButton, 11, 8);
        gridPane.add(loadButton, 12, 8);

     //   return controllerReturned2;
    }

    public void writeObjectToFile(Object serObj) {

        try {
            FileOutputStream f = new FileOutputStream(new File("controller.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(serObj);

            o.close();
            f.close();

            System.out.println("The Object  was successfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Controller loadObjectFromFile() {

        try {
            FileInputStream fi = new FileInputStream(new File("controller.txt"));

            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read object
            Controller controller = (Controller) oi.readObject();
            System.out.println(controller + "controller readed");
           // System.out.println("object has been loaded gius");

            oi.close();
            fi.close();

            return controller;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
