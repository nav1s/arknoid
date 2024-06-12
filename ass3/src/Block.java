
import java.awt.Color;

import biuoop.DrawSurface;

/**
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

        Point beforeCollision = new Point(collisionPoint.getX() - 1, collisionPoint.getY() - 1);
        Line line = new Line(beforeCollision, collisionPoint);

        if (this.rect.checkVerticalHit(line)) {
            dx = -dx;
        }

        if (this.rect.checkHorizontalHit(line)) {
            dy = -dy;
        }

        if (this.rect.checkCornerHit(collisionPoint)) {
            dx += 1;
            dy += 1;
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
     * @param g
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}