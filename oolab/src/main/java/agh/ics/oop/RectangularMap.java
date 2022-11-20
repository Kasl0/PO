package agh.ics.oop;

class RectangularMap extends AbstractWorldMap {

    private int width;
    private int height;

    RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Vector2d getLowerLeftVector() {
        return new Vector2d(0,0);
    }

    Vector2d getUpperRightVector() {
        return new Vector2d(width, height);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width,height)) && !isOccupied(position);
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.isAt(position)) return animal;
        }
        return null;
    }
}
