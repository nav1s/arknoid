import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a rectangle in a two dimensional cartesian plane.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    private Point downerLeft;
    private Point downerRight;
    private Point upperRight;

    // setup all of the rectangles edges
    private Line upperEdge;
    private Line downerEdge;
    private Line leftEdge;
    private Line rightEdge;
    private List<Line> edges;

    /**
     * @param upperLeft the upper left corner of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     *                  Create a new rectangle with location and width/height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        calculateRectangleProperties();
    }

    /**
     * calculate all of the rectangles points and edges.
     */
    private void calculateRectangleProperties() {
        // setup all of the rectangles points
        this.downerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        this.downerRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());

        // setup all of the rectangles edges
        this.upperEdge = new Line(this.upperLeft, upperRight);
        this.downerEdge = new Line(downerLeft, downerRight);
        this.leftEdge = new Line(this.upperLeft, downerLeft);
        this.rightEdge = new Line(upperRight, downerRight);
        // setup an array with all of our edges
        this.edges = Arrays.asList(this.upperEdge, this.downerEdge, this.leftEdge, this.rightEdge);

    }

    /**
     * @param line the line to find intersection points for
     * @return a list of intersection points if any exist otherwise an empty list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> lst = new ArrayList<>();
        Point closestIntersectionPoint = null;

        // loop over of all the edges
        for (Line edge : this.edges) {
            Point intersectionPoint = line.intersectionWith(edge);
            // continue the loop if there isn't any intersection
            if (intersectionPoint == null) {
                continue;
            }
            // if this is the first intersection we found save it for later use
            if (closestIntersectionPoint == null) {
                closestIntersectionPoint = intersectionPoint;
                continue;
            }
            Point start = line.getStart();
            double dst1 = start.distance(closestIntersectionPoint);
            double dst2 = start.distance(intersectionPoint);
            // check if the new intersection point is closer than the previous one
            if (Double.compare(dst1, dst2) > 0) {
                lst.add(closestIntersectionPoint);
                closestIntersectionPoint = intersectionPoint;
                continue;
            }
            lst.add(intersectionPoint);
        }

        // add the closest intersection point to the beginning of the list
        if (closestIntersectionPoint != null) {
            lst.add(0, closestIntersectionPoint);
        }

        return lst;
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @return the upper-right point of the rectangle
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * @param x the x value of the collision point
     * @return true if we got a vertical hit, otherwise false
     */
    public boolean checkVerticalHit(double x) {
        if (Double.compare(x, this.upperRight.getX()) <= 0 || Double.compare(x, this.upperLeft.getX()) >= 0) {
            return true;
        }
        return false;

    }

    /**
     * @param y the y value of the collision point
     * @return true if we got a horizontal hit, otherwise false
     */
    public boolean checkHorizontalHit(double y) {
        if (Double.compare(y, this.upperRight.getY()) <= 0 || Double.compare(y, this.downerRight.getY()) >= 0) {
            return true;
        }
        return false;

    }

    /**
     * @param p the point we want to check
     * @return true
     */
    public boolean checkCornerHit(Point p) {
        if (p.equals(upperLeft) || p.equals(downerLeft) || p.equals(upperRight) || p.equals(downerRight)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rectangle [upperLeft=" + upperLeft + ", width=" + width + ", height=" + height + ", upperRight="
                + upperRight + "]";
    }

}