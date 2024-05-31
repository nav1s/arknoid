
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This class creates a gui with multiple bouncing balls and two frames.
 */
public class MultipleFramesBouncingBallsAnimation {
    // gui related finals
    private static final int NUMBER_OF_MILLISECONDS_TO_WAIT = 50;
    private static final int GUI_HEIGHT = 600;
    private static final int GUI_WIDTH = 800;
    private static final String GUI_TITLE = "Multiple Frames Bouncing Balls";

    // gray rectangle related finals
    private static final Point GRAY_RECTANGLE_START = new Point(50, 50);
    private static final Point GRAY_RECTANGLE_END = new Point(500, 500);
    private static final int GRAY_RECTANGLE_HEIGHT = (int) (GRAY_RECTANGLE_END.getX() - GRAY_RECTANGLE_START.getX());
    private static final int GRAY_RECTANGLE_WIDTH = (int) (GRAY_RECTANGLE_END.getY() - GRAY_RECTANGLE_START.getY());

    // yellow rectangle related finals
    private static final Point YELLOW_RECTANGLE_START = new Point(450, 450);
    private static final Point YELLOW_RECTANGLE_END = new Point(600, 600);
    private static final int YELLOW_RECTANGLE_HEIGHT = (int) (YELLOW_RECTANGLE_END.getX()
            - YELLOW_RECTANGLE_START.getX());
    private static final int YELLOW_RECTANGLE_WIDTH = (int) (YELLOW_RECTANGLE_END.getY()
            - YELLOW_RECTANGLE_START.getY());

    /**
     * @param radius
     * @param rectStart
     * @param rectEnd
     * @return a randomly generated point outside of the rectangle
     */
    public Point generateRandomOutsideOfRectangle(int radius, Point rectStart, Point rectEnd) {
        // create a random-number generator
        Random rand = new Random();

        while (true) {
            // get integer in range of our gui width
            int x = rand.nextInt(GUI_WIDTH) + 1;
            // get integer in range of our gui height
            int y = rand.nextInt(GUI_HEIGHT) + 1;

            // continue if our point is inside the rectangle
            if (x + radius >= rectStart.getX() && x - radius <= rectEnd.getX() && y + radius >= rectStart.getY()
                    && y - radius <= rectEnd.getY()) {
                continue;
            }
            // return the point if it isn't inside the rectangle
            return new Point(x, y);

        }
    }

    /**
     * @param sizes an array containing the size of our radiuses
     */
    private void drawAnimation(int[] sizes) {
        // setup some initial variables
        Sleeper sleeper = new Sleeper();
        GUI gui = new GUI(GUI_TITLE, GUI_WIDTH, GUI_HEIGHT);
        Ball[] balls = new Ball[sizes.length];

        // create the first half of the balls inside th gray rectangle
        for (int i = 0; i < sizes.length / 2; i++) {
            balls[i] = new Ball(sizes[i], (int) GRAY_RECTANGLE_START.getY(), (int) GRAY_RECTANGLE_END.getY(),
                    (int) GRAY_RECTANGLE_START.getX(),
                    (int) GRAY_RECTANGLE_END.getX());
        }

        // create the second half of the balls inside th gray rectangle
        for (int i = sizes.length / 2; i < sizes.length; i++) {
            Point start = generateRandomOutsideOfRectangle(sizes[i], GRAY_RECTANGLE_START, GRAY_RECTANGLE_END);
            balls[i] = new Ball(start, sizes[i]);
            balls[i].setMaxHeight(GUI_HEIGHT);
            balls[i].setMaxWidth(GUI_WIDTH);
        }

        // animation loop
        while (true) {
            DrawSurface surface = gui.getDrawSurface();

            // create the gray rectangle
            surface.setColor(java.awt.Color.GRAY);
            surface.fillRectangle((int) GRAY_RECTANGLE_START.getX(), (int) GRAY_RECTANGLE_START.getY(),
                    GRAY_RECTANGLE_WIDTH,
                    GRAY_RECTANGLE_HEIGHT);

            // move our balls
            for (int i = 0; i < balls.length; i++) {
                if (balls[i] == null) {
                    System.out.println("found null balls");
                    continue;
                }

                balls[i].moveOneStep();
                balls[i].drawOn(surface);
            }

            // create the yellow rectangle
            surface.setColor(java.awt.Color.YELLOW);
            surface.fillRectangle((int) YELLOW_RECTANGLE_START.getX(), (int) YELLOW_RECTANGLE_START.getY(),
                    YELLOW_RECTANGLE_WIDTH,
                    YELLOW_RECTANGLE_HEIGHT);

            gui.show(surface);
            sleeper.sleepFor(NUMBER_OF_MILLISECONDS_TO_WAIT);
            break;
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
