
import biuoop.DrawSurface;

/**
 * This class represents a sprite in a two dimensional cartesian plane.
*/
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}