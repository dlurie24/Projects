package Pieces;
import Game.*;

public class Pawn extends Piece {
    private boolean hasBeenMoved;

    public Pawn(Player p, int xPos, int yPos) {
        super(p, "PAWN");
        x = xPos;
        y = yPos;
        setPos(xPos, yPos);
        hasBeenMoved = false;
    }

    /**
     * Moves the piece to the desired location
     * if it is a valid move
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     */
    @Override
    public void move(int finalX, int finalY) {
        if (isValidMove(finalX, finalY)) {
            setPos(finalX, finalY);
            hasBeenMoved = true;
        }
    }

    /**
     * Checks if a move is valid using the pawn's rules
     * @param finalX - desired x pos
     * @param finalY - desired y pos
     * @return if the move is valid or not
     */
    @Override
    public boolean isValidMove(int finalX, int finalY) {
        int xDiff = Math.abs(finalX - x);
        int yDiff = Math.abs(finalY - y);
        return (finalX >= 0 && finalX < player.board.getWidth())
                && (finalY >= 0 && finalY < player.board.getHeight())
                && (xDiff == 0) // Does not take into account diagonal attacking yet
                && ((!hasBeenMoved && yDiff <= 2) || (hasBeenMoved && yDiff == 1))
                && (squareIsEmpty(finalX, finalY));
    }
}
