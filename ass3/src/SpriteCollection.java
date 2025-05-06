import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * This class holds a collection of sprites.
*/
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * The main constructor for sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * @param s the sprite we want to add
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }

    }

    /**
     * call drawOn(d) on all sprites.
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}