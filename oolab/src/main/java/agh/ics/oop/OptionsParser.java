package agh.ics.oop;

public class OptionsParser {
    MoveDirection[] parse(String[] strings) {
        MoveDirection[] directions = new MoveDirection[strings.length];
        int counter = 0;

        for (String string : strings) {

            switch (string) {
                case "f":
                case "forward":
                    directions[counter] = MoveDirection.FORWARD;
                    counter++;
                case "b":
                case "backward":
                    directions[counter] = MoveDirection.BACKWARD;
                    counter++;
                case "r":
                case "right":
                    directions[counter] = MoveDirection.RIGHT;
                    counter++;
                case "l":
                case "left":
                    directions[counter] = MoveDirection.LEFT;
                    counter++;
            }

        }
        return java.util.Arrays.copyOfRange(directions, 0, counter);
    }
}
