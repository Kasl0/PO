package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    public void testCanMoveTo() {
        IWorldMap map = new RectangularMap(10, 5);
        assert map.canMoveTo(new Vector2d(0, 0));
        assert map.canMoveTo(new Vector2d(10, 5));
        assert !map.canMoveTo(new Vector2d(-1, 5));
        assert !map.canMoveTo(new Vector2d(11, 5));
        assert !map.canMoveTo(new Vector2d(1, -1));
        assert !map.canMoveTo(new Vector2d(1, 6));
    }

    @Test
    public void testPlace() {
        IWorldMap map = new RectangularMap(10, 5);
        assert map.place(new Animal(map, new Vector2d(2, 2)));
        assert !map.place(new Animal(map, new Vector2d(2, 2)));
    }

    @Test
    public void testIsOccupied() {
        IWorldMap map = new RectangularMap(10, 5);
        assert !map.isOccupied(new Vector2d(2,2));

        map.place(new Animal(map, new Vector2d(2, 2)));
        assert map.isOccupied(new Vector2d(2,2));
    }

    @Test
    public void testObjectAt() {
        IWorldMap map = new RectangularMap(10, 5);
        assert map.objectAt(new Vector2d(2,2)) == null;

        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assert map.objectAt(new Vector2d(2,2)) == animal;
    }
}
