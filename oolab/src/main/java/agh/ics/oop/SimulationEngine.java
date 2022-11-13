package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private IWorldMap map;

    SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position : positions) {
            if (map.canMoveTo(position)) this.map.place(new Animal(map, position));
        }
    }

    public void run() {
        int currentAnimal = 0;
        for (MoveDirection direction : directions) {
            ((RectangularMap)map).animals.get(currentAnimal).move(direction);
            currentAnimal++;
            if (currentAnimal == ((RectangularMap)map).animals.size()) currentAnimal = 0;
        }
    }
}
