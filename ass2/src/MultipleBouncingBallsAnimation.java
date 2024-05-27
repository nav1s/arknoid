import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 */
public class MultipleBouncingBallsAnimation {
    private int guiHeight;
    private int guiWidth;
    private GUI gui;
    private Sleeper sleeper = new Sleeper();

    /**
     * @param title
     * @param guiWidth
     * @param guiHeight
     */
    public MultipleBouncingBallsAnimation(String title, int guiWidth, int guiHeight) {
        this.guiHeight = guiHeight;
        this.guiWidth = guiWidth;
        this.gui = new GUI(title, guiWidth, guiHeight);

    }

    /**
     * @return A randomly generated point
     */
    public Point generateRandomPoint() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(this.guiWidth) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(this.guiHeight) + 1; // get integer in range 1-300

        return new Point(x1, y1);
    }

    private void drawAnimation(int[] sizes) {
        Ball[] balls = new Ball[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            Point start = generateRandomPoint();
            balls[i] = new Ball(start.getX(), start.getY(), sizes[i], java.awt.Color.BLUE);
            balls[i].setVelocity(10, 15);
            balls[i].setHeight(this.guiHeight);
            balls[i].setWidth(this.guiWidth);

        }

        while (true) {
            DrawSurface surface = gui.getDrawSurface();
            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep();
                balls[i].drawOn(surface);
            }

            gui.show(surface);
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

        MultipleBouncingBallsAnimation animation = new MultipleBouncingBallsAnimation("Multiple Bouncing Balls", 500,
                500);
        animation.drawAnimation(argsButInteger);

    }
}
