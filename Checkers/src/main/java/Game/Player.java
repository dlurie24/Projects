package main.java.Game;

public class Player {
    Board board;
    Piece piece;

    public Player(Board b) {
        board = b;
        piece = null;
    }

    public void setPiece(Piece p) {
        piece = p;
    }
}
