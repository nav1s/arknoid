
/**
*/
public class Block implements Collidable {
    private Rectangle rect;

    /**
     * @param rect
     */
    public Block(Rectangle rect) {
        this.rect = rect;
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
        Line line = new Line(collisionPoint, beforeCollision);

        if (this.rect.checkVerticalHit(line)) {
            dx = -dx;
        }

        if (this.rect.checkVerticalHit(line)) {
            dy = -dy;
        }

        if (this.rect.checkCornerHit(collisionPoint)) {
            System.out.println(1);
            dx += 1;
        }

        return new Velocity(dx, dy);
    }

}