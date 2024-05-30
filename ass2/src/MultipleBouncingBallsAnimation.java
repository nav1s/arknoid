
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This class creates a gui with multiple bouncing balls.
 */
public class MultipleBouncingBallsAnimation {
    private static final int SPEED_MODIFIER = 60;
    private static final int GUI_HEIGHT = 500;
    private static final int GUI_WIDTH = 500;
    private static final String GUI_TITLE = "Multiple Bouncing Balls";

    /**
     * @return a randomly generated point
     */
    public Point generateRandomPoint() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(GUI_WIDTH) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(GUI_HEIGHT) + 1; // get integer in range 1-300

        return new Point(x1, y1);
    }

    /**
     * @param sizes the sizes of the balls we want to create
     */
    private void drawAnimation(int[] sizes) {
        Sleeper sleeper = new Sleeper();
        GUI gui = new GUI(GUI_TITLE, GUI_HEIGHT, GUI_WIDTH);
        Ball[] balls = new Ball[sizes.length];
        // generate balls
        for (int i = 0; i < sizes.length; i++) {
            Point start = generateRandomPoint();
            balls[i] = new Ball(start.getX(), start.getY(), sizes[i], java.awt.Color.BLACK);
            balls[i].setVelocity(SPEED_MODIFIER / sizes[i], SPEED_MODIFIER / sizes[i]);
            balls[i].setMaxHeight(GUI_HEIGHT);
            balls[i].setMaxWidth(GUI_WIDTH);

        }

        while (true) {
            DrawSurface surface = gui.getDrawSurface();
            // move our balls according to their velocity
            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep();
                balls[i].drawOn(surface);
            }

            gui.show(surface);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
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
            if (argsButInteger[i] <= 0) {
                // exit if one of our arguments is 0 or below
                System.out.println("Invalid input");
                System.exit(0);
            }
        }

        MultipleBouncingBallsAnimation animation = new MultipleBouncingBallsAnimation();
        animation.drawAnimation(argsButInteger);

    }
}
