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

    // public void drawLine(Line l, DrawSurface d) {
    //     DrawSurface d = gui.getDrawSurface();

    // }

    /**
     */
    public void drawRandomLines() {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("abc", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
            int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
            int y2 = rand.nextInt(300) + 1; // get integer in range 1-300

            d.setColor(Color.RED);
            d.drawLine(x1, x2, y1, y2);
        }

        int x1 = 0;
        int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
        int y2 = rand.nextInt(300) + 1; // get integer in range 1-300

        d.setColor(Color.RED);
        d.drawLine(x1, x2, y1, y2);
        gui.show(d);
    }

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomLines();
    }

}
