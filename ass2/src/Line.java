
/**
 * This class does some simple testing of the Point and Line classes.
 *
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start the starting point of our line
     * @param end the ending point of our line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @param x1 coordinate x of the start line
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return middle point of the line
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * @return start point of the line
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return end point of the line
     */
    public Point end() {
        return this.end;
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
     * @return Returns the intersection point if the lines intersect, and null
     *         otherwise
     */
    public Point intersectionWith(Line other) {
        return new Point(0, 0);
    }

    /**
     * @param other the line we want to compare to
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        // if both lines have same start and same end then we can conclude they are equal
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * @return A string
     */
    @Override
    public String toString() {
        return "";
    }

}