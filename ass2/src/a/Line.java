
package a;

/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class Line {
    /**
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
    }

    /**
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
    }

    /**
     * @return length of the line
     */
    public double length() {
        return 0;
    }

    /**
     * @return middle point of the line
     */
    public Point middle() {
        return new Point(0, 0);
    }

    /**
     * @return start point of the line
     */
    public Point start() {
        return new Point(0, 0);
    }

    /**
     * @return end point of the line
     */
    public Point end() {
        return new Point(0, 0);
    }

    /**
     * @param other
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        return true;
    }

    /**
     * @param other1
     * @param other2
     * @return true if this 2 lines intersect with this line, false otherwise
     */
    public boolean isIntersecting(Line other1, Line other2) {
        return true;
    }

    /**
     * @param other
     * @return Returns the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        return new Point(0, 0);
    }

    /**
     * @param other
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return true;
    }
}