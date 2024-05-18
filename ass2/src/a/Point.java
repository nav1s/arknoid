
package a;
/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class Point {
    private double x;
    private double y;

    /**
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other
     * @return distance of this point to the other point
     */
    public double distance(Point other) {
        return 0;
    }

    /**
     * @param other
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        return true;
    }

    /**
     * @return the value of x
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the value of y
     */
    public double getY() {
        return this.y;
    }
}