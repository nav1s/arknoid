
/**
*/
public class CollisionInfo {
    private Point pointOfCollision;
    private Collidable objectCollision;

    /**
     * @param pointOfCollision
     * @param objectCollision
     */
    public CollisionInfo(Point pointOfCollision, Collidable objectCollision) {
        this.pointOfCollision = pointOfCollision;
        this.objectCollision = objectCollision;
    }

    /**
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