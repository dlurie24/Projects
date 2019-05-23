package Game;

/**
 * Abstract implementation of a game piece
 */
public abstract class Piece {
    protected int x;
    protected int y;
    protected Player player;
    protected String type;
    protected GridSquare square;

    public Piece(Player p, String t) {
        player = p;
        type = t;
        square = new GridSquare(-1, -1, "WHITE");
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
     * @return Piece's type
     */
    public String getType() {
        return type;
    }

    public GridSquare getSquare() {
        return square;
    }

    public void setSquare(GridSquare sq) {
        square = sq;
        setPos(sq.getX(), sq.getY());
    }

    /**
     * Moves the Piece to (finalX, finalY) on the board
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     */
    public abstract void move(int finalX, int finalY);

    /**
     * Checks if a move is valid
     * Order of checking:
     * 1. finalX within bounds of board
     * 2. finalY within bounds of board
     * 3. special piece conditions
     * 4. desired GridSquare is empty or has enemy piece
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     * @return if the move is valid or not
     */
    public abstract boolean isValidMove(int finalX, int finalY);

    /**
     * Sets the Piece's position to (finalX, finalY)
     * regardless of movement rules
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     */
    public void setPos(int finalX, int finalY) {
        if (!(finalX >= 0 && finalX < player.board.getWidth())){
            throw new IllegalArgumentException("finalX must be within bounds of board");
        }
        if (!(finalY >= 0 || finalY < player.board.getHeight())) {
            throw new IllegalArgumentException("finalY must be within bounds of board");
        }

        player.board.getGridSquare(finalX, finalY).setPiece(this);
        if (x != finalX || y != finalY) {
            player.board.getGridSquare(x, y).setPiece(null);
        }
        x = finalX;
        y = finalY;
    }

    public boolean squareIsEmpty(int finalX, int finalY) {
        return player.board.getGridSquare(finalX, finalY).isEmpty();
    }
}
