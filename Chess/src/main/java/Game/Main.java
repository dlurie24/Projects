package Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        Board board = new Board(8, 8);
        Player white = board.white;
        Player black = board.black;
        Scanner reader = new Scanner(System.in);
        int i = 0;
        while (true) {
            board.printBoard();
            if (i % 2 == 0) {
                System.out.print("White ");
            } else {
                System.out.print("Black ");
            }
            System.out.println("enter a move (x, y, finalX, finalY): ");
            String in = reader.nextLine();
            int x = Integer.parseInt(in.substring(0, 1));
            int y = Integer.parseInt(in.substring(3, 4));
            int finalX = Integer.parseInt(in.substring(6, 7));
            int finalY = Integer.parseInt(in.substring(9, 10));
            if (i % 2 == 0) {
                white.getPiece(x, y).move(finalX, finalY);
            } else {
                black.getPiece(x, y).move(finalX, finalY);
            }
            System.out.println();
            i++;
        }
    }
}
