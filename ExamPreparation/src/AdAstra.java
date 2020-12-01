import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class AdAstra {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        String regex = "([#|])(?<name>[A-Za-z\\s]+)\\1(?<expiration>[\\d]{2}/[\\d]{2}/[\\d]{2})\\1(?<calories>[\\d]{1,5})\\1";
        Pattern pattern = Pattern.compile (regex);
        Matcher matcher = pattern.matcher (input);
        List<String> name = new ArrayList<> ();
        List<String> date = new ArrayList<> ();
        List<String> calories = new ArrayList<> ();
        while (matcher.find ()){
            name.add (matcher.group ("name"));
            date.add (matcher.group ("expiration"));
            calories.add (matcher.group ("calories"));
        }
        int days = calories.stream ().mapToInt (Integer::parseInt).sum ()/2000;
        System.out.printf ("You have food to last you for: %d days!%n",days);
        for (int i = 0; i < name.size () ; i++) {
            System.out.printf ("Item: %s, Best before: %s, Nutrition: %s%n", name.get (i),date.get (i),calories.get (i));
        }

    }
}
