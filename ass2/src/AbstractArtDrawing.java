
import java.awt.Color;
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * This class Draws 10 random lines.
 */
public class AbstractArtDrawing {
    // define some finals for later use
    private static final int GUI_HEIGHT = 300;
    private static final int GUI_WIDTH = 400;
    private static final String GUI_TITLE = "Random Lines";
    private static final int RADIUS = 3;
    private static final int NUMBER_OF_LINES = 10;

    /**
     * @return A randomly generated line
     */
    public Line generateRandomLine() {
        // create a random-number generator
        Random rand = new Random();

        int x1 = rand.nextInt(GUI_WIDTH) + 1;
        int x2 = rand.nextInt(GUI_WIDTH) + 1;

        int y1 = rand.nextInt(GUI_HEIGHT) + 1;
        int y2 = rand.nextInt(GUI_HEIGHT) + 1;

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
        GUI gui = new GUI(GUI_TITLE, GUI_WIDTH, GUI_HEIGHT);
        DrawSurface surface = gui.getDrawSurface();
        Line[] lines = new Line[NUMBER_OF_LINES];

        Point[][] intersectionPoints = new Point[NUMBER_OF_LINES][NUMBER_OF_LINES];

        for (int i = 0; i <= lines.length - 1; i++) {
            // generate a random lines
            lines[i] = generateRandomLine();
            // draw the line we generated
            surface.setColor(Color.BLACK);
            drawLine(lines[i], surface);

            // mark the middle point of our line
            Point middle = lines[i].middle();
            surface.setColor(Color.BLUE);
            drawCircle(middle.getX(), middle.getY(), surface);

            // mark all the intersection points between our lines
            surface.setColor(Color.RED);
            for (int j = 0; j < i; j++) {
                Point intersectionPoint = lines[i].intersectionWith(lines[j]);
                if (intersectionPoint != null) {
                    drawCircle(intersectionPoint.getX(), intersectionPoint.getY(), surface);
                    intersectionPoints[i][j] = intersectionPoint;
                    intersectionPoints[j][i] = intersectionPoint;
                }
            }

        }

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
                    surface.setColor(Color.GREEN);
                    drawLine(new Line(maybeTriangle, secondIntersectionPoint), surface);
                    drawLine(new Line(maybeTriangle, firstIntersectionPoint), surface);
                }

            }
        }

        gui.show(surface);

    }

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        AbstractArtDrawing abstractDrawer = new AbstractArtDrawing();
        abstractDrawer.drawRandomLines();
    }

}
