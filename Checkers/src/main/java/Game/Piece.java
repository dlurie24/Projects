package main.java.Game;

public abstract class Piece {
    private String color;
    private String type;

    public Piece(String c, String t) {
        color = c;
        type = t;
    }

    public abstract boolean isValidMove(int currX, int currY, int finalX, int finalY);
}
