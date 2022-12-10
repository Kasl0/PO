package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class OptionsParserTest {
    @Test
    public void testParser() {
        assert Arrays.equals(OptionsParser.parse(new String[]{}), new MoveDirection[]{});
        assert Arrays.equals(OptionsParser.parse(new String[]{"r", "f", "f", "f"}), new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD});
        assert Arrays.equals(OptionsParser.parse(new String[]{"forward", "f", "backward", "b"}), new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD});
    }

    @Test
    public void testParserThrowingException() {
        boolean thrown;

        try {
            thrown = false;
            OptionsParser.parse(new String[]{"abc"});
        } catch(IllegalArgumentException exception) {
            thrown = true;
        }
        assert thrown;

        try {
            thrown = false;
            OptionsParser.parse(new String[]{"abc", "f", "dfg"});
        } catch(IllegalArgumentException exception) {
            thrown = true;
        }
        assert thrown;

        try {
            thrown = false;
            OptionsParser.parse(new String[]{"fd234:687fd", "ff", "left", "backwdard", "l"});
        } catch(IllegalArgumentException exception) {
            thrown = true;
        }
        assert thrown;
    }
}
