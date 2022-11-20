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

        List<Animal> animals;
        if (map instanceof RectangularMap) animals = ((RectangularMap)map).animals;
        else animals = ((GrassField)map).animals;

        int currentAnimal = 0;

        for (MoveDirection direction : directions) {

            animals.get(currentAnimal).move(direction);

            currentAnimal++;
            if (currentAnimal == animals.size()) currentAnimal = 0;
        }
    }
}
