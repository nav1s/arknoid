
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 */
public class BouncingBallAnimation {

    /**
     * @param start the starting point of our ball
     * @param dx    the initial dx velocity
     * @param dy    the initial dy velocity
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        int height = 200;
        int width = 200;
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        ball.setHeight(height);
        ball.setWidth(width);

        GUI gui = new GUI("title", height, width);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50); // wait for 50 milliseconds.
        }
    }

    /**
     * @param args command line arguments used to create the ball.
     */
    public static void main(String[] args) {
        // check we got a correct number of variables
        if (args.length != 4) {
            System.out.println("Invalid input");
            System.exit(0);
        }

        int[] argsButInteger = new int[args.length];
        // make sure all of the variables we got are integers
        for (int i = 0; i < args.length; i++) {
            try {
                argsButInteger[i] = Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("Invalid input");
                System.exit(0);
            }
        }

        drawAnimation(new Point(argsButInteger[0], argsButInteger[1]), argsButInteger[2], argsButInteger[3]);
    }
}
