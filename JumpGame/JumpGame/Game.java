import edu.princeton.cs.introcs.StdDraw;
import java.util.Random;

public class Game {
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;
    public static final double G = -11.8;
    public static final double DT = 0.07;
    private Renderer ren;
    private Ball ball;
    private Obstacle obstacle;

    public void start() {
        ren = new Renderer();
        ren.initialize(WIDTH, HEIGHT);
        ren.mainMenu();
        ren.getInitialInput();
        playGame();
    }

    private void playGame() {
        boolean playAgain = true;
        while (playAgain) {
            ball = new Ball(Game.WIDTH / 2, Ball.RADIUS);
            ren.ball = ball;
            ball.ren = ren;
            double angle = 360;
            ren.preGame();
            boolean gameOver = false;
            boolean jumping = false;
            char nextChar;
            obstacle = new Obstacle();
            obstacle.xPos = Game.WIDTH + obstacle.width;
            double time = 0;
            int points = 0;
            boolean pointsCounted = false;
            while (!gameOver) {
                StdDraw.pause(1);
                if (StdDraw.hasNextKeyTyped()) {
                    nextChar = StdDraw.nextKeyTyped();
                    if (nextChar == 'J' || nextChar == 'j') {
                        jumping = true;
                        time = 0;
                    }
                }

                ren.renderFrame(obstacle, jumping, points, angle);

                time += DT;
                angle -= 0.05;
                if (angle <= 0) {
                    angle = 360;
                }

                if (ball.yPos <= Ball.RADIUS + 5) {
                    jumping = false;
                    ball.yPos = Ball.RADIUS;
                    ball.vel = Ball.JUMP_VEL;
                }

                if (detectCollision()) {
                    gameOver = true;
                }

                obstacle.xPos -= 6;
                if (obstacle.xPos <= -obstacle.width) {
                    obstacle.width = new Random().nextInt(Obstacle.MAX_WIDTH - 10) + 10;
                    obstacle.height = new Random().nextInt(Obstacle.MAX_HEIGHT - 40) + 40;
                    if (obstacle.width >= Obstacle.MAX_WIDTH) {
                        obstacle.width = Obstacle.MAX_WIDTH;
                    }
                    obstacle.xPos = Game.WIDTH + obstacle.width;
                }

                if (obstacle.xPos - obstacle.width / 2 > ball.xPos - Ball.RADIUS) {
                    pointsCounted = false;
                }
                if (obstacle.xPos + obstacle.width / 2 < ball.xPos - Ball.RADIUS
                        && !pointsCounted) {
                    points += 1;
                    pointsCounted = true;
                }
            }
            playAgain = ren.playAgain(points);
        }
        System.exit(0);
    }

    private boolean detectCollision() {
        double collisionLength = ball.right() - obstacle.left();
        if (collisionLength < 0 || obstacle.right() < ball.left()) {
            return false;
        }
        return ball.bottom() <= obstacle.top();
    }
}
