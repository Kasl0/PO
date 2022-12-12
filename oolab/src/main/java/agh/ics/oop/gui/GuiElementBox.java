package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {

    private VBox elementBox;

    GuiElementBox(IMapElement mapElement) throws FileNotFoundException {

        Image image = new Image(new FileInputStream(mapElement.getResourceName()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        Label mapElementLabel;
        if (mapElement instanceof Animal) mapElementLabel = new Label("Z " + mapElement.getPosition().toString());
        else mapElementLabel = new Label("Trawa");

        elementBox = new VBox(imageView, mapElementLabel);
        elementBox.setAlignment(Pos.CENTER);
    }

    VBox getElementBox() {
        return elementBox;
    }
}
