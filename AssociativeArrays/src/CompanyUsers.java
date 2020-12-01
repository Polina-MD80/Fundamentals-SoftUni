import java.util.*;

public
class CompanyUsers {
    public static
    void main (String[] args) {
        Scanner                   scanner          = new Scanner (System.in);
        String                    input            = scanner.nextLine ();
        Map<String, List<String>> companyEmployees = new LinkedHashMap<> ();
        while (!"End".equals (input)) {
            String[] tokens   = input.split (" -> ");
            String   company  = tokens[0];
            String   employee = tokens[1];
            companyEmployees.putIfAbsent (company, new ArrayList<> ());
            if (!companyEmployees.get (company).contains (employee)) {
                companyEmployees.get (company).add (employee);
            }
            input = scanner.nextLine ();
        }
        companyEmployees
                .entrySet ()
                .stream ()
                .sorted ((e1, e2) -> e1.getKey ().compareTo (e2.getKey ()))
                .forEach (entry -> {
                    System.out.printf ("%s%n", entry.getKey ());
                    entry
                            .getValue ()
                            .forEach (e -> System.out.printf ("-- %s%n", e));
                });
    }
}

