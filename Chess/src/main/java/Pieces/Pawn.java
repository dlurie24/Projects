package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class Pawn extends Piece {

    public Pawn(Player p, int xPos, int yPos) {
        super(p);
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {

    }
}
