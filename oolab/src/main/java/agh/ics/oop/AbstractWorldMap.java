package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animals = new ArrayList<>();

    abstract Vector2d getLowerLeftVector();
    abstract Vector2d getUpperRightVector();

    public String toString() {
        MapVisualizer mp = new MapVisualizer(this);
        return mp.draw(getLowerLeftVector(), getUpperRightVector());
    }

    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) == null || objectAt(animal.getPosition()).getClass() != animal.getClass()) {
            animals.add(animal);
            return true;
        }
        else return false;
    }
}
