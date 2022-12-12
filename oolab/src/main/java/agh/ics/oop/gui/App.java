package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class App extends Application {

    public void start(Stage primaryStage) {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionsParser().parse(args);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            int cellWidth = 40;
            int cellHeight = 40;

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
                        GridPane.setHalignment(newLabel, HPos.CENTER);

                    }
                }
            }

            Scene scene = new Scene(gridPane, 400, 400);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(IllegalArgumentException exception) {
            System.out.println("EXCEPTION: " + exception.getMessage() + " TERMINATING PROGRAM");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
