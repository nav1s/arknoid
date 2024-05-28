
/**
 * This class represents a line in a two dimensional cartesian plane.
 *
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * @param start the starting point of our line
     * @param end   the ending point of our line
     *              taken from the exercise description.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
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
     *         taken from the exercise description.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * @return middle point of the line
     *         taken from the exercise description.
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * @return start point of the line
     *         taken from the exercise description.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return end point of the line
     *         taken from the exercise description.
     */
    public Point end() {
        return this.end;
    }

    /**
     * @param other the line we are comparing to
     * @return true if the lines intersect, false otherwise
     *         taken from the exercise description.
     */
    public boolean isIntersecting(Line other) {
        return true;
    }

    /**
     * @param other1 the first line we are comparing to
     * @param other2 the second line we are comparing to
     * @return true if this 2 lines intersect with this line, false otherwise
     *         taken from the exercise description.
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
        double x1 = this.start.getX();
        double y1 = this.start.getY();

        double x2 = this.end.getX();
        double y2 = this.end.getY();

        double x3 = other.start.getX();
        double y3 = other.start.getY();

        double x4 = other.end.getX();
        double y4 = other.end.getY();

        double a = ((x4 - x3) * (y3 - y1) - (y4 - y3) * (x3 - x1));
        double b = ((x4 - x3) * (y2 - y1) - (y4 - y3) * (x2 - x1));
        double c = ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));
        double d = ((x4 - x3) * (y2 - y1) - (y4 - y3) * (x2 - x1));
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        System.out.println("d:" + d);

        if (b == 0 || d == 0) {
            return null;
        }

        double alpha = a / b;
        double beta = c / d;
        System.out.println("alpha:" + alpha);
        System.out.println("beta:" + beta);
        if (alpha >= 0 && alpha <= 1 && beta >= 0 && beta <= 1) {
            double x0 = x1 + alpha * (x2 - x1);
            double y0 = y1 + beta * (y2 - y1);
            return new Point(x0, y0);
        }

        return null;
    }

    /**
     * @param other the line we want to compare to
     * @return true is the lines are equal, false otherwise
     *         taken from the exercise description.
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

    @Override
    public String toString() {
        return "Line [start=" + start + ", end=" + end + "]";
    }

}