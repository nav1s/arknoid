
package listeners;

import sprites.Ball;
import sprites.Block;

/**
 * This class represents an interface for objects that want to listen to hits.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit
     * @param hitter
     */
    void hitEvent(Block beingHit, Ball hitter);
}