
package utils;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;

/**
 * This class is an interface for an object you can collide with.
*/
public interface Collidable {

    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given
     * velocity.
     * @param hitter
     * @param collisionPoint
     * @param currentVelocity
     * @return the new velocity expected after the hit (based on the force the
     *         object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}