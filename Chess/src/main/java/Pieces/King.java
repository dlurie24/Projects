package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class King extends Piece {

    public King(Player p, int xPos, int yPos) {
        super(p, "KING");
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
