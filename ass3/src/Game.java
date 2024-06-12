
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
*/
public class Game {
    private static final int BLOCK_ROW_START_X = 9;
    private static final int BLOCK_ROW_START_Y = 50;

    private static final int DEFAULT_BLOCK_HEIGHT = 20;
    private static final int DEFAULT_BLOCK_WIDTH = 60;
    private SpriteCollection spriteCollection;
    private GameEnvironment gameEnvironment;
    private GUI gui;
    private KeyboardSensor keyboard;

    /**
     */
    public Game() {
        this.spriteCollection = new SpriteCollection();
        this.gameEnvironment = new GameEnvironment();
        this.gui = new GUI("title", 800, 600);
        this.keyboard = this.gui.getKeyboardSensor();
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

        ball = new Ball(500, 500, 10, gameEnvironment);
        ball.addToGame(this);

        for (int i = 1; i <= 6; i++) {
            Color color = Ball.generateRandomColor();
            for (int j = i + 1; j <= 12; j++) {
                Rectangle rect = new Rectangle(
                        new Point(10 + BLOCK_ROW_START_X + DEFAULT_BLOCK_WIDTH * j,
                                BLOCK_ROW_START_Y + DEFAULT_BLOCK_HEIGHT * i),
                        DEFAULT_BLOCK_WIDTH,
                        DEFAULT_BLOCK_HEIGHT);
                Block block = new Block(rect, color);
                block.addToGame(this);
            }

        }

        Rectangle paddleRectangle = new Rectangle(new Point(350, 525), 100, 20);
        Paddle paddle = new Paddle(keyboard, paddleRectangle, java.awt.Color.YELLOW);
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

}