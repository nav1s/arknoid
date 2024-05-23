
/**
 */
public class Velocity {
    private double dx;
    private double dy;

    // constructor
    /**
     * @param dx
     * @param dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * @param p
     * @return A point with the velocity
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * @return the value of dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * @return the value of dx
     */
    public double getDx() {
        return this.dy;
    }

    /**
     * @param d
     * @param e
     * @return the value of dx
     */
    public static Velocity fromAngleAndSpeed(double d, double e) {
        return new Velocity(0, 0);
    }
}
