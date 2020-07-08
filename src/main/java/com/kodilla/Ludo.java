package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import java.awt.*;

public class Ludo extends Application{

    private Image imageback = new Image("background1.png");
//    private Image circle = new Image("circle.png",70,70,false,false);
    private Image circle = new Image("blue.png",70,70,false,false);
    private Image blue = new Image("blue.png",70,70,false,false);
    private Image red = new Image("red.png",70,70,false,false);
    private Image yellow = new Image("yellow.png",70,70,false,false);
    private Image green = new Image("green.png",70,70,false,false);
    private Image black = new Image("black.png",70,70,false,false);



    private FlowPane circles = new FlowPane(Orientation.HORIZONTAL);
    private Controller controller = Controller.getController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);



        Label label = new Label("text");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(15, 15, 15, 15));
      //  grid.setHgap(5.5);
     //   grid.setVgap(5.5);
        grid.setBackground(background);

        Field img = new Field(circle);
        Field imgRed = new Field(red);
        Field imgYellow = new Field(yellow);
        Field imgBlue = new Field(blue);
        Field imgGreen = new Field(green);
        Field imgblack = new Field(black);

      //  circles.getChildren().addAll(img,imgblack,imgBlue,imgGreen,imgRed,imgYellow);







        grid.addColumn(4,new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(yellow),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle));
        grid.addColumn(5,new Field(circle),new Field(red),new Field(red),new Field(red),new Field(red),new Field(black),new Field(green),new Field(green),new Field(green),new Field(green),new Field(circle));
        grid.addColumn(6,new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(blue),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle));

        Field field04 = new Field(0, 4);
        grid.add(field04, 0, 4);
        controller.addField(field04);

        Field field05 = new Field(0, 5);
        grid.add(field05, 0, 5);
        controller.addField(field05);

        Field field06 = new Field(0, 6);
        grid.add(field06, 0, 6);
        controller.addField(field06);

        grid.addColumn(1,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(yellow),new Field(circle));
        grid.addColumn(2,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(yellow),new Field(circle));
        grid.addColumn(3,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(yellow),new Field(circle));
        grid.addColumn(7,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(blue),new Field(circle));
        grid.addColumn(8,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(blue),new Field(circle));
        grid.addColumn(9,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(blue),new Field(circle));
        grid.addColumn(10,new Text(""),new Text(""),new Text(""),new Text(""),new Field(circle),new Field(circle),new Field(circle));
        grid.add(new Field(circle),5,3);
        Scene scene = new Scene(grid, 1600, 950, Color.BLACK);

        primaryStage.setTitle("LUDO GAME");
        primaryStage.setScene(scene);
        primaryStage.show();



//        User marc = new User(0,0,0,0,"blue");
//        User carm = new User(0,0,0,0, "red");



//        User.startGame(marc,carm);


    }
}

