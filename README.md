## Overview
This project is an implementation of the classic Arkanoid (Breakout) game in Java. Players control a paddle to bounce balls and break blocks, earning points for each block destroyed.

## Game Features
- Colorful blocks arranged in rows
- Multiple balls in play
- Paddle control with keyboard
- Score tracking
- Physics-based collision system
- Special block interactions

## How to Run

### Prerequisites
- Java Runtime Environment (JRE) 8 or above
- Apache Ant

### Running the Game
Using Ant:
```
ant run
```

## Game Controls
- **Left Arrow**: Move paddle left
- **Right Arrow**: Move paddle right

## Game Rules
1. Control the paddle to prevent balls from falling off the bottom of the screen
2. Break all the blocks to win the game
3. If all balls are lost, the game ends
4. Earn 5 points for each block destroyed

## Technical Implementation

### Architecture
The game follows an object-oriented design with several key components:

- **Game**: Manages the game loop, initialization, and main logic
- **Sprites**: Visual elements that can be drawn and animated
- **Collidables**: Objects that can be collided with
- **Listeners**: Components that respond to game events
- **GameEnvironment**: Manages collision detection between objects

### Collision Physics
Collision detection uses geometric calculations to determine:
- The point of impact between objects
- The appropriate velocity changes after collision
- Special interactions like angle changes based on paddle position

### Event System
The game implements a listener pattern for events:
- **HitListener**: Interface for objects that respond to collision events
- **ScoreTrackingListener**: Updates score when blocks are hit
- **BlockRemover**: Removes blocks when they're hit
- **BallRemover**: Removes balls when they fall off the screen

## Project Structure

### Packages
- **geometry**: Contains classes for geometric calculations (Point, Line, Rectangle, Velocity)
- **sprites**: Visual game objects (Ball, Block, Paddle, ScoreIndicator)
- **utils**: Core game utilities (Game, GameEnvironment, Collidable)
- **listeners**: Event handling interfaces and implementations
- **collections**: Container classes for managing groups of objects

### Key Classes
- **Game**: Main class responsible for initialization and running the game loop
- **Ball**: Represents the balls that bounce around the screen
- **Block**: Represents breakable and boundary blocks
- **Paddle**: The player-controlled element
- **ScoreIndicator**: Displays the current score
