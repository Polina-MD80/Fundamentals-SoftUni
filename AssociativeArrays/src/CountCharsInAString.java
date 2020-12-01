import java.util.*;
import java.util.stream.Stream;

public
class CountCharsInAString {
    public static
    void main (String[] args) {
        Scanner              scanner    = new Scanner (System.in);
        Map<String, Integer> charCounts = new LinkedHashMap<> ();
        String[] chars = Arrays.stream (scanner.nextLine ()
                .split (""))
                .filter (e -> !e.equals (" ")).toArray (String[]::new);
        for (String aChar : chars) {

            charCounts.putIfAbsent (aChar, 0);

            charCounts.put (aChar, charCounts.get (aChar) + 1);
        }
        for (Map.Entry<String, Integer> entry : charCounts.entrySet ()) {
            System.out.printf ("%s -> %d%n", entry.getKey (), entry.getValue ());


        }

    }
}

