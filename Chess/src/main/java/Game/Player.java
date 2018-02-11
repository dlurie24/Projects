package Game;
import Pieces.Pawn;

public class Player {
    private String color;
    private int numMoves;
    private Piece[] pieces;
    private final int PAWN_START_ROW;
    private Board board;

    /**
     * Player constructor
     * @param c - must be "WHITE" or "BLACK"
     * @param b - the Board on which the game will be played
     */
    public Player(String c, Board b) {
        color = c;
        board = b;
        numMoves = 0;

        if (color.equals("WHITE")) {
            PAWN_START_ROW = 1;
        } else {
            PAWN_START_ROW = board.getHeight() - 2;
        }
    }

    /**
     * @return Player's color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return Player's number of moves
     */
    public int getNumMoves() {
        return numMoves;
    }

    /**
     * Move piece to (x, y)
     * @param x - desired x location
     * @param y - desired y location
     * @param piece - desired piece to move
     */
    public void move(int x, int y, Piece piece) {
        numMoves++;
    }

    /**
     * Adds all the chess pieces to the pieces array
     * Currently only makes pieces a length 16 array because haven't created Pieces
     */
    private void addChessPieces() {
        pieces = new Piece[16];
        for (int i = 0; i < pieces.length / 2; i++) {
            pieces[i] = new Pawn(this, i, PAWN_START_ROW);
        }
    }
}