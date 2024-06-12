
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
*/
public class Game {
    private SpriteCollection spriteCollection;
    private GameEnvironment gameEnvironment;
    private GUI gui;

    /**
     */
    public Game() {
        this.spriteCollection = new SpriteCollection();
        this.gameEnvironment = new GameEnvironment();
        this.gui = new GUI("title", 800, 600);
    }

    /**
     * @param c
     */
    public void addCollidable(Collidable c) {
        gameEnvironment.addCollidable(c);

    }

    /**
     * @param s
     */
    public void addSprite(Sprite s) {
        spriteCollection.addSprite(s);

    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them
     * to the game.
     */
    public void initialize() {
        Ball ball = new Ball(400, 500, 10, gameEnvironment);
        ball.addToGame(this);
        // for (...) {

        Rectangle paddleRectangle = new Rectangle(new Point(350, 525), 100, 50);
        Block paddle = new Block(paddleRectangle);
        paddle.addToGame(this);

        Rectangle screenRectangle = new Rectangle(new Point(0, 0), 800, 600);
        Block screen = new Block(screenRectangle);
        this.addCollidable(screen);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        Sleeper sleeper = new Sleeper();

        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface drawer = gui.getDrawSurface();
            this.spriteCollection.drawAllOn(drawer);
            gui.show(drawer);
            this.spriteCollection.notifyAllTimePassed();
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.initialize();
        game.run();
    }
}