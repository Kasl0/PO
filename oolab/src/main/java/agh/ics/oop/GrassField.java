package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;

class GrassField extends AbstractWorldMap {

    private int noGrassFields;

    public Map<Vector2d, Grass> grassList = new HashMap<>();

    void addRandomGrass() {
        int randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        int randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        Vector2d randomPosition = new Vector2d(randomX, randomY);

        while (isOccupied(randomPosition)) {
            randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomPosition = new Vector2d(randomX, randomY);
        }

        grassList.put(randomPosition, new Grass(randomPosition));
    }

    GrassField(int noGrassFields) {

        this.noGrassFields = noGrassFields;
        for (int i = 0; i < noGrassFields; i++) addRandomGrass();
    }

    Vector2d getLowerLeftVector() {
        int bottomBorder = Integer.MAX_VALUE;
        int leftBorder = Integer.MAX_VALUE;

        for (Vector2d position : animals.keySet()) {
            bottomBorder = Math.min(bottomBorder, position.y);
            leftBorder = Math.min(leftBorder, position.x);
        }

        for (Vector2d position : grassList.keySet()) {
            bottomBorder = Math.min(bottomBorder, position.y);
            leftBorder = Math.min(leftBorder, position.x);
        }

        return new Vector2d(leftBorder, bottomBorder);
    }

    Vector2d getUpperRightVector() {
        int topBorder = Integer.MIN_VALUE;
        int rightBorder = Integer.MIN_VALUE;

        for (Vector2d position : animals.keySet()) {
            topBorder = Math.max(topBorder, position.y);
            rightBorder = Math.max(rightBorder, position.x);
        }

        for (Vector2d position : grassList.keySet()) {
            topBorder = Math.max(topBorder, position.y);
            rightBorder = Math.max(rightBorder, position.x);
        }

        return new Vector2d(rightBorder, topBorder);
    }

    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return false;
        }
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        for (Grass grass : GrassList) {
            if (grass.isAt(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        for (Grass grass : GrassList) {
            if (grass.isAt(position)) return grass;
        }
        return null;
    }
}
