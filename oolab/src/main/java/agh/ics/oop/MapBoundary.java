package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {

    AbstractWorldMap map;

    MapBoundary(AbstractWorldMap map) {
        this.map = map;
    }

    Comparator<Vector2d> objectsXComparator = new Comparator<Vector2d>() {

        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.x - o2.x != 0) return o1.x - o2.x;
            if (o1.y - o2.y != 0) return o1.y - o2.y;
            if (map.objectAt(o1) instanceof Animal && map.objectAt(o2) instanceof Grass) return 1;
            if (map.objectAt(o1) instanceof Grass && map.objectAt(o2) instanceof Animal) return -1;
            return 0;
        }
    };

    Comparator<Vector2d> objectsYComparator = new Comparator<Vector2d>() {

        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.y - o2.y != 0) return o1.y - o2.y;
            if (o1.x - o2.x != 0) return o1.x - o2.x;
            if (map.objectAt(o1) instanceof Animal && map.objectAt(o2) instanceof Grass) return 1;
            if (map.objectAt(o1) instanceof Grass && map.objectAt(o2) instanceof Animal) return -1;
            return 0;
        }
    };

    SortedSet<Vector2d> objectsX = new TreeSet<Vector2d>(objectsXComparator);
    SortedSet<Vector2d> objectsY = new TreeSet<Vector2d>(objectsYComparator);

    public void addObject(Vector2d position) {
        objectsX.add(position);
        objectsY.add(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        objectsX.add(newPosition);
        objectsY.add(newPosition);
    }
}
