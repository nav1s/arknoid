
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * This class represents a paddle in a two dimensional cartesian plane.
 *
 */
public class Paddle implements Sprite, Collidable {
    private static final int SPEED = 10;
    private KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color = java.awt.Color.CYAN;

    private static final int GUI_WIDTH = 800;

    /**
     * @param keyboard an object representing the keyboard
     * @param rect the rectangle of our paddle
     * @param color the color of our paddle
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rect, Color color) {
        this.keyboard = keyboard;
        this.rect = rect;
        this.color = color;
    }

    /**
     * Move our paddle to the left.
     */
    public void moveLeft() {
        Point upperLeft = this.rect.getUpperLeft();
        double newX = upperLeft.getX() - SPEED;
        if (newX <= 0) {
            newX = GUI_WIDTH;
        }

        upperLeft.setX(newX);
        this.rect = new Rectangle(upperLeft, this.rect.getWidth(), this.rect.getHeight());
    }

    /**
     * Move our paddle to the right.
     */
    public void moveRight() {
        Point upperLeft = this.rect.getUpperLeft();
        double newX = upperLeft.getX() + SPEED;
        if (newX >= GUI_WIDTH) {
            newX = 0;
        }

        upperLeft.setX(newX);
        this.rect = new Rectangle(upperLeft, this.rect.getWidth(), this.rect.getHeight());

    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        double leftX = this.rect.getUpperLeft().getX();
        double position = collisionPoint.getX() - leftX;

        double angle = currentVelocity.calculateAngle();
        double speed = currentVelocity.calculateSpeed();
        if (position <= 20 && position >= 0) {
            angle = -60;
        } else if (position <= 40 && position >= 20) {
            angle = 330;
        } else if (position <= 60 && position >= 40) {
            assert true;
        } else if (position <= 80 && position >= 60) {
            angle = 30;
        } else if (position <= 100 && position >= 80) {
            angle = 60;
        }

        return Velocity.fromAngleAndSpeed(angle, speed);

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
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }

    }

    /**
     * @param g the game object
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}