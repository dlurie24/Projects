import Game.*;
import Pieces.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testConstructor() {
        Board board = new Board(8, 8);
        Player white = board.white;
        Player black = board.black;
        board.printBoard();
        assertEquals(8, board.getWidth());
        assertEquals(8, board.getHeight());
        assertEquals(white.getColor(), board.white.getColor());
        assertEquals(black.getColor(), board.black.getColor());
        assertEquals("WHITE", board.white.getColor());
        assertEquals("BLACK", board.black.getColor());
    }

    @Test
    public void testConstructorCreatesChessboard() {
        Board board = new Board(8, 8);
        assertEquals("ROOK", board.getPiece(0, 0).getType());
        assertEquals("ROOK", board.getPiece(7, 0).getType());
        assertEquals("ROOK", board.getPiece(0, 7).getType());
        assertEquals("ROOK", board.getPiece(7, 7).getType());
        assertEquals("KNIGHT", board.getPiece(1, 0).getType());
        assertEquals("KNIGHT", board.getPiece(6, 0).getType());
        assertEquals("KNIGHT", board.getPiece(1, 7).getType());
        assertEquals("KNIGHT", board.getPiece(6, 7).getType());
        assertEquals("BISHOP", board.getPiece(2, 0).getType());
        assertEquals("BISHOP", board.getPiece(5, 0).getType());
        assertEquals("BISHOP", board.getPiece(2, 7).getType());
        assertEquals("BISHOP", board.getPiece(5, 7).getType());
        assertEquals("QUEEN", board.getPiece(3, 0).getType());
        assertEquals("QUEEN", board.getPiece(3, 7).getType());
        assertEquals("KING", board.getPiece(4, 0).getType());
        assertEquals("KING", board.getPiece(4, 7).getType());
        for (int i = 0; i < 8; i++) {
            assertEquals("PAWN", board.getPiece(i, 1).getType());
        }
        for (int i = 0; i < 8; i++) {
            assertEquals("PAWN", board.getPiece(i, 6).getType());
        }
    }

    @Test
    public void testGetGridSquare() {
        Board board = new Board(8, 8);
        assertEquals("BLACK", board.getGridSquare(0, 0).getColor());
        assertEquals("WHITE", board.getGridSquare(0, 7).getColor());
        assertEquals("WHITE", board.getGridSquare(7, 0).getColor());
        assertEquals("BLACK", board.getGridSquare(7, 7).getColor());
    }
}
