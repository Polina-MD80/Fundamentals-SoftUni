import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class DestinationMapper {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String line = scanner.nextLine ();
        List<String> destinations = new ArrayList<> ();
        int points = 0;
        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (line);
        while (matcher.find ()){
           String destination = matcher.group ("destination");
            destinations.add (destination);
            points += destination.length ();

        }
        System.out.print ("Destinations: ");
        System.out.println (String.join (", ", destinations));
        System.out.printf ("Travel Points: %d", points);
    }
}
