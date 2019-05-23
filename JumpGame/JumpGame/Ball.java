import java.awt.*;

public class Ball {
    public static final Color COLOR = new Color(111, 222, 250);
    public static final int RADIUS = 40;
    public static final int JUMP_VEL = 80;
    public double xPos;
    public double yPos;
    public double vel;
    public Renderer ren;

    Ball(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        vel = JUMP_VEL;
    }

    public void updateYPos() {
        yPos += vel * Game.DT;
        this.vel += Game.G * Game.DT;
    }

    public double left() {
        return xPos - RADIUS;
    }

    public double right() {
        return xPos + RADIUS;
    }

    public double bottom() {
        return yPos - RADIUS;
    }
}
