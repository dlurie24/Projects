package Game;

public class Board {
    private int width;
    private int height;
    private GridSquare[][] grid;
    public Player white;
    public Player black;

    public static void main(String[] args) {
        Board b = new Board(8, 8);
        b.printBoard();
    }
    /**
     * Board constructor
     * @param w - Board's width
     * @param h - Board's height
     */
    public Board (int w, int h) {
        width = w;
        height = h;
        grid = new GridSquare[width][height];
        fillGrid();
        white = new Player("WHITE", this);
        black = new Player("BLACK", this);
        //addPieces();
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

    /**
     * Get a GridSquare from the (x, y) position on the board
     * @param x - desired x pos
     * @param y - desired y pos
     * @return - the GridSquare at (x, y)
     */
    public GridSquare getGridSquare(int x, int y) {
        if ((x < 0 || x >= getWidth()) || (y < 0 || y >= getHeight())) {
            return null;
        }
        return grid[x][y];
    }

    public Piece getPiece(int x, int y) {
        return grid[x][y].getPiece();
    }

    /**
     * Prints out the grid's colors per row
     */
    public void printBoard() {
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                Piece p = grid[j][i].getPiece();
                if (p != null) {
                    System.out.print(p.getType() + "." + p.getColor().substring(0, 1) + " ");
                } else {
                    System.out.print(grid[j][i].getColor() + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Fills grid with GridSquares to represent an empty chess board
     */
    private void fillGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String color;
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    color = "BLACK";
                } else {
                    color = "WHITE";
                }
                grid[i][j] = new GridSquare(i, j, color);
            }
        }
    }

    /**
     * Fills the board according to
     * the beginning of a chess match
     */
    private void addPieces() {
        for (int i = 0; i < 8; i++) {
            grid[i][1].setPiece(white.getPiece(i));
            grid[i][1].getPiece().setSquare(grid[i][1]);
        }
        for (int i = 8; i < 16; i++) {
            grid[i - 8][0].setPiece(white.getPiece(i));
            grid[i - 8][0].getPiece().setSquare(grid[i - 8][0]);
        }
        for (int i = 0; i < 8; i++) {
            grid[i][6].setPiece(black.getPiece(i));
            grid[i][6].getPiece().setSquare(grid[i][6]);
        }
        for (int i = 8; i < 16; i++) {
            grid[i - 8][7].setPiece(black.getPiece(i));
            grid[i - 8][7].getPiece().setSquare(grid[i - 8][7]);
        }
    }
}
