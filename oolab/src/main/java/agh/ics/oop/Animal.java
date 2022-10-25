package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public void setPosition(Vector2d position) {
        if (position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(4,4))) {
            this.position = position;
        }
    }

    public String toString() {
        return position.toString() + ' ' + orientation.toString();
    }

    boolean isAt(Vector2d animalPosition) {
        return position.equals(animalPosition);
    }

    void move(MoveDirection direction) {
        switch(direction) {
            case FORWARD: {
                switch (orientation) {
                    case NORTH: setPosition(position.add(new Vector2d(0, 1)));
                    case SOUTH: setPosition(position.add(new Vector2d(0, -1)));
                    case WEST: setPosition(position.add(new Vector2d(-1, 0)));
                    case EAST: setPosition(position.add(new Vector2d(1, 0)));
                }
            }
            case BACKWARD: {
                switch (orientation) {
                    case NORTH: setPosition(position.subtract(new Vector2d(0, 1)));
                    case SOUTH: setPosition(position.subtract(new Vector2d(0, -1)));
                    case WEST: setPosition(position.subtract(new Vector2d(-1, 0)));
                    case EAST: setPosition(position.subtract(new Vector2d(1, 0)));
                }
            }
            case RIGHT: orientation = orientation.next();
            case LEFT: orientation = orientation.previous();
        };
    }
}
