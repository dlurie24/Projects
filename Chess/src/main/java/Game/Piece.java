package Game;

public abstract class Piece {
    protected int x;
    protected int y;
    protected Player player;

    public Piece(Player p) {
        player = p;
    }

    /**
     * @return Piece's x value
     */
    public int getX() {
        return x;
    }

    /**
     * @return Piece's y value
     */
    public int getY() {
        return y;
    }

    /**
     * @return Piece's color
     */
    public String getColor() {
        return player.getColor();
    }

    /**
     * Moves the Piece to (finalX, finalY) on the board
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     */
    public abstract void move(int finalX, int finalY);

    /**
     * Sets the Piece's position to (finalX, finalY)
     * regardless of movement rules
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     */
    public void setPos(int finalX, int finalY) {
        x = finalX;
        y = finalY;
    }
}
