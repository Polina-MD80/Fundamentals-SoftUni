import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class EmailStatistics {
    public static
    void main (String[] args) {
        Scanner                   scanner = new Scanner (System.in);
        int                       n       = Integer.parseInt (scanner.nextLine ());
        Map<String, List<String>> emails  = new LinkedHashMap<> ();
        Pattern                   pattern = Pattern.compile ("^(?<username>[A-Za-z]{5,})@(?<domain>[a-z]{3,}.(bg|com|org))$");
        for (int i = 0; i < n; i++) {
            String  email   = scanner.nextLine ();
            Matcher matcher = pattern.matcher (email);
            if (matcher.find ()) {
                String username = matcher.group ("username");
                String domain   = matcher.group ("domain");
                emails.putIfAbsent (domain, new ArrayList<> ());
                if (!emails.get (domain).contains (username)) {
                    emails.get (domain).add (username);
                }
            }
        }
        emails.entrySet ().stream ()
                .sorted ((f, s) -> Integer.compare (s.getValue ().size (), f.getValue ().size ()))
                .forEach (e -> {
                    System.out.println (e.getKey () + ":");
                    e.getValue ().forEach (v -> System.out.println ("### " + v));
                });
    }
}
