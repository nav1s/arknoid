
import java.awt.Color;
import java.util.Random;

import biuoop.DrawSurface;

/**
 * This class represents a block in a two dimensional cartesian plane.
 *
 */
public class Block implements Collidable, Sprite {
    private Rectangle rect;
    private java.awt.Color color;

    /**
     * @param rect
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.color = Ball.generateRandomColor();
    }

    /**
     * @param rect
     * @param color
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        Random rand = new Random();

        if (this.rect.checkVerticalHit(collisionPoint.getX())) {
            dx = -dx;
        }

        if (this.rect.checkHorizontalHit(collisionPoint.getY())) {
            dy = -dy;
        }

        if (this.rect.checkCornerHit(collisionPoint)) {
            double tmp = dx + rand.nextDouble(0, 2);
            dx = dy + rand.nextDouble(0, 2);
            dy = tmp;
        }

        return new Velocity(dx, dy);
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        Point upperLeft = this.rect.getUpperLeft();
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
        surface.setColor(java.awt.Color.BLACK);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * @param g the game object
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}