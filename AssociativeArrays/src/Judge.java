import java.util.*;

public
class Judge {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        //{username} -> {contest} -> {points}
        //no more time
        String input = scanner.nextLine ();

        Map<String, Map<String, Integer>> contests     = new LinkedHashMap<> ();
        Map<String, Integer>              participants = new TreeMap<> ();

        while (!"no more time".equals (input)) {
            String[] tokens  = input.split (" -> ");
            String   contest = tokens[1];
            String   name    = tokens[0];
            int      points  = Integer.parseInt (tokens[2]);

            contests.putIfAbsent (contest, new TreeMap<> ());
            contests.get (contest).putIfAbsent (name, 0);
            if (points > contests.get (contest).get (name)) {
                contests.get (contest).put (name, points);
            }

            participants.putIfAbsent (name, 0);

            input = scanner.nextLine ();
        }
        contests.forEach ((key, value) -> {
            List<Integer> num = getIntegers (participants);
            System.out.printf ("%s: %d participants%n", key, value.size ());
            value.entrySet ().stream ().sorted ((f, s) -> Integer.compare (s.getValue (), f.getValue ()))
                    .forEach (name -> System.out.printf ("%d. %s <::> %d%n", num.remove (0), name.getKey (), name.getValue ()));
        });
        System.out.println ("Individual standings:");

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : contests.entrySet ()) {
            for (Map.Entry<String, Integer> entry : stringMapEntry.getValue ().entrySet ()) {
                String name  = entry.getKey ();
                int    score = participants.get (name) + entry.getValue ();
                participants.put (name, score);
            }

        }
        List<Integer> num = getIntegers (participants);
        participants.entrySet ().stream ().sorted ((f, s) -> Integer.compare (s.getValue (), f.getValue ()))
                .forEach (p -> System.out.printf ("%d. %s -> %d%n", num.remove (0), p.getKey (), p.getValue ()));

    }

    private static
    List<Integer> getIntegers (Map<String, Integer> participants) {
        List<Integer> num = new ArrayList<> ();
        for (int i = 0; i < participants.size (); i++) {
            num.add (i + 1);
        }
        return num;
    }
}
