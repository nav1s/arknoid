
import java.util.List;

import biuoop.DrawSurface;

/**
*/
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * @param s
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