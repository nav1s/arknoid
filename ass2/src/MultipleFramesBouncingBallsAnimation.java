
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This class creates a gui with multiple bouncing balls and two frames.
 */
public class MultipleFramesBouncingBallsAnimation {
    private static final int NUMBER_OF_MILLISECONDS_TO_WAIT = 50;
    private static final int SPEED_MODIFIER = 60;
    private static final int GUI_HEIGHT = 800;
    private static final int GUI_WIDTH = 600;
    private static final String GUI_TITLE = "Multiple Frames Bouncing Balls";

    private static final int GRAY_RECTANGLE_X = 50;
    private static final int GRAY_RECTANGLE_Y = 50;
    private static final int GRAY_RECTANGLE_HEIGHT = 450;
    private static final int GRAY_RECTANGLE_WIDTH = 450;

    private static final int YELLOW_RECTANGLE_X = 450;
    private static final int YELLOW_RECTANGLE_Y = 450;
    private static final int YELLOW_RECTANGLE_HEIGHT = 150;
    private static final int YELLOW_RECTANGLE_WIDTH = 150;

    /**
     * @param height
     * @param width
     * @return a randomly generated point bounded to a given area
     */
    public Point generateRandomPointBounded(int height, int width) {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(width) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(height) + 1; // get integer in range 1-300

        return new Point(x1, y1);
    }
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
     * @param sizes
     */
    private void drawAnimation(int[] sizes) {
        Sleeper sleeper = new Sleeper();
        GUI gui = new GUI(GUI_TITLE, GUI_HEIGHT, GUI_WIDTH);
        Ball[] balls = new Ball[sizes.length];

        // for (int i = 0; i < sizes.length; i++) {
        //     int maxWidth = GRAY_RECTANGLE_X + GRAY_RECTANGLE_HEIGHT;
        //     int maxHeight = GRAY_RECTANGLE_Y + GRAY_RECTANGLE_WIDTH;
        //     Point start = generateRandomPointBounded(maxHeight, maxWidth);
        //     balls[i] = new Ball(start, sizes[i], maxHeight, maxWidth);
        // }
        for (int i = 0; i < sizes.length; i++) {
            int maxWidth = GRAY_RECTANGLE_X + GRAY_RECTANGLE_HEIGHT;
            int maxHeight = GRAY_RECTANGLE_Y + GRAY_RECTANGLE_WIDTH;
            Point start = generateRandomPointBounded(maxHeight, maxWidth);
            balls[i] = new Ball(start.getX(), start.getY(), sizes[i], java.awt.Color.BLACK);
            // balls[i] = new Ball(start, sizes[i], this.guiHeight, this.guiWidth);
            balls[i].setVelocity(SPEED_MODIFIER / sizes[i], SPEED_MODIFIER / sizes[i]);
            balls[i].setMaxHeight(maxHeight);
            balls[i].setMaxWidth(maxWidth);

        }


        while (true) {
            DrawSurface surface = gui.getDrawSurface();
            surface.setColor(java.awt.Color.GRAY);
            surface.fillRectangle(GRAY_RECTANGLE_X, GRAY_RECTANGLE_Y, GRAY_RECTANGLE_WIDTH, GRAY_RECTANGLE_HEIGHT);

            surface.setColor(java.awt.Color.YELLOW);
            surface.fillRectangle(YELLOW_RECTANGLE_X, YELLOW_RECTANGLE_Y, YELLOW_RECTANGLE_WIDTH,
                    YELLOW_RECTANGLE_HEIGHT);

            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep();
                balls[i].drawOn(surface);
            }

            gui.show(surface);
            sleeper.sleepFor(NUMBER_OF_MILLISECONDS_TO_WAIT); // wait for 50 milliseconds.
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

        MultipleFramesBouncingBallsAnimation animation = new MultipleFramesBouncingBallsAnimation();
        animation.drawAnimation(argsButInteger);

    }
}
