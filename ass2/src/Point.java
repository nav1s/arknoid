
/**
 * This class represents a point in a two dimensional cartesian plane.
 *
 */
public class Point {
    private double x;
    private double y;

    /**
     * @param x x coordinate of our point
     * @param y y coordinate of our point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other the other point to compare
     * @return distance of this point to the other point
     */
    public double distance(Point other) {
        if (other == null) {
            return -1;
        }
        double xDist = Math.pow((this.x - other.x), 2);
        double yDist = Math.pow((this.y - other.y), 2);
        return Math.sqrt(xDist + yDist);
    }

    /**
     * @param other
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if (this.x == other.x && this.y == other.y) {
            return true;

        }
        return false;
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
    /**
     * @return A string
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}