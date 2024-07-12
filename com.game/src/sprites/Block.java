
package sprites;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listeners.HitListener;
import utils.Collidable;
import utils.Game;
import utils.HitNotifier;

/**
 * This class represents a block in a two dimensional cartesian plane.
 *
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private java.awt.Color color;
    private ArrayList<HitListener> hitListeners = new ArrayList<HitListener>();

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
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();

        if (this.rect.checkVerticalHit(collisionPoint.getX())) {
            dx = -dx;
        }

        if (this.rect.checkHorizontalHit(collisionPoint.getY())) {
            dy = -dy;
        }

        // if (this.rect.checkCornerHit(collisionPoint)) {
        // double tmp = dx + randomDoubleBounded(0, 2);
        // dx = dy + randomDoubleBounded(0, 2);
        // dy = tmp;
        // }

        if (!ballColorMatch(hitter)) {
            this.notifyHit(hitter);
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

    /**
     * @param g the game object
     */
    public void removeFromGame(Game g) {
        g.removeCollidable(this);
        g.removeSprite(this);
    }

    /**
     * @param ball the ball we want to check
     * @return true if the color matches, otherwise false
     */
    public boolean ballColorMatch(Ball ball) {
        if (ball.getColor().equals(this.color)) {
            return true;
        }

        return false;
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * @return the color of the block
     */
    public java.awt.Color getColor() {
        return color;
    }


}