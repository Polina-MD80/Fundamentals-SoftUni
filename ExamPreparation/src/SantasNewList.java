import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class SantasNewList {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine ();

        Map<String, Integer> kids     = new TreeMap<> ();
        Map<String, Integer> presents = new LinkedHashMap<> ();

        while (!"END".equals (input)) {
            String[] parts = input.split ("->");
            switch (parts[0]) {
                case "Remove":
                    String nameToRemove = parts[1];
                    kids.remove (nameToRemove);
                    break;
                default:
                    String name = parts[0];
                    String present = parts[1];
                    int amount = Integer.parseInt (parts[2].trim ());

                    kids.putIfAbsent (name, 0);
                    int newAmount = kids.get (name) + amount;
                    kids.put (name, newAmount);

                    presents.putIfAbsent (present, 0);
                    presents.put (present, presents.get (present) + amount);
                    break;

            }
            input = scanner.nextLine ();
        }
        System.out.println ("Children:");
        kids.entrySet ().stream ().sorted ((f, s) -> s.getValue ().compareTo (f.getValue ()))
                .forEach (e -> System.out.println (e.getKey () + " -> " + e.getValue ()));
        System.out.println ("Presents:");
        presents.forEach ((key, value) -> System.out.println (key + " -> " + value));
    }
}
