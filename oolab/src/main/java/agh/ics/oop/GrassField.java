package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class GrassField implements IWorldMap {

    private int noGrassFields;

    public List<Animal> animals = new ArrayList<>();
    public List<Grass> GrassList = new ArrayList<>();

    GrassField(int noGrassFields) {

        this.noGrassFields = noGrassFields;

        for (int i = 0; i < noGrassFields; i++) {
            GrassList.add(new Grass(new Vector2d(0,1)));

        }
    }

    public String toString() {
        MapVisualizer mp = new MapVisualizer(this);

        int topBorder;
        int bottomBorder;
        int rightBorder;
        int leftBorder;

        for (Animal animal : animals) {
            //fff
        }
        for (Grass grass : GrassList) {
            //fff
        }

        return mp.draw(new Vector2d(leftBorder,bottomBorder), new Vector2d(rightBorder,topBorder));
    }


    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
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
        for (Grass grass : GrassList) {
            if (grass.getPosition().equals(position)) return grass;
        }
        return null;
    }
}
