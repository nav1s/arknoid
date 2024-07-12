
package geometry;

/**
 * This class represents a change in a position of an object on a two
 * dimensional cartesian plane.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * @param dx the dx we want to set
     * @param dy the dy we want to set
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @param p the point we apply the velocity to
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
     * reverse the current dx.
     */
    public void reverseDx() {
        this.dx = -this.dx;
    }

    /**
     * reverse the current dy.
     */
    public void reverseDy() {
        this.dy = -this.dy;
    }

    /**
     * @param angle the angle we want to convert
     * @param speed the speed we want to convert
     * @return new object of velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleInRadians = angle / 180 * Math.PI;
        double dy = -speed * Math.cos(angleInRadians);
        double dx = speed * Math.sin(angleInRadians);
        return new Velocity(dx, dy);
    }

    /**
     * @return the current speed
     */
    public double calculateSpeed() {
        return Math.sqrt(this.dx * this.dx + this.dy * this.dy);
    }

    /**
     * @return the current angle
     */
    public double calculateAngle() {
        return Math.atan2(dy, dx);
    }

    /**
     * @param dy the new dy we want to set
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * @param dx the new dx we want to set
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    @Override
    public String toString() {
        return "Velocity [dx=" + dx + ", dy=" + dy + "]";
    }

}
