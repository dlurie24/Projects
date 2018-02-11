package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class King extends Piece {

    public King(Player p, int xPos, int yPos) {
        super(p, "KING");
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {

    }
}
