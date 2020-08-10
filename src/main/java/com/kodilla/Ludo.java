package com.kodilla;

import com.kodilla.window.ConfirmBox;
import com.kodilla.window.SaveService;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import static com.kodilla.view.Color.BLUE;
import static com.kodilla.view.Color.YELLOW;
//import static com.kodilla.Player.startGame;

public class Ludo extends Application{

    private Image imageback = new Image("background1.png");
    private Image circle = new Image("circle.png",65,65,false,false);
    private Image blue = new Image("blue.png",70,70,false,false);
    private Image red = new Image("red.png",70,70,false,false);
    private Image yellow = new Image("yellow.png",70,70,false,false);
    private Image green = new Image("green.png",70,70,false,false);
    private Image black = new Image("black.png",70,70,false,false);

    private Label gameOverLabel = new Label();

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

        GridPane grid = new GridPane();




        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setBackground(background);

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


        field91.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field92.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field93.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field94.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));

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

        field61.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field62.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field63.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field64.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));

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

        field71.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field72.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field73.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field74.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));


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

        field81.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field82.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field83.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field84.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));

        Field field101 = new Field(2,1,101);
        Field field102 = new Field(2,2,102);
        Field field103 = new Field(1,2,103);
        Field field104 = new Field(1,1,104);

        controller.addField(field101);
        controller.addField(field102);
        controller.addField(field103);
        controller.addField(field104);

        grid.add(field101,2,1);
        grid.add(field102,2,2);
        grid.add(field103,1,2);
        grid.add(field104,1,1);

        field101.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field102.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field103.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));
        field104.setFill(new ImagePattern(new Image("blue.png",65,65,false,false)));

        Field field115 = new Field(9,1,115);
        Field field116 = new Field(9,2,116);
        Field field117 = new Field(8,2,117);
        Field field118 = new Field(8,1,118);

        controller.addField(field115);
        controller.addField(field116);
        controller.addField(field117);
        controller.addField(field118);

        grid.add(field115,9,1);
        grid.add(field116,9,2);
        grid.add(field117,8,2);
        grid.add(field118,8,1);

        field115.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field116.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field117.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));
        field118.setFill(new ImagePattern(new Image("red.png",65,65,false,false)));

        Field field125 = new Field(9,8,125);
        Field field126 = new Field(9,9,126);
        Field field127 = new Field(8,9,127);
        Field field128 = new Field(8,8,128);

        controller.addField(field125);
        controller.addField(field126);
        controller.addField(field127);
        controller.addField(field128);

        grid.add(field125,9,8);
        grid.add(field126,9,9);
        grid.add(field127,8,9);
        grid.add(field128,8,8);

        field125.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field126.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field127.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));
        field128.setFill(new ImagePattern(new Image("yellow.png",65,65,false,false)));

        Field field135 = new Field(2,8,135);
        Field field136 = new Field(2,9,136);
        Field field137 = new Field(1,9,137);
        Field field138 = new Field(1,8,138);

        controller.addField(field135);
        controller.addField(field136);
        controller.addField(field137);
        controller.addField(field138);

        grid.add(field135,2,8);
        grid.add(field136,2,9);
        grid.add(field137,1,9);
        grid.add(field138,1,8);

        field135.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field136.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field137.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));
        field138.setFill(new ImagePattern(new Image("green.png",65,65,false,false)));

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



        Field player1 = new Field(13,4,1000);
        Field player2 = new Field(8,3,2000);
        Field player4 = new Field(1,7,4000);
        Field player3 = new Field(13, 6,3000);
        grid.add(player1,13,4);
        grid.add(player2,8,3);
        grid.add(player4,1,7);
        grid.add(player3,13,6);
        controller.addField(player1);
        controller.addField(player2);
        controller.addField(player3);
        controller.addField(player4);

        Label playerLabel = new Label("Player");
        Label computer = new Label("Computer");
        grid.add(playerLabel,12,4);
        grid.add(computer,12,6);
        Player player = new Player(
                field101,
                field102,
                field103,
                field104,
                player1,
                BLUE);

        Player comp = new Player(
                field125,
                field126,
                field127,
                field128,
                player3,
                YELLOW);


        Button newLoadButton = new Button("New load button");
        grid.add(newLoadButton,10,9);

        Button newSaveButton = new Button("New save button");
        grid.add(newSaveButton,10,8);



        //Mentor
        SaveService saveService = new SaveService(grid,controller);


        Controller controllerReturned = saveService.loadObjectFromFile();
       // controllerReturned.getFieldsInArray();
        System.out.println("ja tu cos robie  " + controllerReturned);

 /*       Controller loadedController = saveService.loadObjectFromFile();
        controller = loadedController;
*/

        DiceService.getInstance().addGrid(grid);



        Scene scene = new Scene(grid, 1600, 800, Color.BLACK);

        primaryStage.setTitle("LUDO GAME");
        primaryStage.setScene(scene);

        primaryStage.show();


        Button newGameButton = new Button("New Game");
        grid.add(newGameButton,10,10);

        newGameButton.setOnAction(e -> {
            boolean result = ConfirmBox.display("New Game", "Are you sure you want to start over?");
            if(result){

                player.getP1().setProgress(Progress.START);
                player.getP2().setProgress(Progress.START);
                player.getP3().setProgress(Progress.START);
                player.getP4().setProgress(Progress.START);

                player.getP1().getField().setPawn(null);
                player.getP2().getField().setPawn(null);
                player.getP3().getField().setPawn(null);
                player.getP4().getField().setPawn(null);

                player.getP1().setField(field101);
                player.getP2().setField(field102);
                player.getP3().setField(field103);
                player.getP4().setField(field104);

                player.getP1().getField().setPawn(player.getP1());
                player.getP2().getField().setPawn(player.getP2());
                player.getP3().getField().setPawn(player.getP3());
                player.getP4().getField().setPawn(player.getP4());


                comp.getP1().setProgress(Progress.START);
                comp.getP2().setProgress(Progress.START);
                comp.getP3().setProgress(Progress.START);
                comp.getP4().setProgress(Progress.START);

                comp.getP1().getField().setPawn(null);
                comp.getP2().getField().setPawn(null);
                comp.getP3().getField().setPawn(null);
                comp.getP4().getField().setPawn(null);

                comp.getP1().setField(field125);
                comp.getP2().setField(field126);
                comp.getP3().setField(field127);
                comp.getP4().setField(field128);

                comp.getP1().getField().setPawn(comp.getP1());
                comp.getP2().getField().setPawn(comp.getP2());
                comp.getP3().getField().setPawn(comp.getP3());
                comp.getP4().getField().setPawn(comp.getP4());

            }
        });

    }

}

