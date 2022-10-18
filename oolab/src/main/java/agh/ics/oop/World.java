package agh.ics.oop;

public class World {
    public static void main (String[] args) {
        System.out.println("system wystartował");

        //args = new String[ ]{"f", "f", "r", "l"};
        Direction[] directions = StringsToDirections(args);
        run(directions);

        System.out.println("system zakończył działanie");
    }

    static void run (Direction[] directions) {

        System.out.println("Start");

        for (Direction direction : directions) {

            String message = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };

            System.out.println(message);
        }

        System.out.println("Stop");
    }

    static Direction[] StringsToDirections (String[] strings) {

        Direction[] directions = new Direction[strings.length];

        for (int i = 0; i < strings.length; i++) {

            switch (strings[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }

        }
        return directions;
    }
}
