import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
*/
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper();
        Random randomGenerator = new Random();
        int numberOfRectangles = 7;
        GUI gui = new GUI("title", 800, 600);
        ArrayList<Collidable> blocks = new ArrayList<>();

        for (int i = 0; i < numberOfRectangles; i++) {
            for (int j = 0; j < numberOfRectangles; j++) {
                Rectangle rect = new Rectangle(new Point(10 + i * 80, 10 + j * 60), 20.0, 20.0);
                Block block = new Block(rect);
                blocks.add(block);
            }
        }
        Rectangle rect = new Rectangle(new Point(0, 0), 800, 600);
        Block block = new Block(rect);
        blocks.add(block);
        GameEnvironment ge = new GameEnvironment(blocks);
        Ball[] balls = new Ball[numberOfRectangles * numberOfRectangles];

        for (int i = 0; i < numberOfRectangles; i++) {
            for (int j = 0; j < numberOfRectangles; j++) {
                balls[j + i * numberOfRectangles] = new Ball(500, 500, 5, ge);
                balls[j + i * numberOfRectangles]
                        .setVelocity(Velocity.fromAngleAndSpeed(randomGenerator.nextInt(0, 360), 5));
            }
        }

        while (true) {
            sleeper.sleepFor(20);
            DrawSurface drawer = gui.getDrawSurface();
            for (int i = 0; i < numberOfRectangles; i++) {
                for (int j = 0; j < numberOfRectangles; j++) {
                    drawer.setColor(Color.black);
                    drawer.fillRectangle(
                            (int) blocks.get(j + i * numberOfRectangles).getCollisionRectangle().getUpperLeft().getX(),
                            (int) blocks.get(j + i * numberOfRectangles).getCollisionRectangle().getUpperLeft().getY(),
                            (int) blocks.get(j + i * numberOfRectangles).getCollisionRectangle().getWidth(),
                            (int) blocks.get(j + i * numberOfRectangles).getCollisionRectangle().getHeight());
                    drawer.setColor(Color.red);
                    drawer.fillCircle((int) balls[j + i * numberOfRectangles].getCenter().getX(),
                            (int) balls[j + i * numberOfRectangles].getCenter().getY(),
                            balls[j + i * numberOfRectangles].getSize());
                    balls[j + i * numberOfRectangles].moveOneStep();
                }
            }
            gui.show(drawer);

        }

    }
}
