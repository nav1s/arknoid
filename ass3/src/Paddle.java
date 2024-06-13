
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle rect;
    private java.awt.Color color = java.awt.Color.CYAN;
    private GameEnvironment gameEnvironment;

    /**
     * @param keyboard
     * @param rect
     * @param color
     * @param gameEnvironment
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rect, Color color, GameEnvironment gameEnvironment) {
        this.keyboard = keyboard;
        this.rect = rect;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     */
    public void moveLeft() {
        Point upperLeft = this.rect.getUpperLeft();
        Point upperRight = this.rect.getUpperRight();
        Velocity velocity = new Velocity(-5, 0);
        Point endOfTrajectory = velocity.applyToPoint(upperLeft);

        Point endOfTrajectoryWithWidthAndHeight = velocity.applyToPoint(upperRight);
        Line trajectory = new Line(endOfTrajectory, endOfTrajectoryWithWidthAndHeight);

        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            System.out.println(trajectory);
            System.out.println(collisionInfo.collisionPoint());
            System.out.println(collisionInfo.collisionObject());
        }

        this.rect = new Rectangle(endOfTrajectory, this.rect.getWidth(), this.rect.getHeight());
    }

    /**
     */
    public void moveRight() {
        Point upperLeft = this.rect.getUpperLeft();
        upperLeft.setX(upperLeft.getX() + 5);
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
            angle = 300 / 180 * Math.PI;
        } else if (position <= 40 && position >= 20) {
            angle = 330 / 180 * Math.PI;
        } else if (position <= 60 && position >= 40) {
            angle = 180 * Math.PI;
        } else if (position <= 80 && position >= 60) {
            angle = 30 / 180 * Math.PI;
        } else if (position <= 100 && position >= 80) {
            angle = 60 / 180 * Math.PI;
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