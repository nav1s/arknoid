
import java.util.ArrayList;

/**
 * This class represents a rectangle in a two dimensional cartesian plane.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private java.awt.Color color;

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
        this.color = Ball.generateRandomColor();
    }

    /**
     * @param line
     * @return a list of intersection points if any exist otherwise an empty list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ArrayList<Point> lst = new ArrayList<>();
        // setup all of the rectangles points
        Point downerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point downerRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());

        // setup all of the rectangles edges
        Line upperEdge = new Line(this.upperLeft, upperRight);
        Line downerEdge = new Line(downerLeft, downerRight);
        Line leftEdge = new Line(this.upperLeft, downerLeft);
        Line rightEdge = new Line(upperRight, downerRight);

        // setup an array with all of our edges
        Line[] edges = new Line[] {upperEdge, downerEdge, leftEdge, rightEdge};

        for (Line edge : edges) {
            Point intersectionPoint = line.intersectionWith(edge);
            if (intersectionPoint != null) {
                lst.add(intersectionPoint);
            }
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
}