
import java.util.Random;

import biuoop.DrawSurface;

/**
 * This class represents a ball in a two dimensional cartesian plane.
 *
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;
    private int minHeight = 0;
    private int maxHeight = 0;

    private int minWidth;

    private int maxWidth;
    private static final int SPEED_MODIFIER = 100;

    private Velocity velocity = new Velocity(0, 0);
    // create a random-number generator
    private Random rand = new Random();

    /**
     * @param center
     * @param r
     * @param color
     *               taken from the exercise description.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this(center.getX(), center.getY(), r, color);
    }

    /**
     * @param x1
     * @param x2
     * @param r
     * @param color
     */
    public Ball(int x1, int x2, int r, java.awt.Color color) {
        this((double) x1, (double) x2, r, color);
    }

    /**
     * @param x1
     * @param x2
     * @param r
     * @param color
     */
    public Ball(double x1, double x2, int r, java.awt.Color color) {
        this.minHeight = 0;
        this.minWidth = 0;
        this.center = new Point(x1, x2);
        this.r = r;
        this.color = color;
    }

    /**
     * @param r         the ball radius
     * @param minHeight the minimum height our ball is allowed to be in
     * @param maxHeight the maximum height our ball is allowed to be in
     * @param minWidth  the minimum width our ball is allowed to be in
     * @param maxWidth  the maximum width our ball is allowed to be in
     */
    public Ball(int r, int minHeight, int maxHeight, int minWidth, int maxWidth) {
        this.r = r;

        this.minHeight = minHeight;
        this.maxHeight = maxHeight;

        this.minWidth = minWidth;
        this.maxWidth = maxWidth;

        this.color = generateRandomColor();
        this.velocity = new Velocity(SPEED_MODIFIER / r, SPEED_MODIFIER / r);
        this.center = generateRandomPointBounded();
    }

    /**
     * @param center
     * @param r
     */
    public Ball(Point center, int r) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = generateRandomColor();

        this.velocity = new Velocity(SPEED_MODIFIER / r, SPEED_MODIFIER / r);
    }

    private java.awt.Color generateRandomColor() {
        // generate a random color
        int blue = rand.nextInt(256);
        int green = rand.nextInt(256);
        int red = rand.nextInt(256);

        return new java.awt.Color(red, green, blue);

    }

    /**
     * @return a randomly generated point bounded to a given area
     */
    private Point generateRandomPointBounded() {
        int y1 = rand.nextInt(maxHeight - minHeight) + minHeight;
        int x1 = rand.nextInt(maxWidth - minWidth) + minWidth;

        return new Point(x1, y1);
    }

    /**
     * @return the value of x
     *         taken from the exercise description.
     */
    public int getX() {
        return (int) this.center.getX();

    }

    /**
     * @return the value of y (taken from the exercise description).
     *         taken from the exercise description.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the value of r
     *         taken from the exercise description.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the value of color
     *         taken from the exercise description.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param surface
     *                Draw our ball on a surface
     *                taken from the exercise description.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * @param v the velocity we want to set
     *          taken from the exercise description.
     */
    public void setVelocity(Velocity v) {
        this.velocity = new Velocity(v.getDx(), v.getDy());

    }

    /**
     * @param dx
     * @param dy
     *           taken from the exercise description.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);

    }

    /**
     * @return current velocity
     *         taken from the exercise description.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * taken from the exercise description.
     */
    public void moveOneStep() {
        this.center = this.getVelocity().applyToPoint(this.center);
        if (this.center.getX() < this.r + this.minWidth) {
            this.velocity.reverseDx();
            this.center.setX(this.r + this.minWidth);
        }
        if (this.center.getY() < this.r + this.minHeight) {
            this.velocity.reverseDy();
            this.center.setY(this.r + this.minHeight);
        }
        int maximumHeight = this.maxHeight - this.r;
        int maximumWidth = this.maxWidth - this.r;

        if (this.center.getY() > maximumHeight) {
            this.velocity.reverseDy();
            this.center.setY(maximumHeight);
        }

        if (this.center.getX() > maximumWidth) {
            this.velocity.reverseDx();
            this.center.setX(maximumWidth);
        }
    }

    /**
     * @return the height of the gui.
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * @param height
     */
    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    /**
     * @return the width of the gui.
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * @param width
     */
    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    @Override
    public String toString() {
        return "Ball [center=" + center + ", r=" + r + ", color=" + color + ", minHeight=" + minHeight + ", maxHeight="
                + maxHeight + ", minWidth=" + minWidth + ", maxWidth=" + maxWidth + ", velocity=" + velocity + "]";
    }

    /**
     * @return the minimum height
     */
    public int getMinHeight() {
        return minHeight;
    }

    /**
     * @param minHeight
     */
    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    /**
     * @return the minimum width
     */
    public int getMinWidth() {
        return minWidth;
    }

    /**
     * @param minWidth
     */
    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * @return the center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

}