import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class SoftUniExamResults {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> students  = new TreeMap<> ();
        Map<String, Integer> languages = new TreeMap<> ();

        String line = scanner.nextLine ();

        while (!"exam finished".equals (line)) {
            String[] tokens  = line.split ("-");
            String   student = tokens[0];
            if (tokens[1].equals ("banned")) {
                students.remove (student);
            } else {
                int points = Integer.parseInt (tokens[2]);
                students.putIfAbsent (student, 0);
                if (points > students.get (student)) {
                    students.put (student, points);
                }

                String language = tokens[1];
                languages.putIfAbsent (language, 0);
                int newCount = languages.get (language) + 1;
                languages.put (language, newCount);
            }

            line = scanner.nextLine ();
        }
        System.out.println ("Results:");
        students.entrySet ().stream ()
                .sorted ((e1,e2)-> e2.getValue ().compareTo (e1.getValue ()))
                .forEach (e-> System.out.printf ("%s | %d%n",e.getKey(),e.getValue()));
        System.out.println ("Submissions:");
        languages.entrySet ().stream ()
                .sorted ((e1,e2)-> e2.getValue ().compareTo (e1.getValue ()))
                .forEach (e-> System.out.printf ("%s - %d%n",e.getKey (),e.getValue ()));


    }
}
