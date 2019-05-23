package test.java;
import main.java.Game.*;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Tester class for Board
 */
public class BoardTest {

    @Test
    public void testConstructor() {
        Board b = new Board(8, 8);
        System.out.println(b);
        b.printBoard();
    }
}
