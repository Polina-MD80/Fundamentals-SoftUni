import java.util.*;

public
class StudentAcademy {
    public static
    void main (String[] args) {
        Scanner                   scanner  = new Scanner (System.in);
        int                       n        = Integer.parseInt (scanner.nextLine ());
        Map<String, List<Double>> students = new LinkedHashMap<> ();
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine ();
            double grade       = Double.parseDouble (scanner.nextLine ());

            students.putIfAbsent (studentName, new ArrayList<> ());
            students.get (studentName).add (grade);
        }
        students
                .entrySet ()
                .stream ()
                .filter (s -> s.getValue ().stream ().mapToDouble (Double::doubleValue).average ().getAsDouble () >= 4.50)
                .sorted ((s1, s2) -> {
                    double first  = s1.getValue ().stream ().mapToDouble (Double::doubleValue).average ().getAsDouble ();
                    double second = s2.getValue ().stream ().mapToDouble (Double::doubleValue).average ().getAsDouble ();
                    return Double.compare (second, first);
                })
                .forEach (s -> System.out.printf ("%s -> %.2f%n", s.getKey (), getAverage (s.getValue ())));

        //.forEach (entry-> {
        //System.out.printf ("%s -> %.2f%n", entry.getKey (),getAverage(entry.getValue ()));
        //});

    }

    private static
    double getAverage (List<Double> grades) {
        return grades.stream ().mapToDouble (a -> a).average ().getAsDouble ();
    }
}
