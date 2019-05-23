import Game.Board;
import Game.Player;
import Pieces.Rook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test the Rook
 */
public class RookTest {

    @Test
    public void testConstructor() {
        Player p = new Player("WHITE", new Board(8, 8));
        Rook rook = new Rook(p, 0, 0);

        assertEquals("ROOK", rook.getType());
        assertEquals(0, rook.getX());
        assertEquals(0, rook.getY());
    }

    @Test
    public void testIsValidMove() {
        Board board = new Board(8, 8);
        Player p = board.white;
        Rook rook = (Rook) p.board.getPiece(0, 0);
        board.getPiece(0, 1).move(0, 3);
        board.printBoard();

        assertTrue(rook.isValidMove(4, 0));
        assertTrue(rook.isValidMove(4, 7));
        assertTrue(rook.isValidMove(0, 4));
        assertTrue(rook.isValidMove(7, 4));

        assertFalse(rook.isValidMove(3, 3));
        assertFalse(rook.isValidMove(-1, 4));
        assertFalse(rook.isValidMove(4, -1));
        assertFalse(rook.isValidMove(10, 4));
        assertFalse(rook.isValidMove(4, 10));
    }
}
