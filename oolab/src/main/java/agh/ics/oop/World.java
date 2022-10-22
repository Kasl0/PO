package agh.ics.oop;

public class World {
    public static void main (String[] args) {
        System.out.println("system wystartował");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        //args = new String[ ]{"f", "f", "r", "l"};
        MoveDirection[] directions = StringsToDirections(args);
        run(directions);

        System.out.println("system zakończył działanie");
    }

    static void run (MoveDirection[] directions) {

        System.out.println("Start");

        for (MoveDirection direction : directions) {

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

    static MoveDirection[] StringsToDirections (String[] strings) {

        MoveDirection[] directions = new MoveDirection[strings.length];

        for (int i = 0; i < strings.length; i++) {

            switch (strings[i]) {
                case "f" -> directions[i] = MoveDirection.FORWARD;
                case "b" -> directions[i] = MoveDirection.BACKWARD;
                case "r" -> directions[i] = MoveDirection.RIGHT;
                case "l" -> directions[i] = MoveDirection.LEFT;
            }

        }
        return directions;
    }
}
