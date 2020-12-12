import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class Hideout {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  line    = scanner.nextLine ();


        while (true) {
            String        input             = scanner.nextLine ();
            String[]      command           = input.split (" ");
            char          searchedCharacter = command[0].charAt (0);
            int           minCount          = Integer.parseInt (command[1]);
            String        found             = "";
            StringBuilder sb                = new StringBuilder ();
            for (int i = 0; i < minCount; i++) {
                sb.append (searchedCharacter);
            }
            if (line.contains (sb)) {
                int index = line.indexOf (sb.toString ());
                for (int i = index+minCount; i < line.length (); i++) {
                    if (line.charAt (i)!=searchedCharacter){
                        break;
                    }else sb.append (searchedCharacter);
                }
                found = sb.toString ();
                System.out.printf ("Hideout found at index %d and it is with size %d!",index, found.length ());
                return;
            }

        }
    }
}
