
import java.util.ArrayList;

/**
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * @param upperLeft
     * @param width
     * @param height
     *                  Create a new rectangle with location and width/height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @param line
     * @return a list of intersection points if any exist otherwise an empty list
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        return new ArrayList<Point>();
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