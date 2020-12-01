import java.util.Scanner;

public
class RepeatString {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        int repeats = Integer.parseInt (scanner.nextLine ());
        String output = repeatString(input,repeats);
        System.out.println (output);
    }

    private static
    String repeatString (String input, int repeats) {
        String result = "";
        for (int i = 1; i <=repeats ; i++) {
            result = result+ input;

        }return result;
    }
}
