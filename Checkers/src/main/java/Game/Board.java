package main.java.Game;

public class Board {
    Tile[][] tiles;
    private int rows;
    private int cols;

    public Board(int r, int c) {
        rows = r;
        cols = c;
        tiles = new Tile[r][c];
    }

    public void fillTiles() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r % 2 == 0 && c % 2 == 0) {
                    tiles[r][c] = new Tile("BLACK");
                } else {
                    tiles[r][c] = new Tile("WHITE");
                }
            }
        }
    }

    public void addCheckersPieces() {

    }
}
