package agh.ics.oop;

class Grass extends AbstractWorldMapElement {

    Grass(Vector2d position) {
        this.position = position;
    }

    public String toString() {
        return "*";
    }

    public String getResourceName() {
        return "src/main/resources/grass.png";
    }
}
