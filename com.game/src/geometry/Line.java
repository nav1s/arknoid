
package geometry;

import java.util.List;

/**
 * This class represents a line in a two dimensional cartesian plane.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start the starting point of our line
     * @param end   the ending point of our line
     *              taken from the exercise description
     */
    public Line(Point start, Point end) {
        this(start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * @param x1 coordinate x of the starting point of the line
     * @param y1 coordinate y of the starting point of the line
     * @param x2 coordinate x of the ending point of the line
     * @param y2 coordinate y of the ending point of the line
     *           taken from the exercise description.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return length of the line
     *         taken from the exercise description
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return middle point of the line
     *         taken from the exercise description
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * @return start point of the line
     *         taken from the exercise description
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return end point of the line
     *         taken from the exercise description
     */
    public Point end() {
        return this.end;
    }

    /**
     * @param other the line we are comparing to
     * @return true if the lines intersect, false otherwise
     *         taken from the exercise description
     */
    public boolean isIntersecting(Line other) {
        IntersectionChecker intersectionChecker = new IntersectionChecker(this, other);
        return intersectionChecker.isIntersecting();
    }

    /**
     * @param other1 the first line we are comparing to
     * @param other2 the second line we are comparing to
     * @return true if this 2 lines intersect with this line, false otherwise
     *         taken from the exercise description
     */
    public boolean isIntersecting(Line other1, Line other2) {
        return isIntersecting(other1) && isIntersecting(other2);
    }

    /**
     * @param other the line we are comparing to
     * @return Returns the intersection point if the lines intersect, and null
     *         otherwise
     *         taken from the exercise description.
     */
    public Point intersectionWith(Line other) {
        IntersectionChecker intersectionChecker = new IntersectionChecker(this, other);
        return intersectionChecker.getIntersectionPoint();
    }

    /**
     * @param other the line we want to compare to
     * @return true is the lines are equal, false otherwise
     *         taken from the exercise description
     */
    public boolean equals(Line other) {
        // if both lines have same start and same end then we can conclude they are
        // equal
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * @param rect the rectangle we want to check if the line intersects with
     * @return null if this line doesn't intersect with the rectangle, otherwise the
     *         closest intersection point to the start of the line
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints != null) {
            return intersectionPoints.get(0);
        }
        return null;

    }

    @Override
    public String toString() {
        return "Line [start=" + start + ", end=" + end + "]";
    }

    /**
     * @return the start point of the line
     */
    public Point getStart() {
        return start;
    }

    /**
     * @return the end point of the line
     */
    public Point getEnd() {
        return end;
    }

}