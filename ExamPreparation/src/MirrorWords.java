import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class MirrorWords {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        String       line    = scanner.nextLine ();
        String       regex   = "([@#])(?<word1>[A-z]{3,})\\1\\1(?<word2>[A-z]{3,})\\1";
        Pattern      pattern = Pattern.compile (regex);
        Matcher      valid   = pattern.matcher (line);
        int          count   = 0;
        List<String> mirrors = new ArrayList<> ();
        while (valid.find ()) {
            count++;
            Boolean isMirrored = true;
            String  validText  = valid.group ();
            for (int i = 0; i < validText.length () / 2; i++) {
                if (validText.charAt (i) != validText.charAt (validText.length () - 1 - i)) {
                    isMirrored = false;
                }
            }
            if (isMirrored) {
                String word1  = valid.group ("word1");
                String word2  = valid.group ("word2");
                String couple = word1 + " <=> " + word2;
                mirrors.add (couple);
            }

        }
        if (count == 0) {
            System.out.println ("No word pairs found!");
        } else {
            System.out.println (count + " word pairs found!");
        }
        if (mirrors.size () == 0) {
            System.out.println ("No mirror words!");
        } else {
            System.out.println ("The mirror words are:");
            System.out.println (String.join (", ", mirrors));
        }
    }
}

