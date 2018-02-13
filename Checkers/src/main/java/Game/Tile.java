package main.java.Game;

public class Tile {
    private boolean isOccupied;
    private String color;
    private Piece piece;

    public Tile() {
        isOccupied = false;
        color = "";
        piece = null;
    }

    public Tile(String c) {
        isOccupied = false;
        color = c;
        piece = null;
    }

    public Tile(String c, Piece p) {
        isOccupied = true;
        color = c;
        piece = p;
    }

    public void setColor(String c) {
        color = c;
    }

    public void setPiece(Piece p) {
        piece = p;
    }
}
