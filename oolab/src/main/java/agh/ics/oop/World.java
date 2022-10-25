package agh.ics.oop;

public class World {
    public static void main (String[] args) {
        System.out.println("system wystartował");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));



        args = new String[ ]{"r", "f", "f", "f"};
        MoveDirection[] directions = StringsToDirections(args);
        run(directions);

        System.out.println("system zakończył działanie");
    }

    static void run (MoveDirection[] directions) {

        System.out.println("Start");

        Animal animal = new Animal();
        System.out.println(animal);

        for (MoveDirection direction : directions) {

            switch (direction) {
                case FORWARD -> animal.move(MoveDirection.FORWARD);
                case BACKWARD -> animal.move(MoveDirection.BACKWARD);
                case RIGHT -> animal.move(MoveDirection.RIGHT);
                case LEFT -> animal.move(MoveDirection.LEFT);
            };
            System.out.println(animal);

            /*String message = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };

            System.out.println(message);*/
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
