import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class SantaSecretHelper {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        String  input   = scanner.nextLine ();
        while (!"end".equals (input)) {
            StringBuilder decoded = new StringBuilder ();
            for (int i = 0; i < input.length (); i++) {
                decoded.append ((char) (input.charAt (i) - n));
            }
            String  regex   = "@(?<name>[A-Za-z]+)([^@\\-!:>]+)!(?<good>[GN])!";
            Pattern pattern = Pattern.compile (regex);
            Matcher matcher = pattern.matcher (decoded);
            if (matcher.find ()) {
                String name = matcher.group ("name");
                String good = matcher.group ("good");
                if (good.equals ("G")) {
                    System.out.println (name);
                }
            }
            input = scanner.nextLine ();
        }
    }
}
