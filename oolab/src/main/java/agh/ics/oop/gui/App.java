package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application implements IPositionChangeObserver {

    AbstractWorldMap map;

    VBox vBox;
    int cellWidth = 40;
    int cellHeight = 40;

    public void init() {
        try {

            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3) };
            SimulationEngine engine = new SimulationEngine(map, positions);
            engine.addAnimalsObserver(this);
            engine.moveDelay = 300;

            Button startButton = new Button("Start");
            TextField argsTextField = new TextField();

            HBox controlBox = new HBox(argsTextField, startButton);
            vBox = new VBox(10, controlBox, new Label(""));
            startButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {

                    String[] args = argsTextField.getText().split(" ");
                    MoveDirection[] directions = new OptionsParser().parse(args);
                    engine.setDirections(directions);

                    Thread engineThread = new Thread(engine);
                    engineThread.start();
                }
            });

        } catch(IllegalArgumentException exception) {
            System.out.println("EXCEPTION: " + exception.getMessage() + " TERMINATING PROGRAM");
        }
    }

    public void start(Stage primaryStage) {

        renderGridPane();

        Scene scene = new Scene(vBox, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void renderGridPane() {

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Label newLabel = new Label("y/x");
        gridPane.add(newLabel, 0, 0, 1, 1);
        gridPane.getColumnConstraints().add(new ColumnConstraints( cellWidth ));
        gridPane.getRowConstraints().add(new RowConstraints( cellHeight ));
        GridPane.setHalignment(newLabel, HPos.CENTER);

        for (int i=0; i <= map.getUpperRightVector().x - map.getLowerLeftVector().x; i++) {

            newLabel = new Label( String.valueOf(map.getLowerLeftVector().x + i));
            gridPane.add( newLabel , i+1, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints( cellWidth ));
            GridPane.setHalignment(newLabel, HPos.CENTER);
        }
        for (int i=0; i <= map.getUpperRightVector().y - map.getLowerLeftVector().y; i++) {

            newLabel = new Label( String.valueOf(map.getUpperRightVector().y - i));
            gridPane.add(newLabel, 0, i+1, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints( cellHeight ));
            GridPane.setHalignment(newLabel, HPos.CENTER);
        }

        for (int i = map.getLowerLeftVector().x; i <= map.getUpperRightVector().x; i++) {

            for (int j = map.getLowerLeftVector().y; j <= map.getUpperRightVector().y; j++) {

                if (map.isOccupied(new Vector2d(i,j))) {

                    VBox elementBox = new GuiElementBox( (IMapElement) map.objectAt( new Vector2d(i,j) ) ).getElementBox();

                    gridPane.add( elementBox , i - map.getLowerLeftVector().x + 1, map.getUpperRightVector().y - j + 1, 1, 1);
                }
            }
        }

        vBox.getChildren().remove(1);
        vBox.getChildren().add(1, gridPane);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        Platform.runLater(this::renderGridPane);

    }
}
