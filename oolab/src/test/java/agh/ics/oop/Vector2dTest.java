package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void testEquals() {
        assert new Vector2d(1,1).equals(new Vector2d(1,1));
        assert !new Vector2d(-121, 221).equals(new Vector2d(-121, 21));
        assert !new Vector2d(1, 1).equals(1);
    }

    @Test
    public void testToString() {
        assert new Vector2d(1,1).toString().equals("(1,1)");
        assert new Vector2d(-11,0).toString().equals("(-11,0)");
        assert !new Vector2d(-11, -11).toString().equals("(-11,122)");
    }

    @Test
    public void testPrecedes() {
        assert new Vector2d(-1,-1).precedes(new Vector2d(1,1));
        assert new Vector2d(1,1).precedes(new Vector2d(1,1));
        assert !new Vector2d(2,-1).precedes(new Vector2d(1,1));
    }

    @Test
    public void testFollows() {
        assert new Vector2d(1,1).follows(new Vector2d(-1,-1));
        assert new Vector2d(1,1).follows(new Vector2d(1,1));
        assert !new Vector2d(2,-1).follows(new Vector2d(1,1));
    }

    @Test
    public void testUpperRight() {
        assert new Vector2d(1,1).upperRight(new Vector2d(-1,-1)).equals(new Vector2d(1,1));
        assert new Vector2d(1,1).upperRight(new Vector2d(1,1)).equals(new Vector2d(1,1));
        assert new Vector2d(2,-1).upperRight(new Vector2d(1,1)).equals(new Vector2d(2,1));
    }

    @Test
    public void testLowerLeft() {
        assert new Vector2d(1,1).lowerLeft(new Vector2d(-1,-1)).equals(new Vector2d(-1,-1));
        assert new Vector2d(1,1).lowerLeft(new Vector2d(1,1)).equals(new Vector2d(1,1));
        assert new Vector2d(2,-1).lowerLeft(new Vector2d(1,1)).equals(new Vector2d(1,-1));
    }

    @Test
    public void testAdd() {
        assert new Vector2d(1,1).add(new Vector2d(-1,-1)).equals(new Vector2d(0,0));
        assert new Vector2d(1,1).add(new Vector2d(1,1)).equals(new Vector2d(2,2));
        assert new Vector2d(2,-1).add(new Vector2d(1,1)).equals(new Vector2d(3,0));
    }

    @Test
    public void testSubtract() {
        assert new Vector2d(1,1).subtract(new Vector2d(-1,-1)).equals(new Vector2d(2,2));
        assert new Vector2d(1,1).subtract(new Vector2d(1,1)).equals(new Vector2d(0,0));
        assert new Vector2d(2,-1).subtract(new Vector2d(1,1)).equals(new Vector2d(1,-2));
    }

    @Test
    public void testOpposite() {
        assert new Vector2d(1,1).opposite().equals(new Vector2d(-1,-1));
        assert new Vector2d(0,0).opposite().equals(new Vector2d(0,0));
        assert new Vector2d(2,-1).opposite().equals(new Vector2d(-2,1));
    }
}
