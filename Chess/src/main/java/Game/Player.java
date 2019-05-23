package Game;
import Pieces.Pawn;
import Pieces.Rook;
import Pieces.Knight;
import Pieces.Bishop;
import Pieces.Queen;
import Pieces.King;

/**
 * A game player
 */
public class Player {
    private String color;
    private int numMoves;
    public Piece[] pieces;
    public Board board;

    private final int PAWN_START_ROW;

    /**
     * Player constructor
     * @param c - must be "WHITE" or "BLACK"
     * @param b - the Board on which the game will be played
     */
    public Player(String c, Board b) {
        if (!(c.equals("WHITE") || c.equals("BLACK"))) {
            throw new IllegalArgumentException("Color must be WHITE or BLACK");
        }
        color = c;
        board = b;
        numMoves = 0;

        if (color.equals("WHITE")) {
            PAWN_START_ROW = 1;
        } else {
            PAWN_START_ROW = board.getHeight() - 2;
        }

        addChessPieces();
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
     * Get's a piece from the pieces array at index
     * @param index - index from which to get piece
     * @return - Piece at pieces[index]
     */
    public Piece getPiece(int index) {
        if (index < 0 || index >= pieces.length) {
            throw new IllegalArgumentException("Index must be between 0 and " + (pieces.length - 1) + " inclusive");
        }
        return pieces[index];
    }

    /**
     * Gets a piece from a position on the board
     * @param x - x position on board
     * @param y - y position on board
     * @return a piece belonging to player at (x, y)
     */
    public Piece getPiece(int x, int y) {
        if ((x < 0 || x >= board.getWidth()) || (y < 0 || y >= board.getHeight())) {
            throw new IllegalArgumentException("X or Y must be in bounds of the board");
        }
        Piece p = board.getPiece(x, y);
        if (p.getColor().equals(getColor())) {
            return p;
        } else {
            return null;
        }
    }

    /**
     * Move piece to (x, y)
     * @param x - desired x location
     * @param y - desired y location
     * @param piece - desired piece to move
     */
    public void move(int x, int y, Piece piece) {
        piece.move(x, y);
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

        int startRow;
        if (getColor().equals("WHITE")) {
            startRow = PAWN_START_ROW - 1;
        } else {
            startRow = PAWN_START_ROW + 1;
        }

        pieces[8] = new Rook(this, 0, startRow);
        pieces[9] = new Knight(this, 1, startRow);
        pieces[10] = new Bishop(this, 2, startRow);
        pieces[11] = new Queen(this, 3, startRow);
        pieces[12] = new King(this, 4, startRow);
        pieces[13] = new Bishop(this, 5, startRow);
        pieces[14] = new Knight(this, 6, startRow);
        pieces[15] = new Rook(this, 7, startRow);
    }
}