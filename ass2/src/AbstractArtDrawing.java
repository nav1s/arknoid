
import java.awt.Color;
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 */
public class AbstractArtDrawing {

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
     * @param line   the line to draw
     * @param drawer
     */
    public void drawLine(Line line, DrawSurface drawer) {
        int x1 = (int) line.start().getX();
        int x2 = (int) line.end().getX();

        int y1 = (int) line.start().getY();
        int y2 = (int) line.end().getY();

        drawer.drawLine(x1, y1, x2, y2);
    }

    /**
     * @param x the x coordinate of the circle center
     * @param y the y coordinate of the circle center
     * @param drawer
     */
    public void drawCircle(double x, double y, DrawSurface drawer) {
        int r = 3;
        drawer.fillCircle((int) x, (int) y, r);
    }

    /**
     * Draw 10 random lines.
     */
    public void drawRandomLines() {
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Circles", 400, 300);
        DrawSurface drawer = gui.getDrawSurface();
        Line[] lines = new Line[10];

        for (int i = 0; i <= lines.length - 1; i++) {
            lines[i] = generateRandomLine();
        }
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
