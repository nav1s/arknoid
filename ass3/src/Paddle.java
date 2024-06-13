
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 */
public class Paddle implements Sprite, Collidable {
    private static final int SPEED = 10;
    private KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color = java.awt.Color.CYAN;

    private static final int GUI_WIDTH = 800;

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
        Point upperLeft = this.rect.getUpperLeft();
        double newX = upperLeft.getX() - SPEED;
        if (newX <= 0) {
            newX = GUI_WIDTH;
        }

        upperLeft.setX(newX);
        this.rect = new Rectangle(upperLeft, this.rect.getWidth(), this.rect.getHeight());
    }

    /**
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

        currentVelocity.calculateAngleAndSpeed();
        double angle = currentVelocity.getAngle();
        double speed = currentVelocity.getSpeed();
        if (position <= 20 && position >= 0) {
            System.out.println(1);
            angle = 300 / 180 * Math.PI;
        } else if (position <= 40 && position >= 20) {

            System.out.println(2);
            angle = 330;
        } else if (position <= 60 && position >= 40) {
            System.out.println(3);
            angle = 180;
        } else if (position <= 80 && position >= 60) {
            System.out.println(4);
            angle = 30;
        } else if (position <= 100 && position >= 80) {
            angle = 60;
        }

        // System.out.println(position);
        // System.out.println(currentVelocity);
        // System.out.println(rect);
        // System.out.println(collisionPoint);
        // while (true) {
        // if (this.keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
        // break;
        // }
        // }

        // return new Velocity(dx, dy);
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
     * @param g
     */
    public void addToGame(Game g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}