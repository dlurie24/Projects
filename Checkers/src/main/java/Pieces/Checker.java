package main.java.Pieces;
import main.java.Game.Piece;

public class Checker extends Piece {
    public Checker(String c) {
        super(c, "CHECKER");
    }

    @Override
    public boolean isValidMove(int currR, int currC, int finalR, int finalC) {
        int colDiff = Math.abs(finalC - currC);
        int rowDiff = finalR - currR;
        return colDiff == 1 && rowDiff == 1;
    }
}
