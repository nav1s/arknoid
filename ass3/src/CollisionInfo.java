
/**
*/
public class CollisionInfo {
    /**
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return new Point(0, 0);
    }

    /**
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return new Block();
    }
}