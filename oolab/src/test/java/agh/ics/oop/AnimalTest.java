package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class AnimalTest {
    @Test
    public void testOrientationAndPosition() {

        assert new Animal().toString().equals("(2,2) Północ");

        Animal t1 = new Animal();
        t1.run(new MoveDirection[]{MoveDirection.FORWARD});
        assert t1.toString().equals("(2,3) Północ");

        Animal t2 = new Animal();
        t2.run(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD});
        assert t2.toString().equals("(4,2) Wschód");

        Animal t3 = new Animal();
        t3.run(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT});
        assert t3.toString().equals("(2,2) Zachód");
    }
    @Test
    public void testMapBorders() {
        Animal t1 = new Animal();
        t1.run(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD});
        assert t1.toString().equals("(4,2) Wschód");

        Animal t2 = new Animal();
        t2.run(new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD});
        assert t2.toString().equals("(0,2) Wschód");
    }
}
