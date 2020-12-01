import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class RageQuit {
    public static
    void main (String[] args) {
        Scanner         scanner  = new Scanner (System.in);
        String          input    = scanner.nextLine ();
        String          regex    = "([^\\d]+)(\\d+)";
        Pattern         pattern  = Pattern.compile (regex);
        Matcher         matcher  = pattern.matcher (input);
        List<Character> chars    = new ArrayList<> ();
        List<String>    messages = new ArrayList<> ();
        List<Integer>   numbers  = new ArrayList<> ();
        while (matcher.find ()) {

            String message = matcher.group (1);
            int    n       = Integer.parseInt (matcher.group (2));
            messages.add (message);
            numbers.add (n);

            if (n != 0) {
                for (int i = 0; i < message.length (); i++) {
                    char currantChar = Character.toUpperCase (message.charAt (i));
                    if (!chars.contains (currantChar)) {
                        chars.add (currantChar);
                    }
                }

            }
        }

        System.out.printf ("Unique symbols used: %d%n", chars.size ());
        for (int i = 0; i < numbers.size (); i++) {
            for (int j = 0; j < numbers.get (i); j++) {
                System.out.print (messages.get (i).toUpperCase ());
            }
        }

    }

}


