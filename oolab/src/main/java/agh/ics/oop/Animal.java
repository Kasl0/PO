package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

class Animal extends AbstractWorldMapElement {

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public String toString() {
        return orientation.toString();
    }

    void move(MoveDirection direction){

        Vector2d nextPosition;

        switch(direction) {

            case FORWARD:
                nextPosition = position.add(orientation.toUnitVector());
                if (map.canMoveTo(nextPosition)) {
                    positionChanged(this.position, nextPosition);
                    this.position = nextPosition;
                }
                break;

            case BACKWARD:
                nextPosition = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(nextPosition)) {
                    positionChanged(this.position, nextPosition);
                    this.position = nextPosition;
                }
                break;

            case RIGHT:
                orientation = orientation.next();
                break;

            case LEFT:
                orientation = orientation.previous();
                break;
        };
    }

    void run(MoveDirection[] directions) {

        System.out.println("Start");

        for (MoveDirection direction : directions) {
            move(direction);
            System.out.println(this);
        }

        System.out.println("Stop");
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
