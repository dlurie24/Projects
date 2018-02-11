package Game;
import Pieces.Pawn;

public class Board {
    private int width;
    private int height;

    /**
     * Board constructor
     * @param w - Board's width
     * @param h - Board's height
     */
    public Board (int w, int h) {
        width = w;
        height = h;
    }

    /**
     * @return Board's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return Board's height
     */
    public int getHeight() {
        return height;
    }
}
