package main.java.Game;
import main.java.Pieces.Checker;

/**
 * Represents a game board
 * Any parameters r and c mean row and column respectively
 */
public class Board {
    Tile[][] tiles;
    private int rows;
    private int cols;

    public Board(int r, int c) {
        rows = r;
        cols = c;
        tiles = new Tile[r][c];
        fillTiles();
        addCheckersPieces();
    }

    public Tile getTile(int r, int c) {
        return tiles[r][c];
    }

    @Override
    public String toString() {
        return "Board: " + rows + " x " + cols;
    }

    public void printBoard() {
        for (int r = rows - 1; r >= 0; r--) {
            for (int c = 0; c < cols; c++) {
                System.out.print(tiles[r][c]);
            }
            System.out.println();
        }
    }

    private void fillTiles() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r % 2 == 0 && c % 2 == 0) || (r % 2 == 1 && c % 2 == 1)) {
                    tiles[r][c] = new Tile("BLACK");
                } else {
                    tiles[r][c] = new Tile("WHITE");
                }
            }
        }
    }

    private void addCheckersPieces() {
        for (int c = 0; c < cols; c += 2) {
            tiles[0][c].setPiece(new Checker("RED"));
        }
        for (int c = 1; c < cols; c += 2) {
            tiles[1][c].setPiece(new Checker("RED"));
        }
        for (int c = 0; c < cols; c+= 2) {
            tiles[rows - 2][c].setPiece(new Checker("BLACK"));
        }
        for (int c = 1; c < cols; c+= 2) {
            tiles[rows - 1][c].setPiece(new Checker("BLACK"));
        }
    }
}
