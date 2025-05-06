package collections;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
import sprites.Sprite;

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
     * @param s the sprite we want to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }

    }

    /**
     * call drawOn(d) on all sprites.
     * @param d
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}