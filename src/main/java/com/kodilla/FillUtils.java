package com.kodilla;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

public class FillUtils {

    static Paint fill(String graphic){
        return new ImagePattern(new Image(graphic,70,70,false,false));
    }

}
