package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class GrassField extends AbstractWorldMap {

    private int noGrassFields;

    public List<Grass> GrassList = new ArrayList<>();

    void addRandomGrass() {
        int randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        int randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        Vector2d randomPosition = new Vector2d(randomX, randomY);

        while (isOccupied(randomPosition)) {
            randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomPosition = new Vector2d(randomX, randomY);
        }

        GrassList.add(new Grass(randomPosition));
    }

    GrassField(int noGrassFields) {

        this.noGrassFields = noGrassFields;
        for (int i = 0; i < noGrassFields; i++) addRandomGrass();
    }

    Vector2d getLowerLeftVector() {
        int bottomBorder = Integer.MAX_VALUE;
        int leftBorder = Integer.MAX_VALUE;

        for (Animal animal : animals) {
            Vector2d position = animal.getPosition();

            bottomBorder = Math.min(bottomBorder, position.y);
            leftBorder = Math.min(leftBorder, position.x);
        }

        for (Grass grass : GrassList) {
            Vector2d position = grass.getPosition();

            bottomBorder = Math.min(bottomBorder, position.y);
            leftBorder = Math.min(leftBorder, position.x);
        }

        return new Vector2d(leftBorder, bottomBorder);
    }

    Vector2d getUpperRightVector() {
        int topBorder = Integer.MIN_VALUE;
        int rightBorder = Integer.MIN_VALUE;

        for (Animal animal : animals) {
            Vector2d position = animal.getPosition();

            topBorder = Math.max(topBorder, position.y);
            rightBorder = Math.max(rightBorder, position.x);
        }

        for (Grass grass : GrassList) {
            Vector2d position = grass.getPosition();

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
