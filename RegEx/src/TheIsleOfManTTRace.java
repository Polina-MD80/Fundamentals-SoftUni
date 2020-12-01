import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class TheIsleOfManTTRace {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        String regex = "";

        Pattern patter = Pattern.compile (regex);

        String input = scanner.nextLine ();

        Matcher competitor = patter.matcher (input);


        System.out.printf ("Coordinates found! %s -> %s",
                competitor.group ("name"), competitor.group("coordinates"));



    }
}
