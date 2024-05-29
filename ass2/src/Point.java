
/**
 * This class represents a point in a two dimensional cartesian plane.
 *
 */
public class Point {
    private double x;
    private double y;

    static final double COMPARISONTHRESHOLD = 0.00001;

    /**
     *
     * @param a The first double number to compare.
     * @param b the second double number to compare.
     * @return true if our two doubles are equal, otherwise false.
     */
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < Point.COMPARISONTHRESHOLD;
    }

    /**
     * @param x x coordinate of our point
     * @param y y coordinate of our point
     * taken from the exercise description
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param other the other point to compare
     * @return distance from this point to the other point
     * taken from the exercise description
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
     * @param other the point we want to compare
     * @return true is the points are equal, false otherwise
     * taken from the exercise description
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if (doubleEquals(this.x, other.x) && doubleEquals(this.y, other.y)) {
            return true;

        }
        return false;
    }

    /**
     * @return the value of x
     * taken from the exercise description
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the value of y
     * taken from the exercise description
     */
    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    /**
     * @param y the new value of this.y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @param x the new value of this.x
     */
    public void setX(double x) {
        this.x = x;
    }

}
