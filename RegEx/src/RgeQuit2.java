import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class RgeQuit2 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ();
        String  regex   = "([^\\d]+)(\\d+)";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (input);
        StringBuilder result = new StringBuilder ();
        while (matcher.find ()) {

            String message = matcher.group (1).toUpperCase ();
            int    n       = Integer.parseInt (matcher.group (2));
            for (int i = 0; i < n; i++) {
                result.append (message);
            }

        }
        System.out.printf ("Unique symbols used: %d%n", result.chars ().distinct ().count ());
        System.out.println (result);
    }
}