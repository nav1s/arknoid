
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
     * @param rect the rectangle of our block
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.color = Ball.generateRandomColor();
    }

    /**
     * @param rect the rectangle of our block
     * @param color the color of the block
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * @param num1 the first number we want to check
     * @param num2 the second number we want to check
     * @return a random double between num1 and num2
     */
    public static double randomDoubleBounded(double num1, double num2) {
        Random rand = new Random();
        double randomDouble = rand.nextDouble();
        return num1 + (randomDouble * (num2 - num1));

    }

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if (this.rect.checkVerticalHit(collisionPoint.getX())) {
            dx = -dx;
        }

        if (this.rect.checkHorizontalHit(collisionPoint.getY())) {
            dy = -dy;
        }

        if (this.rect.checkCornerHit(collisionPoint)) {
            double tmp = dx + randomDoubleBounded(0, 2);
            dx = dy + randomDoubleBounded(0, 2);
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