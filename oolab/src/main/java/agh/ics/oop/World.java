package agh.ics.oop;

public class World {
    public static void main (String[] args) {

        Animal animal = new Animal();
        System.out.println(animal);

        args = new String[]{"r", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        animal.run(directions);

    }
}
