import java.awt.*;

public class Obstacle {
    public double xPos;
    public double yPos;
    public int width = 20;
    public int height = 40;
    public static final Color COLOR = new Color(137, 78, 26);
    public static final int MAX_WIDTH = 60;
    public static final int MAX_HEIGHT = 120;

    public double left() {
        return xPos - width;
    }

    public double right() {
        return xPos + width;
    }

    public double top() {
        return height;
    }
}
