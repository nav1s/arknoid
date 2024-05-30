
import biuoop.DrawSurface;

/**
 * This class represents a ball in a two dimensional cartesian plane.
 *
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;
    private int maxHeight;
    private int maxWidth;

    private Velocity velocity = new Velocity(0, 0);

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
        this.center = new Point(x1, x2);
        this.r = r;
        this.color = color;
    }

    /**
     * @param center
     * @param r
     * @param maxWidth
     * @param maxHeight
     */
    public Ball(Point center, int r, int maxHeight, int maxWidth)  {
        this.center = new Point(center.getX(), center.getY());
        this.color = new java.awt.Color((int) (Math.random() * 0x1000000));
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.velocity = new Velocity(50 / r, 50 / r);
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
     * @param weight the weight of our object
     */
    public void setVelocityWithWeight(int weight) {
        // Random rand = new Random(); // create a random-number generator
        // double dx = rand.nextDouble() * (1 / weight);
        // int x1 = rand.nextInt(this.guiWidth) + 1; // get integer in range 1-400
        // int y1 = rand.nextInt(this.guiHeight) + 1; // get integer in range 1-300

        this.velocity = new Velocity(0, 0);
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
        if (this.center.getX() < this.r) {
            this.velocity.reverseDx();
            this.center.setX(this.r);
        }
        if (this.center.getY() < this.r) {
            this.velocity.reverseDy();
            this.center.setY(this.r);
        }
        double maximumHeight = this.maxHeight - this.r;
        double maximumWidth = this.maxWidth - this.r;

        if (this.center.getY() > maximumHeight) {
            this.velocity.reverseDy();
            this.center.setY(maximumHeight);
        }

        if (this.center.getX() > maximumWidth) {
            this.velocity.reverseDx();
            this.center.setX(maximumWidth);
        }
    }

    @Override
    public String toString() {
        return "Ball [center=" + center + ", velocity=" + velocity + "]";
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

}