package Game;

/**
 * Represents the grid of the board which can hold a piece
 */
public class GridSquare {
    private Piece piece;
    private int x;
    private int y;
    private String color;

    public GridSquare(int xPos, int yPos, String c) {
        x = xPos;
        y = yPos;
        color = c;
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void setPos(int finalX, int finalY) {
        x = finalX;
        y = finalY;
    }

    public void setPiece(Piece p) {
        piece = p;
    }

    public boolean isEmpty() {
        return piece == null;
    }
}
