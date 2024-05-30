
/**
 * This class represents a change in a position of an object on a two dimensional cartesian plane.
 */
public class Velocity {
    private double dx;
    private double dy;

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
        return this.dx;
    }

    /**
     */
    public void reverseDx() {
        this.dx = -this.dx;
    }

    /**
     */
    public void reverseDy() {
        this.dy = -this.dy;
    }

    /**
     * @param angle
     * @param speed
     * @return the value of dx
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleInRadians = angle / 180 * Math.PI;
        double dx = speed * Math.cos(angleInRadians);
        double dy = speed * Math.sin(angleInRadians);
        return new Velocity(dx, dy);
    }

    @Override
    public String toString() {
        return "Velocity [dx=" + dx + ", dy=" + dy + "]";
    }

}
