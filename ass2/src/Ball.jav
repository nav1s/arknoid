import biuoop.DrawSurface;

/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class Ball {
    // constructor
    public Ball(Point center, int r, java.awt.Color color) {

    }

    // accessors
    public int getX();

    public int getY();

    public int getSize();

    public java.awt.Color getColor();

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface);
}