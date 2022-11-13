package agh.ics.oop;

class Animal {

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    Animal() {
    }

    Animal(IWorldMap map) {
        this.map = map;
    }

    Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public String toString() {
        return orientation.toString();
    }

    boolean isAt(Vector2d animalPosition) {
        return position.equals(animalPosition);
    }

    void move(MoveDirection direction){

        Vector2d nextPosition;

        switch(direction) {

            case FORWARD:
                nextPosition = position.add(orientation.toUnitVector());
                if (map.canMoveTo(nextPosition)) this.position = nextPosition;
                break;

            case BACKWARD:
                nextPosition = position.subtract(orientation.toUnitVector());
                if (map.canMoveTo(nextPosition)) this.position = nextPosition;
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
}
