import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Renderer {
    public Ball ball;

    public void initialize(int w, int h) {
        StdDraw.setCanvasSize(w, h);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        StdDraw.clear(Color.WHITE);

        StdDraw.enableDoubleBuffering();
    }

    public void mainMenu() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(Game.WIDTH / 2, Game.HEIGHT / 2 + Game.HEIGHT / 10, "Welcome To The Game");
        unpressedButton(Game.WIDTH / 2, Game.HEIGHT / 2 - Game.HEIGHT / 10, "New Game (N)");
        unpressedButton(Game.WIDTH / 2, Game.HEIGHT / 2 - Game.HEIGHT / 10 - 50, "Click me!");
        //drawRainbowAroundWelcome();
        //StdDraw.text(Game.WIDTH / 2, Game.HEIGHT - 33, "Load Game (L)");
        //StdDraw.text(Game.WIDTH / 2, Game.HEIGHT - 36, "Quit (Q)");
        StdDraw.show();
    }

    public void getInitialInput() {
        String retString;
        boolean validInput = false;
        while (!validInput) {
            StdDraw.pause(10);
            if (StdDraw.hasNextKeyTyped()) {
                retString = Character.toString(StdDraw.nextKeyTyped()).toUpperCase();
                if (retString.equals("N")) {
                    validInput = true;
                }
            }
        }
        pressedButton(Game.WIDTH / 2, Game.HEIGHT / 2 - Game.HEIGHT / 10, "New Game (N)");
        StdDraw.show();
        StdDraw.pause(500);
    }

    public void preGame() {
        StdDraw.clear(Color.WHITE);
        StdDraw.setPenColor(Ball.COLOR);
        drawBall(0);
        StdDraw.show();
    }

    public boolean playAgain(int points) {
        //drawSadBall();
        StdDraw.show();
        StdDraw.pause(1000);
        StdDraw.clear(Color.WHITE);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(Game.WIDTH / 2, Game.HEIGHT / 2, "You hit an obstacle.");
        StdDraw.show();
        StdDraw.pause(1000);
        StdDraw.clear(Color.WHITE);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(Game.WIDTH / 2, Game.HEIGHT / 2, "Your score: " + points);
        StdDraw.show();
        StdDraw.pause(1000);
        StdDraw.clear(Color.WHITE);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(Game.WIDTH / 2, Game.HEIGHT / 2, "Play again? (Y/N)");
        StdDraw.show();

        String retString = "";
        boolean validInput = false;
        while (!validInput) {
            StdDraw.pause(10);
            if (StdDraw.hasNextKeyTyped()) {
                retString = Character.toString(StdDraw.nextKeyTyped()).toUpperCase();
                if (retString.equals("Y") || retString.equals("N")) {
                    validInput = true;
                }
            }
        }
        return retString.equals("Y");
    }

    private void unpressedButton(int x, int y, String text) {
        StdDraw.rectangle(x, y + 2, text.length() * 10, StdDraw.getFont().getSize() * 2 / 3);
        StdDraw.text(x, y, text);
    }

    private void pressedButton(int x, int y, String text) {
        StdDraw.setPenColor(new Color(230, 230, 230));
        StdDraw.filledRectangle(x, y + 2, text.length() * 10, StdDraw.getFont().getSize() * 2 / 3);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(x, y, text);
    }

    public void renderFrame(Obstacle obstacle, boolean jumping, int p, double angle) {
        StdDraw.clear(Color.WHITE);
        if (jumping) {
            ball.updateYPos();
        }
        String points = "POINTS: " + p;
        unpressedButton(Game.WIDTH / 2, Game.HEIGHT - StdDraw.getFont().getSize(), points);
        drawBall(angle);
        drawObstacle(obstacle);

        StdDraw.show();
    }

    private void drawBall(double angle) {
        StdDraw.setPenColor(Ball.COLOR);
        StdDraw.filledCircle(ball.xPos, ball.yPos, Ball.RADIUS);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(ball.xPos + (20 * Math.cos(angle)), ball.yPos + (20 * Math.sin(angle)), Ball.RADIUS / 8);
        StdDraw.filledCircle(ball.xPos - (20 * Math.cos(angle)), ball.yPos - (20 * Math.sin(angle)), Ball.RADIUS / 8);


        /*
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(ball.xPos - (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 7);
        StdDraw.filledCircle(ball.xPos + (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 7);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(ball.xPos - (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 3);
        StdDraw.filledCircle(ball.xPos + (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 3);
        StdDraw.arc(ball.xPos, ball.yPos - (Ball.RADIUS / 3), 12, 180, 0);
        */
    }

    private void drawSadBall() {
        StdDraw.setPenColor(Ball.COLOR);
        StdDraw.filledCircle(ball.xPos, ball.yPos, Ball.RADIUS);

        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledCircle(ball.xPos - (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 7);
        StdDraw.filledCircle(ball.xPos + (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3), 7);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(ball.xPos - (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3) - 2, 3);
        StdDraw.filledCircle(ball.xPos + (Ball.RADIUS / 3), ball.yPos + (Ball.RADIUS / 3) - 2, 3);
        StdDraw.arc(ball.xPos, ball.yPos - (Ball.RADIUS / 3) - 12, 12, 0, 180);
    }

    private void drawObstacle(Obstacle obstacle) {
        StdDraw.setPenColor(Obstacle.COLOR);
        StdDraw.filledRectangle(obstacle.xPos, obstacle.height / 2, obstacle.width, obstacle.height);
    }

    private void drawLazerBeam(double x0, double y0, double x1, double y1, Color color) {
        int length = 5;
        double a = x1 - x0;
        double b = y1 - y0;
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double xMod = a / a;
        double yMod = b / b;
        if (x1 == x0) {
            xMod = 0;
        }
        if (y1 == y0) {
            yMod = 0;
        }
        double dx = xMod * a / (c / length);
        double dy = yMod * b / (c / length) ;
        double x2 = x0 + (xMod * dx);
        double y2 = y0 + (yMod * dy);
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(StdDraw.getPenRadius() + 0.02);
        while (x2 != x1 || y2 != y1) {
            StdDraw.pause(10);
            StdDraw.line(x0, y0, x2, y2);
            x2 += (xMod * dx);
            y2 += (yMod * dy);
            StdDraw.show();
        }
        StdDraw.setPenRadius(StdDraw.getPenRadius() - 0.02);
    }

    private void drawRainbowAroundWelcome() {
        int centerX = Game.WIDTH / 2;
        int centerY = Game.HEIGHT / 2 + Game.HEIGHT / 10;
        int halfWidth = "Welcome to the game".length() * 10;
        int halfHeight = StdDraw.getFont().getSize() * 2 / 3;
        int x0 = centerX + halfWidth - 30;
        int y0 = centerY - halfHeight;
        int x1 = x0;
        int y1 = 0;
        drawLazerBeam(x0, y0, x1, y1, Color.RED);
        drawLazerBeam(x0, centerY+halfHeight, x0, Game.HEIGHT, Color.BLUE);
        drawLazerBeam(centerX - halfWidth + 30, y0, centerX - halfWidth + 30, y1, Color.BLUE);
        drawLazerBeam(centerX - halfWidth + 30, centerY+halfHeight, centerX - halfWidth + 30, Game.HEIGHT, Color.RED);

    }

}
