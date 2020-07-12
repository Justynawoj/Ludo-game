package com.kodilla;

//import javafx.application.Application;
//import javafx.geometry.Orientation;
//import javafx.geometry.Pos;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
//import javafx.scene.paint.ImagePattern;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.control.Label;



import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


//import java.awt.*;

import static com.kodilla.User.startGame;

public class Ludo extends Application{

    private Image imageback = new Image("background1.png");
    private Image circle = new Image("circle.png",70,70,false,false);
//    private Image circle = new Image("blue.png",70,70,false,false);
    private Image blue = new Image("blue.png",70,70,false,false);
    private Image red = new Image("red.png",70,70,false,false);
    private Image yellow = new Image("yellow.png",70,70,false,false);
    private Image green = new Image("green.png",70,70,false,false);
    private Image black = new Image("black.png",70,70,false,false);

    private Label gameOverLabel = new Label();

    private FlowPane circles = new FlowPane(Orientation.HORIZONTAL);
    private Controller controller = Controller.getController();

    private Button movePawn1Button = new Button("move pawn 1");
    private Button movePawn2Button = new Button("move pawn 2");
    private Button movePawn3Button = new Button("move pawn 3");
    private Button movePawn4Button = new Button("move pawn 4");

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







//        grid.addColumn(4,new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(yellow),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle));
//        grid.addColumn(5,new Field(circle),new Field(red),new Field(red),new Field(red),new Field(red),new Field(black),new Field(green),new Field(green),new Field(green),new Field(green),new Field(circle));
//        grid.addColumn(6,new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(blue),new Field(circle),new Field(circle),new Field(circle),new Field(circle),new Field(circle));

//        Field field04 = new Field(0, 4,1);
//        grid.add(field04, 0, 4);
//        controller.addField(field04);
//
//        Field field05 = new Field(0, 5,2);
//        grid.add(field05, 0, 5);
//        controller.addField(field05);
//
//        Field field06 = new Field(0, 6,3);
//        grid.add(field06, 0, 6);
//        controller.addField(field06);

        grid.add(movePawn1Button,0,7);
        grid.add(movePawn2Button,0,8);
        grid.add(movePawn3Button,0,9);
        grid.add(movePawn4Button,0,10);


        Field field1 = new Field(6,0,1);
        Field field2 = new Field(6,1,2);
        Field field3 = new Field(6,2,3);
        Field field4 = new Field(6,3,4);
        Field field5 = new Field(6,4,5);
        Field field6 = new Field(7,4,6);
        Field field7 = new Field(8,4,7);
        Field field8 = new Field(9,4,8);
        Field field9 = new Field(10,4,9);
        Field field10 = new Field(10,5,10);
        Field field11 = new Field(10,6,11);
        Field field12 = new Field(9,6,12);
        Field field13 = new Field(8,6,13);
        Field field14 = new Field(7,6,14);
        Field field15 = new Field(6,6,15);
        Field field16 = new Field(6,7,16);
        Field field17 = new Field(6,8,17);
        Field field18 = new Field(6,9,18);
        Field field19 = new Field(6,10,19);
        Field field20 = new Field(5,10,20);
        Field field21 = new Field(4,10,21);
        Field field22 = new Field(4,9,22);
        Field field23 = new Field(4,8,23);
        Field field24 = new Field(4,7,24);
        Field field25 = new Field(4,6,25);
        Field field26 = new Field(3,6,26);
        Field field27 = new Field(2,6,27);
        Field field28 = new Field(1,6,28);
        Field field29 = new Field(0,6,29);
        Field field30 = new Field(0,5,30);
        Field field31 = new Field(0,4,31);
        Field field32 = new Field(1,4,32);
        Field field33 = new Field(2,4,33);
        Field field34 = new Field(3,4,34);
        Field field35 = new Field(4,4,35);
        Field field36 = new Field(4,3,36);
        Field field37 = new Field(4,2,37);
        Field field38 = new Field(4,1,38);
        Field field39 = new Field(4,0,39);
        Field field40 = new Field(5,0,40);



        grid.add(field1,6,0);
        grid.add(field2,6,1);
        grid.add(field3,6,2);
        grid.add(field4,6,3);
        grid.add(field5,6,4);
        grid.add(field6,7,4);
        grid.add(field7,8,4);
        grid.add(field8,9,4);
        grid.add(field9,10,4);
        grid.add(field10,10,5);
        grid.add(field11,10,6);
        grid.add(field12,9,6);
        grid.add(field13,8,6);
        grid.add(field14,7,6);
        grid.add(field15,6,6);
        grid.add(field16,6,7);
        grid.add(field17,6,8);
        grid.add(field18,6,9);
        grid.add(field19,6,10);
        grid.add(field20,5,10);
        grid.add(field21,4,10);
        grid.add(field22,4,9);
        grid.add(field23,4,8);
        grid.add(field24,4,7);
        grid.add(field25,4,6);
        grid.add(field26,3,6);
        grid.add(field27,2,6);
        grid.add(field28,1,6);
        grid.add(field29,0,6);
        grid.add(field30,0,5);
        grid.add(field31,0,4);
        grid.add(field32,1,4);
        grid.add(field33,2,4);
        grid.add(field34,3,4);
        grid.add(field35,4,4);
        grid.add(field36,4,3);
        grid.add(field37,4,2);
        grid.add(field38,4,1);
        grid.add(field39,4,0);
        grid.add(field40,5,0);


        controller.addField(field1);
        controller.addField(field2);
        controller.addField(field3);
        controller.addField(field4);
        controller.addField(field5);
        controller.addField(field6);
        controller.addField(field7);
        controller.addField(field8);
        controller.addField(field9);
        controller.addField(field10);
        controller.addField(field11);
        controller.addField(field12);
        controller.addField(field13);
        controller.addField(field14);
        controller.addField(field15);
        controller.addField(field16);
        controller.addField(field17);
        controller.addField(field18);
        controller.addField(field19);
        controller.addField(field20);
        controller.addField(field21);
        controller.addField(field22);
        controller.addField(field23);
        controller.addField(field24);
        controller.addField(field25);
        controller.addField(field26);
        controller.addField(field27);
        controller.addField(field28);
        controller.addField(field29);
        controller.addField(field30);
        controller.addField(field31);
        controller.addField(field32);
        controller.addField(field33);
        controller.addField(field34);
        controller.addField(field35);
        controller.addField(field36);
        controller.addField(field37);
        controller.addField(field38);
        controller.addField(field39);
        controller.addField(field40);


        Field field91 = new Field(5,1,91);
        Field field92 = new Field(5,2,92);
        Field field93 = new Field(5,3,93);
        Field field94 = new Field(5,4,94);


//        field91.setFill(new ImagePattern(new Image("blue.png",70,70,false,false)));
//        field92.setFill(new ImagePattern(new Image("blue.png",70,70,false,false)));
//        field93.setFill(new ImagePattern(new Image("blue.png",70,70,false,false)));
//        field94.setFill(new ImagePattern(new Image("blue.png",70,70,false,false)));

        grid.add(field91,5,1);
        grid.add(field92,5,2);
        grid.add(field93,5,3);
        grid.add(field94,5,4);

        controller.addField(field91);
        controller.addField(field92);
        controller.addField(field93);
        controller.addField(field94);


        Field field61 = new Field(9,5,61);
        Field field62 = new Field(9,5,62);
        Field field63 = new Field(9,5,63);
        Field field64 = new Field(9,5,64);

        grid.add(field61,9,5);
        grid.add(field62,8,5);
        grid.add(field63,7,5);
        grid.add(field64,6,5);

        field61.setFill(new ImagePattern(new Image("red.png",70,70,false,false)));
        field62.setFill(new ImagePattern(new Image("red.png",70,70,false,false)));
        field63.setFill(new ImagePattern(new Image("red.png",70,70,false,false)));
        field64.setFill(new ImagePattern(new Image("red.png",70,70,false,false)));

        controller.addField(field61);
        controller.addField(field62);
        controller.addField(field63);
        controller.addField(field64);


        Field field71 = new Field(5,9,71);
        Field field72 = new Field(5,8,72);
        Field field73 = new Field(5,7,73);
        Field field74 = new Field(5,6,74);

        grid.add(field71,5,9);
        grid.add(field72,5,8);
        grid.add(field73,5,7);
        grid.add(field74,5,6);

        controller.addField(field71);
        controller.addField(field72);
        controller.addField(field73);
        controller.addField(field74);

        field71.setFill(new ImagePattern(new Image("yellow.png",70,70,false,false)));
        field72.setFill(new ImagePattern(new Image("yellow.png",70,70,false,false)));
        field73.setFill(new ImagePattern(new Image("yellow.png",70,70,false,false)));
        field74.setFill(new ImagePattern(new Image("yellow.png",70,70,false,false)));


        Field field81 = new Field(1,5,81);
        Field field82 = new Field(2,5,82);
        Field field83 = new Field(3,5,83);
        Field field84 = new Field(4,5,84);

        grid.add(field81,1,5);
        grid.add(field82,2,5);
        grid.add(field83,3,5);
        grid.add(field84,4,5);

        controller.addField(field81);
        controller.addField(field82);
        controller.addField(field83);
        controller.addField(field84);

        field81.setFill(new ImagePattern(new Image("green.png",70,70,false,false)));
        field82.setFill(new ImagePattern(new Image("green.png",70,70,false,false)));
        field83.setFill(new ImagePattern(new Image("green.png",70,70,false,false)));
        field84.setFill(new ImagePattern(new Image("green.png",70,70,false,false)));


        Field pawnBlue1 = new Field(new Image("blue pawn.png"));
        Field pawnBlue2 = new Field(new Image("blue pawn.png"));
        Field pawnBlue3 = new Field(new Image("blue pawn.png"));
        Field pawnBlue4 = new Field(new Image("blue pawn.png"));

        Field pawnRed1 = new Field(new Image("red pawn.png"));
        Field pawnRed2 = new Field(new Image("red pawn.png"));
        Field pawnRed3 = new Field(new Image("red pawn.png"));
        Field pawnRed4 = new Field(new Image("red pawn.png"));


        controller.addField(pawnBlue1);
        controller.addField(pawnBlue2);
        controller.addField(pawnBlue3);
        controller.addField(pawnBlue4);

        controller.addField(pawnRed1);
        controller.addField(pawnRed2);
        controller.addField(pawnRed3);
        controller.addField(pawnRed4);

        User marc = new User(0,0,0,0,"blue");
        User carm = new User(0,0,0,0, "red");

        Button startGameButton = new Button("Start game");
    //    grid.add(startGameButton, 2, 5);
        grid.add(startGameButton, 0, 0, 1, 1);


        grid.add(gameOverLabel,0,1,1,1);


        startGameButton.setText("Nowa gra");
        startGameButton.setOnAction((e) -> {
            startGame(marc, carm, gameOverLabel);
        });



        Scene scene = new Scene(grid, 1600, 950, Color.BLACK);

        primaryStage.setTitle("LUDO GAME");
        primaryStage.setScene(scene);
    //    controller.setPawns(marc,carm);
        primaryStage.show();


    }
}

