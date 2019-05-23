package Pieces;
import Game.*;

public class Rook extends Piece {

    public Rook(Player p, int xPos, int yPos) {
        super(p, "ROOK");
        x = xPos;
        y = yPos;
        setPos(xPos, yPos);
    }

    @Override
    public void move(int finalX, int finalY) {
        if (isValidMove(finalX, finalY)) {
            setPos(finalX, finalY);
        }
    }

    @Override
    public boolean isValidMove(int finalX, int finalY) {
        boolean cond1 = (finalX >= 0 && finalX < player.board.getWidth());
        boolean cond2 = (finalY >= 0 && finalY < player.board.getHeight());
        boolean cond3 = ((y == finalY) || (x == finalX));
        boolean cond4 = (squareIsEmpty(finalX, finalY));
        return cond1 && cond2 && cond3 && cond4;
    }
}
