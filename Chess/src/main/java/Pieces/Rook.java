package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class Rook extends Piece {

    public Rook(Player p, int xPos, int yPos) {
        super(p, "ROOK");
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {

    }
}
