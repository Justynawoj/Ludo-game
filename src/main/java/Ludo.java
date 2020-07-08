
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.awt.*;

public class Ludo extends Application{

    private Image imageback = new Image("background1.png");
    private Image circle = new Image("circle.png",70,70,false,false);
    private Image blue = new Image("blue.png",70,70,false,false);
    private Image red = new Image("red.png",70,70,false,false);
    private Image yellow = new Image("yellow.png",70,70,false,false);
    private Image green = new Image("green.png",70,70,false,false);
    private Image black = new Image("black.png",70,70,false,false);



    private FlowPane circles = new FlowPane(Orientation.HORIZONTAL);


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

        ImageView img = new ImageView(circle);
        ImageView imgRed = new ImageView(red);
        ImageView imgYellow = new ImageView(yellow);
        ImageView imgBlue = new ImageView(blue);
        ImageView imgGreen = new ImageView(green);
        ImageView imgblack = new ImageView(black);

      //  circles.getChildren().addAll(img,imgblack,imgBlue,imgGreen,imgRed,imgYellow);







        grid.addColumn(4,new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(yellow),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle));
        grid.addColumn(5,new ImageView(circle),new ImageView(red),new ImageView(red),new ImageView(red),new ImageView(red),new ImageView(black),new ImageView(green),new ImageView(green),new ImageView(green),new ImageView(green),new ImageView(circle));
        grid.addColumn(6,new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(blue),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle),new ImageView(circle));
        grid.addColumn(0,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(circle),new ImageView(circle));
        grid.addColumn(1,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(yellow),new ImageView(circle));
        grid.addColumn(2,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(yellow),new ImageView(circle));
        grid.addColumn(3,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(yellow),new ImageView(circle));
        grid.addColumn(7,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(blue),new ImageView(circle));
        grid.addColumn(8,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(blue),new ImageView(circle));
        grid.addColumn(9,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(blue),new ImageView(circle));
        grid.addColumn(10,new Text(""),new Text(""),new Text(""),new Text(""),new ImageView(circle),new ImageView(circle),new ImageView(circle));
        grid.add(new ImageView(circle),5,3);
        Scene scene = new Scene(grid, 1600, 950, Color.BLACK);

        primaryStage.setTitle("LUDO GAME");
        primaryStage.setScene(scene);
        primaryStage.show();



        User marc = new User(0,0,0,0,"blue");
        User carm = new User(0,0,0,0, "red");



        User.startGame(marc,carm);


    }
}

