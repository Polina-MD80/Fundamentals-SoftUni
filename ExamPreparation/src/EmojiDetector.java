import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class EmojiDetector {
    public static
    void main (String[] args) {
        Scanner scanner       = new Scanner (System.in);
        String  text          = scanner.nextLine ();
        String  digitRegEx    = "\\d";
        Pattern digitPattern  = Pattern.compile (digitRegEx);
        String  emojiRegEx    = "(\\*\\*|::)(?<emojiWord>[A-Z][a-z]{2,})(\\1)";
        Pattern emojiPattern  = Pattern.compile (emojiRegEx);
        long    coolThreshold = 1;

        Matcher digit = digitPattern.matcher (text);
        while (digit.find ()) {
            coolThreshold *= Integer.parseInt (digit.group ());
        }


        Matcher           emoji    = emojiPattern.matcher (text);
        int               count    = 0;
        Map<String, Long> emojiMap = new LinkedHashMap<> ();

        while (emoji.find ()) {
            count++;
            String newEmoji      = emoji.group ();
            String currant       = emoji.group ("emojiWord");
            long   emojiCoolness = 0L;
            for (int i = 0; i < currant.length (); i++) {
                emojiCoolness += currant.charAt (i);
            }
            emojiMap.putIfAbsent (newEmoji, emojiCoolness);

        }
        System.out.println ("Cool threshold: " + coolThreshold);

        System.out.println (count + " emojis found in the text. The cool ones are:");
        long finalCoolThreshold = coolThreshold;
        emojiMap.entrySet ().stream ().filter (e -> e.getValue () >= finalCoolThreshold)
                .forEach (e -> System.out.println (e.getKey ()));


    }
}
