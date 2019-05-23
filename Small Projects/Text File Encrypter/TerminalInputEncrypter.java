import java.util.Scanner;

public class TerminalInputEncrypter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter text to be encoded: ");
        String toEncode = s.nextLine();
        Huffman hm = new Huffman();
        hm.buildCode(toEncode);
        hm.printOriginal();
        hm.printEncoded();
    }
}
