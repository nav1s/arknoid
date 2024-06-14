import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.ArrayList;

/**
 */
public class SimpleMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper();
        GUI gui = new GUI("title", 400, 400);
        ArrayList<Collidable> blocks = new ArrayList<>();

        Rectangle rect = new Rectangle(new Point(0, 0), 400, 400);
        Block block = new Block(rect);
        blocks.add(block);
        GameEnvironment gameEnvironment = new GameEnvironment(blocks);

        Ball ball = new Ball(100, 100, 50, gameEnvironment);

        while (true) {
            ball.moveOneStep();
            DrawSurface drawer = gui.getDrawSurface();
            ball.drawOn(drawer);
            gui.show(drawer);
            sleeper.sleepFor(50); // wait for 50 milliseconds.
        }

    }
}
