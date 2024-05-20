
import java.awt.Color;
import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class AbstractArtDrawing {
    /**
     * @return A randomly generated line
     */
    public Line generateRandomLine() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
        int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
        int y2 = rand.nextInt(300) + 1; // get integer in range 1-300

        return new Line(x1, x2, y1, y2);
    }

    /**
     * @param line
     * @param drawer
     */
    public void drawLine(Line line, DrawSurface drawer) {
        int x1 = (int) line.start().getX();
        int x2 = (int) line.end().getX();

        int y1 = (int) line.start().getY();
        int y2 = (int) line.end().getY();

        drawer.drawLine(x1, x2, y1, y2);
    }

    /**
     */
    public void drawRandomLines() {
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("abc", 400, 300);
        DrawSurface drawer = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            Line line = generateRandomLine();

            drawer.setColor(Color.RED);
            drawLine(line, drawer);
        }

        gui.show(drawer);
    }

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomLines();
    }

}
