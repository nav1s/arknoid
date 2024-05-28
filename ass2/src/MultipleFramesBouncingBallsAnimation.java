
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 */
public class MultipleFramesBouncingBallsAnimation {
    private int guiHeight;
    private int guiWidth;
    private GUI gui;
    private Sleeper sleeper = new Sleeper();

    /**
     * @param title
     * @param guiWidth
     * @param guiHeight
     */
    public MultipleFramesBouncingBallsAnimation(String title, int guiWidth, int guiHeight) {
        this.guiHeight = guiHeight;
        this.guiWidth = guiWidth;
        this.gui = new GUI(title, guiWidth, guiHeight);
    }

    /**
     * @return a randomly generated point
     */
    public Point generateRandomPoint() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(this.guiWidth) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(this.guiHeight) + 1; // get integer in range 1-300

        return new Point(x1, y1);
    }

    /**
     * @param sizes
     */
    private void drawAnimation(int[] sizes) {
        Ball[] balls = new Ball[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            Point start = generateRandomPoint();
            balls[i] = new Ball(start.getX(), start.getY(), sizes[i], java.awt.Color.RED);
            balls[i].setVelocity(10, 15);
            balls[i].setHeight(this.guiHeight);
            balls[i].setWidth(this.guiWidth);

        }

        while (true) {
            DrawSurface surface = this.gui.getDrawSurface();
            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep();
                balls[i].drawOn(surface);
            }

            surface.setColor(java.awt.Color.GREEN);
            surface.fillRectangle(50, 50, 500, 500);
            surface.drawRectangle(50, 50, 500, 500);

            this.gui.show(surface);
            this.sleeper.sleepFor(50); // wait for 50 milliseconds.
        }
    }

    /**
     * @param args command line arguments used to create our ball.
     */
    public static void main(String[] args) {
        int[] argsButInteger = new int[args.length];
        // convert all of our arguments to integer and exit if one of them isn't
        for (int i = 0; i < args.length; i++) {
            try {
                argsButInteger[i] = Integer.parseInt(args[i]);
                // exit if one of our arguments isn't an integer
            } catch (Exception e) {
                System.out.println("Invalid input");
                System.exit(0);
            }
        }

        MultipleFramesBouncingBallsAnimation animation = new MultipleFramesBouncingBallsAnimation(
                "Multiple Frames Bouncing Balls", 700,
                700);
        animation.drawAnimation(argsButInteger);

    }
}
