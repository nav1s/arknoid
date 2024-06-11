
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
        return new Velocity(-dx, -dy);
    }

}