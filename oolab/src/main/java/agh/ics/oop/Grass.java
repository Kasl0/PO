package agh.ics.oop;

class Grass {

    private Vector2d position;

    Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public String toString() {
        return "*";
    }
}
