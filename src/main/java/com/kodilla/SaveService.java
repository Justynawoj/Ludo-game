package com.kodilla;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SaveService {

    private GridPane gridPane;
    private Button saveButton;
    private Button loadButton;

    public SaveService(GridPane gridPane, Controller controller) {
        this.gridPane = gridPane;
        saveButton = new Button();
        saveButton.setOnAction(actionEvent -> {
            System.out.println("save !");
            writeObjectToFile(controller);
        });
        saveButton.setText("SAVE");

        loadButton = new Button();
        loadButton.setOnAction(actionEvent -> {
            System.out.println("load !");
            Controller controllerReturned = loadObjectFromFile();
            System.out.println();
        });
        loadButton.setText("LOAD");

        gridPane.add(saveButton, 11, 8);
        gridPane.add(loadButton, 12, 8);
        System.out.println();
    }

    public void writeObjectToFile(Object serObj) {

        try {
            FileOutputStream f = new FileOutputStream(new File("controller.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(serObj);

            o.close();
            f.close();

            System.out.println("The Object  was succesfully written to a file");

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

            oi.close();
            fi.close();

            return controller;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
