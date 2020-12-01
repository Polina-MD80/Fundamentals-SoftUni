import java.util.*;

public
class Ranking {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String              firstInputs = scanner.nextLine ();
        Map<String, String> contestPass = new HashMap<> ();
        while (!"end of contests".equals (firstInputs)) {
            String[] contests = firstInputs.split (":");
            contestPass.put (contests[0], contests[1]);
            firstInputs = scanner.nextLine ();
        }
        String                            secondInput = scanner.nextLine ();
        String                            bestStudent = "";
        int                               bestScore   = 0;
        Map<String, Map<String, Integer>> student     = new TreeMap<> ();

        while (!"end of submissions".equals (secondInput)) {
            String[] submission = secondInput.split ("=>");
            String   contest    = submission[0];
            String   password   = submission[1];
            if (!contestPass.containsKey (contest)) {
                secondInput = scanner.nextLine ();
                continue;
            }
            if (!contestPass.get (contest).equals (password)) {
                secondInput = scanner.nextLine ();
                continue;
            }

            String name  = submission[2];
            int    score = Integer.parseInt (submission[3]);

            student.putIfAbsent (name, new HashMap<String, Integer> ());
            student.get (name).putIfAbsent (contest, 0);
            if (student.get (name).get (contest) < score) {
                student.get (name).put (contest, score);
            }

            secondInput = scanner.nextLine ();
        }

        for (Map.Entry<String, Map<String, Integer>> stringMapEntry : student.entrySet ()) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry : stringMapEntry.getValue ().entrySet ()) {
                sum += entry.getValue ();
            }
            if (sum > bestScore) {
                bestScore = sum;
                bestStudent = stringMapEntry.getKey ();
            }

        }
        System.out.printf ("Best candidate is %s with total %d points.%n",bestStudent,bestScore);
        System.out.println ("Ranking: ");
        student.entrySet ()
                .stream ()
                .forEach (entry->{
                    System.out.println (entry.getKey ());
                    entry.getValue ().entrySet ().stream ().sorted ((f,s)->Integer.compare (s.getValue (),f.getValue ()))
                            .forEach (e-> System.out.printf ("#  %s -> %d%n",e.getKey (),e.getValue ()));
                });

        }


    }

