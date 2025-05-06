
import listeners.HitListener;

/**
 * This class is an interface for collidables to notify when they got hit.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl the listener we want to add
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl the listener we want to add
     */
    void removeHitListener(HitListener hl);
}
