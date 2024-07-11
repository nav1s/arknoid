
import biuoop.DrawSurface;

/**
 * This class is in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * @param currentScore a counter for our current score
     */
    public ScoreIndicator(Counter currentScore) {
        this.currentScore = currentScore;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        int x = 400;
        int y = 20;
        String score = "Score: " + currentScore.toString();
        int fontSize = 30;
        surface.setColor(java.awt.Color.BLACK);
        surface.drawText(x, y, score, fontSize);
    }

    @Override
    public void timePassed() {
    }

    /**
     * @param g the game object
     */
    public void addToGame(Game g) {
        g.addSprite(this);
    }

    /**
     * @param g the game object
     */
    public void removeFromGame(Game g) {
        g.removeSprite(this);
    }

}