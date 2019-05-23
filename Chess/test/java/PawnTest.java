import Game.Board;
import Game.Player;
import Pieces.Pawn;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test the Pawn class
 */
public class PawnTest {

    @Test
    public void testConstructor() {
        Board board = new Board(8, 8);
        Player p = board.white;
        Pawn pawn = new Pawn(p, 0, 0);

        assertEquals("PAWN", pawn.getType());
        assertEquals(0, pawn.getX());
        assertEquals(0, pawn.getY());
    }

    @Test
    public void testIsValidMove() {
        Player p = new Player("WHITE", new Board(8, 8));
        Pawn pawn = (Pawn) p.board.getPiece(0, 1);

        assertTrue(pawn.isValidMove(0, 2));
        assertTrue(pawn.isValidMove(0, 3));

        assertFalse(pawn.isValidMove(0, 1));
        assertFalse(pawn.isValidMove(1, 0));
        assertFalse(pawn.isValidMove(-1, 0));
        assertFalse(pawn.isValidMove(0, -1));
        assertFalse(pawn.isValidMove(10, 0));
        assertFalse(pawn.isValidMove(0, 10));
    }

    @Test
    public void testMove() {
        Board board = new Board(8, 8);
        Player white = board.white;
        Player black = board.black;
        board.printBoard();
        white.getPiece(0, 1).move(0, 3);
        System.out.println();
        board.printBoard();
        black.getPiece(0, 6).move(0, 4);
        System.out.println();
        board.printBoard();
        white.getPiece(0, 0).move(0, 2);
        System.out.println();
        board.printBoard();
        black.getPiece(2, 6).move(2, 4);
        System.out.println();
        board.printBoard();
        white.getPiece(0, 2).move(2, 2);
        System.out.println();
        board.printBoard();
    }
}
