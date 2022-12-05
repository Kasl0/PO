package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void testCanMoveTo() {
        IWorldMap map = new GrassField(10);

        assert map.canMoveTo(new Vector2d(2,2));
        assert map.canMoveTo(new Vector2d(-3129,2432));
        assert map.canMoveTo(new Vector2d(231,-102));
        assert map.canMoveTo(new Vector2d(0,0));

        map.place(new Animal(map, new Vector2d(2, 2)));
        assert !map.canMoveTo(new Vector2d(2,2));
    }

    @Test
    public void testPlace() {
        IWorldMap map = new GrassField(10);
        assert map.place(new Animal(map, new Vector2d(2, 2)));
        assert !map.place(new Animal(map, new Vector2d(2, 2)));
    }

    @Test
    public void testIsOccupied() {
        IWorldMap map = new GrassField(0);

        assert !map.isOccupied(new Vector2d(2,2));
        map.place(new Animal(map, new Vector2d(2, 2)));
        assert map.isOccupied(new Vector2d(2,2));

        assert !map.isOccupied(new Vector2d(3,3));
        ((GrassField)map).grass.put(new Vector2d(3,3), new Grass(new Vector2d(3,3)));
        assert map.isOccupied(new Vector2d(3,3));
    }

    @Test
    public void testObjectAt() {
        IWorldMap map = new GrassField(0);
        assert map.objectAt(new Vector2d(2,2)) == null;

        Animal animal = new Animal(map, new Vector2d(2, 2));
        map.place(animal);
        assert map.objectAt(new Vector2d(2,2)) == animal;

        assert map.objectAt(new Vector2d(3,3)) == null;
        Grass grass = new Grass(new Vector2d(3,3));
        ((GrassField)map).grass.put(grass.getPosition(), grass);
        assert map.objectAt(new Vector2d(3,3)) == grass;
        Animal animal2 = new Animal(map, new Vector2d(3, 3));
        map.place(animal2);
        assert map.objectAt(new Vector2d(3,3)) == animal2;

    }
}
