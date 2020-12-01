import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public
class OrderByAgeMain {
    public static
    void main (String[] args) {
        Scanner             scanner = new Scanner (System.in);
        String              input   = scanner.nextLine ();
        List<PersonToOrder> people  = new ArrayList<> ();
        while (!"End".equals (input)) {
            String[] tokens = input.split (" ");

            String name = tokens[0];
            int    id   = Integer.parseInt (tokens[1]);
            int    age  = Integer.parseInt (tokens[2]);

            PersonToOrder person = new PersonToOrder (name, id, age);

            people.add (person);

            input = scanner.nextLine ();
        }
        people.sort (Comparator.comparingInt (PersonToOrder::getAge));
        for (PersonToOrder person : people) {
            System.out.println (person);

        }
    }
}
