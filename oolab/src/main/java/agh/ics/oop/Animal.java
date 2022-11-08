package agh.ics.oop;

class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    Animal(IWorldMap map) {

    }

    void setPosition(Vector2d position) {
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

            case FORWARD:
                setPosition(position.add(orientation.toUnitVector()));
                break;

            case BACKWARD:
                setPosition(position.subtract(orientation.toUnitVector()));
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
