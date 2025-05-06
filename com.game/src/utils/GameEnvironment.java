package utils;

import java.util.ArrayList;
import java.util.List;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

/**
 * This class holds the environment of our game.
*/
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * @param collidables an initial collidables list
     */
    public GameEnvironment(List<Collidable> collidables) {
        this.collidables = collidables;
    }
    /**
     * The default constructor.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     * @param c the collidable we want to add
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * remove the given collidable from the environment.
     * @param c the collidable we want to remove
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the trajectory line
     * @return collision info of the closest collision if there was any, otherwise null
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo closestCollision = null;

        double d1 = 0;
        double d2 = 0;
        Point start = trajectory.getStart();

        // loop over all of our collidables
        for (Collidable collidable : collidables) {
            // get a list of the current intersection points with the current collidables.
            Rectangle collisionRectangle = collidable.getCollisionRectangle();
            List<Point> intersectionPoints = collisionRectangle.intersectionPoints(trajectory);

            // if we don't intersect with anything we can move to the next collidable
            if (intersectionPoints.isEmpty()) {
                continue;
            }
            Point closestCollisionPoint = intersectionPoints.get(0);
            if (closestCollision == null) {
                closestCollision = new CollisionInfo(closestCollisionPoint, collidable);
                d1 = start.distance(closestCollisionPoint);
                continue;
            }

            d2 = start.distance(closestCollisionPoint);

            if (Double.compare(d1, d2) > 0) {
                d1 = d2;
                closestCollision = new CollisionInfo(closestCollisionPoint, collidable);
            }

        }
        if (closestCollision == null) {
            return null;
        }

        return closestCollision;

    }
}