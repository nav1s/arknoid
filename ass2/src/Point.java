
/**
 * This class represents a point in a two dimensional cartesian plane.
 *
 */
public class Point {
    private double x;
    private double y;

    /**
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

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
     * The main constructor for point (taken from the exercise description).
     * @param x x coordinate of our point
     * @param y y coordinate of our point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A function to calculate the distance between two points (taken from the exercise description).
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
     * A function to check if two points are equal (taken from the exercise description).
     * @param other the point to compare with
     * @return true is the points are equal, false otherwise
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
     * A function to get the value of y (taken from the exercise description).
     * @return the value of x
     */
    public double getX() {
        return this.x;
    }

    /**
     * A function to get the value of y (taken from the exercise description).
     * @return the value of y
     */
    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

}
