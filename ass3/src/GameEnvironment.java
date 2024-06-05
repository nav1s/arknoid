/**
*/
public class GameEnvironment {

    /**
     * add the given collidable to the environment.
     * @param c
     */
    public void addCollidable(Collidable c) {
        return;
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    /**
     * @param trajectory
     * @return a
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        return new CollisionInfo();
    }
}