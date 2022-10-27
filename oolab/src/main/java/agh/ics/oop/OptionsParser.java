package agh.ics.oop;

class OptionsParser {
    static MoveDirection[] parse(String[] strings) {
        MoveDirection[] directions = new MoveDirection[strings.length];
        int counter = 0;

        for (String string : strings) {

            switch (string) {
                case "f", "forward" -> {
                    directions[counter] = MoveDirection.FORWARD;
                    counter++;
                }
                case "b", "backward" -> {
                    directions[counter] = MoveDirection.BACKWARD;
                    counter++;
                }
                case "r", "right" -> {
                    directions[counter] = MoveDirection.RIGHT;
                    counter++;
                }
                case "l", "left" -> {
                    directions[counter] = MoveDirection.LEFT;
                    counter++;
                }
            }

        }
        return java.util.Arrays.copyOfRange(directions, 0, counter);
    }
}
