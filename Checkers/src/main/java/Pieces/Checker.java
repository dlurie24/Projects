package main.java.Pieces;
import main.java.Game.Piece;

public class Checker extends Piece {
    public Checker(String c, String t) {
        super(c, t);
    }

    @Override
    public boolean isValidMove(int currX, int currY, int finalX, int finalY) {
        int xDiff = Math.abs(finalX - currX);
        int yDiff = finalY - currY;
        return xDiff == 1 && yDiff == 1;
    }
}
