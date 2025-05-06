import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This class creates a gui with a bouncing ball.
 */
public class BouncingBallAnimation {
    private static final int NUMBER_OF_ARGUMENTS_REQUIRED = 4;

    // gui related finals
    private static final String GUI_TITLE = "Bouncing Ball Animation";
    private static final int GUI_HEIGHT = 200;
    private static final int GUI_WIDTH = 200;
    private static final int RADIUS = 30;
    private static final int NUMBER_OF_MILLISECONDS_TO_WAIT = 50;

    /**
     * @param start the starting point of our ball
     * @param dx    the initial dx velocity
     * @param dy    the initial dy velocity
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), RADIUS, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        ball.setMaxHeight(GUI_HEIGHT);
        ball.setMaxWidth(GUI_WIDTH);

        GUI gui = new GUI(GUI_TITLE, GUI_HEIGHT, GUI_WIDTH);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(NUMBER_OF_MILLISECONDS_TO_WAIT); // wait for 50 milliseconds.
        }
    }

    /**
     * @param args command line arguments used to create the ball.
     */
    public static void main(String[] args) {
        // check we got a correct number of variables
        if (args.length != NUMBER_OF_ARGUMENTS_REQUIRED) {
            System.out.println("Invalid input");
            System.exit(0);
        }

        int[] argsButInteger = new int[args.length];
        // convert all of our arguments to integer and exit if one of them isn't
        for (int i = 0; i < args.length; i++) {
            try {
                argsButInteger[i] = Integer.parseInt(args[i]);
            } catch (Exception e) {
                // exit if one of our arguments isn't an integer
                System.out.println("Invalid input");
                System.exit(0);
            }
            if (argsButInteger[i] <= 0) {
                // exit if one of our arguments is 0 or below
                System.out.println("Invalid input");
                System.exit(0);
            }
        }

        drawAnimation(new Point(argsButInteger[0], argsButInteger[1]), argsButInteger[2], argsButInteger[3]);
    }
}
