
import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * This class initializes and runs our game.
*/
public class Game {
    // GUI properties
    private static final String GUI_TITLE = "Arknoid (exclusive beta)";
    private static final int GUI_HEIGHT = 600;
    private static final int GUI_WIDTH = 800;
    private static final Color BACKGROUND_COLOR = java.awt.Color.decode("#000088");
    private static final Color BORDER_BACKGROUND_COLOR = java.awt.Color.decode("#808080");
    private static final int BORDER_BLOCK_SIZE = 20;

    // Blocks properties
    private static final int BLOCK_ROW_START_X = 0;
    private static final int BLOCK_ROW_START_Y = 50;
    private static final int DEFAULT_BLOCK_HEIGHT = 20;
    private static final int DEFAULT_BLOCK_WIDTH = 60;

    private static final int MAXIMUM_NUMBER_OF_BLOCKS_PER_ROW = 12;
    private static final int NUMBER_OF_ROWS_OF_BLOCKS = 6;

    private static final int DEFAULT_BALL_RADIUS = 10;

    private SpriteCollection spriteCollection;
    private GameEnvironment gameEnvironment;
    private GUI gui;
    private KeyboardSensor keyboard;
    private Sleeper sleeper = new Sleeper();
    private Counter remainingBlocks = new Counter();
    private Counter remainingBalls = new Counter();

    /**
     * The default constructor.
     */
    public Game() {
        this.spriteCollection = new SpriteCollection();
        this.gameEnvironment = new GameEnvironment();
        this.gui = new GUI(GUI_TITLE, GUI_WIDTH, GUI_HEIGHT);
        this.keyboard = this.gui.getKeyboardSensor();
    }

    /**
     * @param c the collidable we want to add
     */
    public void addCollidable(Collidable c) {
        gameEnvironment.addCollidable(c);

    }

    /**
     * @param c the collidable we want to remove
     */
    public void removeCollidable(Collidable c) {
        gameEnvironment.removeCollidable(c);
    }

    /**
     * @param s the sprite we want to add
     */
    public void addSprite(Sprite s) {
        spriteCollection.addSprite(s);
    }

    /**
     * @param s the sprite we want to remove
     */
    public void removeSprite(Sprite s) {
        spriteCollection.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them
     * to the game.
     */
    public void initialize() {
        // add two balls to the game
        Ball ball = new Ball(380, 500, DEFAULT_BALL_RADIUS, gameEnvironment);
        ball.addToGame(this);

        ball = new Ball(500, 500, DEFAULT_BALL_RADIUS, gameEnvironment);
        ball.addToGame(this);

        ball = new Ball(600, 450, DEFAULT_BALL_RADIUS, gameEnvironment);
        ball.addToGame(this);

        remainingBalls.increase(3);
        PrintingHitListener hitsPrinter = new PrintingHitListener();
        BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);
        BallRemover ballRemover = new BallRemover(this, remainingBalls);

        Rectangle upperRectangle = new Rectangle(new Point(0, 0), GUI_WIDTH, BORDER_BLOCK_SIZE);
        Rectangle downRectangle = new Rectangle(new Point(BORDER_BLOCK_SIZE, GUI_HEIGHT),
                GUI_WIDTH,
                DEFAULT_BLOCK_HEIGHT);

        Rectangle leftRectangle = new Rectangle(new Point(0, BORDER_BLOCK_SIZE),
                BORDER_BLOCK_SIZE, GUI_HEIGHT - BORDER_BLOCK_SIZE);
        Rectangle rightRectangle = new Rectangle(new Point(GUI_WIDTH - BORDER_BLOCK_SIZE, BORDER_BLOCK_SIZE),
                BORDER_BLOCK_SIZE, GUI_HEIGHT - BORDER_BLOCK_SIZE);

        Block block = new Block(upperRectangle, BORDER_BACKGROUND_COLOR);
        block.addToGame(this);

        block = new Block(downRectangle, BORDER_BACKGROUND_COLOR);
        block.addHitListener(ballRemover);
        block.addHitListener(hitsPrinter);
        block.addToGame(this);

        block = new Block(leftRectangle, BORDER_BACKGROUND_COLOR);
        block.addToGame(this);

        block = new Block(rightRectangle, BORDER_BACKGROUND_COLOR);
        block.addToGame(this);

        // add blocks to the game
        for (int i = 1; i <= NUMBER_OF_ROWS_OF_BLOCKS; i++) {
            Color color = Ball.generateRandomColor();
            for (int j = i + 1; j <= MAXIMUM_NUMBER_OF_BLOCKS_PER_ROW; j++) {
                Rectangle rect = new Rectangle(
                        new Point(BLOCK_ROW_START_X + DEFAULT_BLOCK_WIDTH * j,
                                BLOCK_ROW_START_Y + DEFAULT_BLOCK_HEIGHT * i),
                        DEFAULT_BLOCK_WIDTH,
                        DEFAULT_BLOCK_HEIGHT);
                block = new Block(rect, color);
                block.addToGame(this);
                block.addHitListener(blockRemover);
                remainingBlocks.increase(1);
            }

        }

        Rectangle paddleRectangle = new Rectangle(new Point(350, 525), 100, 20);
        Paddle paddle = new Paddle(keyboard, paddleRectangle, java.awt.Color.YELLOW);
        paddle.addToGame(this);

    }

    /**
     * pause the game in case of a bug.
     */
    public static void pause() {
        while (true) {
            assert true;
        }
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {

        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (true) {
            if (this.remainingBlocks.getValue() == 0 || this.remainingBalls.getValue() == 0) {
                gui.close();
                break;
            }

            long startTime = System.currentTimeMillis(); // timing
            DrawSurface drawer = gui.getDrawSurface();

            drawer.setColor(BACKGROUND_COLOR);
            drawer.fillRectangle(BORDER_BLOCK_SIZE, BORDER_BLOCK_SIZE, GUI_WIDTH - BORDER_BLOCK_SIZE,
                    GUI_HEIGHT - BORDER_BLOCK_SIZE);

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