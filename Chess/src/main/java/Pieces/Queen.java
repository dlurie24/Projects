package Pieces;
import Game.Board;
import Game.Piece;
import Game.Player;

public class Queen extends Piece {

    public Queen(Player p, int xPos, int yPos) {
        super(p, "QUEEN");
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {

    }
}
