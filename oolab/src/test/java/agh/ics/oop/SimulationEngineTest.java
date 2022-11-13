package agh.ics.oop;

import org.junit.jupiter.api.Test;

public class SimulationEngineTest {
    @Test
    public void testOne() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String[] args2 = new String[]{"r", "r", "r", "l"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(10, 5);
        Vector2d[] positions2 = { new Vector2d(2,0), new Vector2d(3,5) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assert  map.toString().equals(map2.toString());
    }

    @Test
    public void testTwo() {
        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String[] args2 = new String[]{"r", "r", "r", "l"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(10, 5);
        Vector2d[] positions2 = { new Vector2d(2,0), new Vector2d(3,5) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assert  map.toString().equals(map2.toString());
    }

    @Test
    public void testThree() {
        String[] args = new String[]{"f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1), new Vector2d(2,2), new Vector2d(3,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String[] args2 = new String[]{};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(10, 5);
        Vector2d[] positions2 = { new Vector2d(0,1), new Vector2d(1,2), new Vector2d(2,3), new Vector2d(3,4) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assert  map.toString().equals(map2.toString());
    }

    @Test
    public void testFour() {
        String[] args = new String[]{"f", "b", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        String[] args2 = new String[]{"r", "l"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(2, 2);
        Vector2d[] positions2 = { new Vector2d(0,1), new Vector2d(1,0) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();

        assert  map.toString().equals(map2.toString());
    }
}
