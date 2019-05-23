import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        convertTo12Hour();
    }

    private static void convertTo12Hour() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a time in 24 hr format ##:## (Q to quit): ");
        String s = reader.next();
        s = s.toUpperCase();
        while (!s.equals("Q") && checkFormat(s)) {
            String out = "It's ";
            int hour = Integer.parseInt(s.substring(0, 2));
            int min = Integer.parseInt(s.substring(3, 5));
            boolean am = hour < 12;
            out = out + hourToText(hour) + " " + minToText(min);
            if (am) {
                out = out + " " + "am";
            } else {
                out = out + " " + "pm";
            }

            System.out.println(out);

            System.out.println();
            System.out.println("Enter a time in 24 hr format ##:## (Q to quit): ");
            s = reader.next();
            s = s.toUpperCase();
        }

        //once finished
        reader.close();
    }

    private static String minToText(int n) {
        String ret = "";
        if (n > 0 && n < 10) {
            ret = "oh ";
            switch (n) {
                case 1:
                    ret += "one";
                    break;
                case 2:
                    ret += "two";
                    break;
                case 3:
                    ret += "three";
                    break;
                case 4:
                    ret += "four";
                    break;
                case 5:
                    ret += "five";
                    break;
                case 6:
                    ret += "six";
                    break;
                case 7:
                    ret += "seven";
                    break;
                case 8:
                    ret += "eight";
                    break;
                case 9:
                    ret += "nine";
                    break;
            }
        } else if (n < 13) {
            switch (n) {
                case 10:
                    ret = "ten";
                    break;
                case 11:
                    ret = "eleven";
                    break;
                case 12:
                    ret = "twelve";
                    break;
            }
        } else if (n < 20) {
            switch (n % 10) {
                case 3:
                    ret = "thir";
                    break;
                case 4:
                    ret = "four";
                    break;
                case 5:
                    ret = "fif";
                    break;
                case 6:
                    ret = "six";
                    break;
                case 7:
                    ret = "seven";
                    break;
                case 8:
                    ret = "eigh";
                    break;
                case 9:
                    ret = "nine";
                    break;
            }
            ret += "teen";
        } else {
            switch (n / 10) {
                case 2:
                    ret = "twenty";
                    break;
                case 3:
                    ret = "thirty";
                    break;
                case 4:
                    ret = "fourty";
                    break;
                case 5:
                    ret = "fifty";
                    break;
            }
            ret += (" " + hourList(n % 10));
        }

        return ret;
    }

    private static String hourToText(int n) {
        if (n < 12) {
            return hourList(n);
        } else {
            return hourList(n - 12);
        }
    }

    private static String hourList(int n) {
        String ret = "";
        switch (n) {
            case 0:
                ret = "twelve";
                break;
            case 1:
                ret = "one";
                break;
            case 2:
                ret = "two";
                break;
            case 3:
                ret = "three";
                break;
            case 4:
                ret = "four";
                break;
            case 5:
                ret = "five";
                break;
            case 6:
                ret = "six";
                break;
            case 7:
                ret = "seven";
                break;
            case 8:
                ret = "eight";
                break;
            case 9:
                ret = "nine";
                break;
            case 10:
                ret = "ten";
                break;
            case 11:
                ret = "eleven";
                break;
        }
        return ret;
    }

    private static boolean checkFormat(String n) {
        int hour = Integer.parseInt(n.substring(0, 2));
        int min = Integer.parseInt(n.substring(3, 5));
        return n.length() == 5 &&
                hour >= 0 && hour < 24 && min >= 0 && min < 60;
    }
}
