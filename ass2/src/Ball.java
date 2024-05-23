// import java.awt.Color;
import biuoop.DrawSurface;

/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;

    /**
     * @param center
     * @param r
     * @param color
     *               The constructor for ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;

    }

    /**
     * @param x1
     * @param x2
     * @param r
     * @param color
     *              The constructor for ball
     */
    public Ball(int x1, int x2, int r, java.awt.Color color) {
        this.center = new Point((double) x1, (double) x2);
        this.r = r;
        this.color = color;

    }

    /**
     * @return the value of x
     */
    public int getX() {
        return 0;

    }

    /**
     * @return the value of y
     */
    public int getY() {
        return 0;

    }

    /**
     * @return the value of size
     */
    public int getSize() {
        return 0;

    }

    /**
     * @return the value of color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * @param v
     */
    public void setVelocity(Velocity v) {

    }

    /**
     * @param dx
     * @param dy
     */
    public void setVelocity(double dx, double dy) {

    }

    /**
     * @return current velocity
     */
    public Velocity getVelocity() {
        return new Velocity(0, 0);
    }

    /**
     */
    public void moveOneStep() {
        // this.center = this.getVelocity().applyTocenter(this.center);
    }

}