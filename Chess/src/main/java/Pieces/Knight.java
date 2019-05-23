package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class Knight extends Piece {

    public Knight(Player p, int xPos, int yPos) {
        super(p, "KNIGHT");
        x = xPos;
        y = yPos;
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {

    }

    @Override
    public boolean isValidMove(int finalX, int finalY) {
        return false;
    }
}
