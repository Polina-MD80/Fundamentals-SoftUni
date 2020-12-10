import java.util.*;
import java.util.stream.Collectors;

public
class SoftUniKaraoke {
    public static
    void main (String[] args) {
        Scanner                   scanner          = new Scanner (System.in);
        List<String>              participantsList = Arrays.stream (scanner.nextLine ().split (", ")).collect (Collectors.toList ());
        List<String>              songsList        = Arrays.stream (scanner.nextLine ().split (", ")).collect (Collectors.toList ());
        Map<String, List<String>> awards           = new TreeMap<> ();
        String                    input            = scanner.nextLine ();
        while (!"dawn".equals (input)) {
            //Vankata, Dragana - Kukavice, Best Srabsko
            String[] tokens = input.split (", ");
            String   name   = tokens[0];
            String   song   = tokens[1];
            String   award  = tokens[2];
            if (!participantsList.contains (name) || !songsList.contains (song)) {
                input = scanner.nextLine ();
                continue;
            }
            awards.putIfAbsent (name, new ArrayList<> ());
            if (!awards.get (name).contains (award)) {
                awards.get (name).add (award);
            }

            input = scanner.nextLine ();
        }
        if (awards.isEmpty ()) {
            System.out.println ("No awards");
        } else {
            awards.entrySet ().stream ().sorted ((f, s) -> Integer.compare (s.getValue ().size (), f.getValue ().size ()))
                    .forEach (e -> {
                        System.out.printf ("%s: %d awards%n", e.getKey (), e.getValue ().size ());
                        e.getValue ().stream ().sorted (String::compareTo)
                                .forEach (v -> System.out.printf ("--%s%n", v));
                    });

        }

    }
}
