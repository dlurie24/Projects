import Game.*;
import Pieces.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test the Player class
 */
public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsIllegalArgumentException() {
        Player p = new Player("red", new Board(8, 8));
    }

    @Test
    public void testConstructor() {
        Player p = new Player("WHITE", new Board(8, 8));
        assertTrue(p.getNumMoves() == 0);
        assertTrue(p.getColor().equals("WHITE"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPieceThrowsIllegalArgumentExceptionNegativeIndex() {
        Player p = new Player("WHITE", new Board(8, 8));
        p.getPiece(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPieceThrowsIllegalArgumentExceptionLargeIndex() {
        Player p = new Player("WHITE", new Board(8, 8));
        p.getPiece(20);
    }

    @Test
    public void testAddChessPieces() {
        Player p = new Player("WHITE", new Board(8, 8));
        Pawn pawn = new Pawn(p, 0, 0);
        Rook rook = new Rook(p, 0, 0);
        Knight knight = new Knight(p, 0, 0);
        Bishop bishop = new Bishop(p, 0, 0);
        Queen queen = new Queen(p, 0, 0);
        King king = new King(p, 0, 0);

        assertEquals(p.getPiece(0).getType(), pawn.getType());
        assertEquals(p.getPiece(7).getType(), pawn.getType());
        assertEquals(p.getPiece(8).getType(), rook.getType());
        assertEquals(p.getPiece(9).getType(), knight.getType());
        assertEquals(p.getPiece(10).getType(), bishop.getType());
        assertEquals(p.getPiece(11).getType(), queen.getType());
        assertEquals(p.getPiece(12).getType(), king.getType());
    }
}
