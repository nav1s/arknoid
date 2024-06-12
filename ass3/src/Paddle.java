
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color;

    /**
     * @param keyboard
     * @param rect
     * @param color
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rect, Color color) {
        this.keyboard = keyboard;
        this.rect = rect;
        this.color = color;
    }

    /**
     */
    public void moveLeft() {

    }

    /**
     */
    public void moveRight() {

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
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        Point upperLeft = this.rect.getUpperLeft();
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            System.out.println("the 'left arrow' key is pressed");
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            System.out.println("the 'right arrow' key is pressed");
        }
    }

    /**
     * @param g
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}