package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private IWorldMap map;

    private List<Animal> animals = new ArrayList<>();

    SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {

        this.directions = directions;
        this.map = map;

        for (Vector2d position : positions) {
            if (map.canMoveTo(position)) {

                Animal newAnimal = new Animal(map, position);
                animals.add(newAnimal);
                this.map.place(newAnimal);
            }
            else throw new IllegalArgumentException("Animal cannot appear in " + position.toString());
        }
    }

    public void run() {
        int currentAnimal = 0;

        for (MoveDirection direction : directions) {

            animals.get(currentAnimal).move(direction);

            currentAnimal++;
            if (currentAnimal == animals.size()) currentAnimal = 0;
        }
    }
}
