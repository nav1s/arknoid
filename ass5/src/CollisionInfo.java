
/**
 * This class represents an info about collision occurring in a two dimensional cartesian plane.
*/
public class CollisionInfo {
    private Point pointOfCollision;
    private Collidable objectCollision;

    /**
     * @param pointOfCollision the point the collision has occurred
     * @param objectCollision the object the collision has occurred with
     */
    public CollisionInfo(Point pointOfCollision, Collidable objectCollision) {
        this.pointOfCollision = pointOfCollision;
        this.objectCollision = objectCollision;
    }

    /**
     * An empty constructor for collision info.
     */
    public CollisionInfo() {
    }

    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.pointOfCollision;
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.objectCollision;
    }
}