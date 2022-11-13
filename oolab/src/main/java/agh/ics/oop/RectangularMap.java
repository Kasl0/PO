package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class RectangularMap implements IWorldMap{

    private int width;
    private int height;

    public List<Animal> animals = new ArrayList<>();

    RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        MapVisualizer mp = new MapVisualizer(this);
        return mp.draw(new Vector2d(0,0), new Vector2d(width,height));
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width,height)) && !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if (animals.contains(animal)) {
            return false;
        }
        else {
            animals.add(animal);
            return true;
        }
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }
}
