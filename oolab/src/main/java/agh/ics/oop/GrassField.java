package agh.ics.oop;

import java.util.Map;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap {

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
        boundary.addObject(randomPosition);
    }

    public GrassField(int noGrassFields) {

        this.noGrassFields = noGrassFields;
        for (int i = 0; i < noGrassFields; i++) addRandomGrass();
    }

    public Vector2d getLowerLeftVector() {
        return new Vector2d(boundary.objectsX.first().x, boundary.objectsY.first().y);
    }

    public Vector2d getUpperRightVector() {
        return new Vector2d(boundary.objectsX.last().x, boundary.objectsY.last().y);
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
