import java.util.*;

public
class WordSynonyms {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        Map<String, List<String>> words = new LinkedHashMap<> ();

        for (int i = 0; i < n; i++) {
            String       keyWord  = scanner.nextLine ();
            String       synonym  = scanner.nextLine ();
            List<String> synonyms = new ArrayList<> ();

            words.putIfAbsent (keyWord, synonyms);
            words.get (keyWord).add (synonym);
           // words.put(keyWord, !words.containsKey(keyWord).new ArrayList<>().add(synonym) : Collections.add(synonym));

        }
        for (Map.Entry<String, List<String>> entry : words.entrySet ()) {
            System.out.printf ("%s - %s%n", entry.getKey (), entry.getValue ()
                    .toString ()
                    .replaceAll ("[\\[\\]]", ""));
        }
    }
}
