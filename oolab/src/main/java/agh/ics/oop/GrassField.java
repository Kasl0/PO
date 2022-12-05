package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;

class GrassField extends AbstractWorldMap {

    private int noGrassFields;

    public Map<Vector2d, Grass> grass = new HashMap<>();

    void addRandomGrass() {
        int randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        int randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
        Vector2d randomPosition = new Vector2d(randomX, randomY);

        while (isOccupied(randomPosition)) {
            randomX = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomY = (int) (Math.random() * Math.sqrt(noGrassFields * 10));
            randomPosition = new Vector2d(randomX, randomY);
        }

        grass.put(randomPosition, new Grass(randomPosition));
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

        for (Vector2d position : grass.keySet()) {
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

        for (Vector2d position : grass.keySet()) {
            topBorder = Math.max(topBorder, position.y);
            rightBorder = Math.max(rightBorder, position.x);
        }

        return new Vector2d(rightBorder, topBorder);
    }

    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grass.containsKey(position);
    }

    public Object objectAt(Vector2d position) {
        Object returnObject = animals.get(position);
        if (returnObject == null) returnObject = grass.get(position);
        return returnObject;
    }
}
