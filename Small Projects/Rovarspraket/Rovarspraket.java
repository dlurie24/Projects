import java.util.Scanner;

public class Rovarspraket {
    public static void main(String[] args) {
        System.out.println("Type something to translate to Rovarspraket:");
        Scanner reader = new Scanner(System.in);
        String in = reader.nextLine();
        String encoded = rovarspraket(in);
        String decoded = tekarpsravor(encoded);
        System.out.println(encoded);
        System.out.println(decoded);
    }

    private static String rovarspraket(String in) {
        char[] chars = in.toCharArray();
        String out = "";
        for (char c : chars) {
            if (!isVowel(c) && Character.isLetter(c)) {
                out = out + c + "o" + Character.toLowerCase(c);
            } else {
                out = out + c;
            }
        }
        return out;
    }

    private static String tekarpsravor(String in) {
        char[] chars = in.toCharArray();
        String out = "";
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!isVowel(c) && Character.isLetter(c)) {
                out += c;
                i += 2;
            } else {
                out += c;
            }
        }
        return out;
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'y';
    }
}
