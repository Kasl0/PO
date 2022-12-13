package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {

    private MoveDirection[] directions;
    private IWorldMap map;

    private List<Animal> animals = new ArrayList<>();

    public int moveDelay = 0;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {

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

    public SimulationEngine(IWorldMap map, Vector2d[] positions) {

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

    public void setDirections(MoveDirection[] directions) {
        this.directions = directions;
    }

    public void run() {
        int currentAnimal = 0;

        for (MoveDirection direction : directions) {

            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException exception) {
                System.out.println("EXCEPTION: Simulation stopped TERMINATING PROGRAM");
            }

            animals.get(currentAnimal).move(direction);

            currentAnimal++;
            if (currentAnimal == animals.size()) currentAnimal = 0;

        }
    }

    public void addAnimalsObserver(IPositionChangeObserver observer) {
        for (Animal animal : animals) {
            animal.addObserver(observer);
        }
    }
}
