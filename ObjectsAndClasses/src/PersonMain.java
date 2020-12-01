import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public
class PersonMain {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        int          n       = Integer.parseInt (scanner.nextLine ());
        List<Person> people  = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] personInput = scanner.nextLine ().split (" ");

            String name = personInput[0];
            int    age  = Integer.parseInt (personInput[1]);
            if (age <= 30) {
                continue;
            }

            Person person = new Person (name, age);
            people.add (person);

        }//подреждаме по каквото си искаме//
        people.sort (Comparator.comparing (Person::getName));
        for (Person person : people) {
            System.out.printf ("%s - %d%n", person.getName (), person.getAge ());
        }
    }
}
