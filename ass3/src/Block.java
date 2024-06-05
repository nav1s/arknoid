/**
*/
public class Block implements Collidable {

    /**
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return new Rectangle(null, 0, 0);
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given
     * velocity.
     * @param collisionPoint
     * @param currentVelocity
     * @return the new velocity expected after the hit (based on the force the
     *         object inflicted on us).
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        return new Velocity(0, 0);

    }
}