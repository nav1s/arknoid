
import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 */
public class AbstractArtDrawing {
    private static final int RADIUS = 3;

    /**
     * @return A randomly generated line
     */
    public Line generateRandomLine() {
        Random rand = new Random(); // create a random-number generator
        int guiWidth = 400;
        int guiHeight = 300;
        int x1 = rand.nextInt(guiWidth) + 1; // get integer in range 1-400
        int x2 = rand.nextInt(guiWidth) + 1; // get integer in range 1-400

        int y1 = rand.nextInt(guiHeight) + 1; // get integer in range 1-300
        int y2 = rand.nextInt(guiHeight) + 1; // get integer in range 1-300

        return new Line(x1, y1, x2, y2);
    }

    /**
     * @param line    the line to draw
     * @param surface the surface we want to draw on
     */
    public void drawLine(Line line, DrawSurface surface) {
        int x1 = (int) line.start().getX();
        int x2 = (int) line.end().getX();

        int y1 = (int) line.start().getY();
        int y2 = (int) line.end().getY();

        surface.drawLine(x1, y1, x2, y2);
    }

    /**
     * @param x       the x coordinate of the circle center
     * @param y       the y coordinate of the circle center
     * @param surface the surface we want to draw on
     */
    public void drawCircle(double x, double y, DrawSurface surface) {
        surface.fillCircle((int) x, (int) y, RADIUS);
    }

    /**
     * Draw 10 random lines.
     */
    public void drawRandomLines() {
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines", 400, 300);
        DrawSurface drawer = gui.getDrawSurface();
        Line[] lines = new Line[3];

        for (int i = 0; i <= lines.length - 1; i++) {
            lines[i] = generateRandomLine();
        }

        lines[0] = new Line(50, 50, 300, 300);
        lines[1] = new Line(203.0, 272.0, 341.0, 188.0);
        lines[2] = new Line(76.0, 204.0, 361.0, 225.0);
        // lines[3] = new Line(208.0, 248.0, 322.0, 209.0);
        Point[][] intersectionPoints = new Point[3][3];

        for (int i = 0; i <= lines.length - 1; i++) {
            drawer.setColor(Color.BLACK);
            drawLine(lines[i], drawer);
            Point middle = lines[i].middle();

            drawer.setColor(Color.BLUE);
            drawCircle(middle.getX(), middle.getY(), drawer);
            drawer.setColor(Color.RED);

            for (int j = 0; j < i; j++) {
                Point intersectionPoint = lines[i].intersectionWith(lines[j]);
                if (intersectionPoint != null) {
                    drawCircle(intersectionPoint.getX(), intersectionPoint.getY(), drawer);
                    intersectionPoints[i][j] = intersectionPoint;
                    intersectionPoints[j][i] = intersectionPoint;
                }
            }

        }
        System.out.println(
                Arrays.deepToString(intersectionPoints).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        // loop over the rows of our matrix
        for (int i = 0; i < intersectionPoints.length; i++) {
            // loop over the columns of our matrix
            for (int j = 0; j < intersectionPoints.length; j++) {
                Point firstIntersectionPoint = intersectionPoints[i][j];
                // continue if current point is empty
                if (firstIntersectionPoint == null) {
                    continue;
                }

                // check if we got another intersection point in the same row
                for (int k = j + 1; k < intersectionPoints.length; k++) {
                    Point secondIntersectionPoint = intersectionPoints[i][k];
                    if (secondIntersectionPoint == null) {
                        continue;
                    }
                    // check if the second point we found intersect with the first one
                    Point maybeTriangle = intersectionPoints[k][j];
                    if (maybeTriangle == null) {
                        continue;
                    }
                    drawer.setColor(Color.GREEN);
                    drawLine(new Line(maybeTriangle, secondIntersectionPoint), drawer);
                    drawLine(new Line(maybeTriangle, firstIntersectionPoint), drawer);
                }

            }
        }

        gui.show(drawer);

    }

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        AbstractArtDrawing abstractDrawer = new AbstractArtDrawing();
        abstractDrawer.drawRandomLines();
    }

}
