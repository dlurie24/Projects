package main.java.Game;

public abstract class Piece {
    private String color;
    private String type;

    public Piece(String c, String t) {
        color = c;
        type = t;
    }

    public abstract boolean isValidMove(int currR, int currC, int finalR, int finalC);

    @Override
    public String toString() {
        return "[" + type + " " + color + "]";
    }
}
