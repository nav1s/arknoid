
package listeners;

import sprites.Ball;
import sprites.Block;
import utils.Counter;

/**
 * This class increases the score counter whenever a block got hit.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * @param scoreCounter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit the block that got hit
     * @param hitter the ball that made the hit with the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        // System.out.println("current score: " + currentScore);
        currentScore.increase(5);
    }
}