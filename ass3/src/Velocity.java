
/**
 * This class represents a change in a position of an object on a two
 * dimensional cartesian plane.
 */
public class Velocity {
    private double dx;
    private double dy;

    private double angle;
    private double speed;

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
        double dx = speed * Math.cos(angleInRadians);
        double dy = speed * Math.sin(angleInRadians);
        return new Velocity(dx, dy);
    }

    /**
     */
    public void calculateAngleAndSpeed() {
        if (this.dx == 0) {
            System.out.println("invalid velocity detected");
            System.out.println(this);
            Game.pause();
        }

        this.angle = Math.atan2(dy, dx);
        this.speed = Math.sqrt(this.dx * this.dx + this.dy * this.dy);
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

    /**
     * @return the current velocity angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return the current velocity speed
     */
    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Velocity [dx=" + dx + ", dy=" + dy + ", angle=" + angle + ", speed=" + speed + "]";
    }

}
