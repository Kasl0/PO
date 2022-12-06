package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> animals = new HashMap<>();

    abstract Vector2d getLowerLeftVector();
    abstract Vector2d getUpperRightVector();

    public String toString() {
        MapVisualizer mp = new MapVisualizer(this);
        return mp.draw(getLowerLeftVector(), getUpperRightVector());
    }

    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) == null || objectAt(animal.getPosition()).getClass() != animal.getClass()) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        else throw new IllegalArgumentException(animal.getPosition().toString() + " is occupied by another animal");
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalToUpdate = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animalToUpdate);
    }

}
