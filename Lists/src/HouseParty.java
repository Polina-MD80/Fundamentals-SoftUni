import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class HouseParty {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        int          n       = Integer.parseInt (scanner.nextLine ());
        List<String> guests  = new ArrayList<> ();
        for (int i = 1; i <= n; i++) {
            String[] goingOrNot = scanner.nextLine ().split (" ", 2);
            if (goingOrNot[1].equals ("is not going!")) {
                if (guests.isEmpty ()) {
                    System.out.printf ("%s is not in the list!%n", goingOrNot[0]);
                } else if (guests.contains (goingOrNot[0])) {
                    guests.remove (goingOrNot[0]);
                } else {
                    System.out.printf ("%s is not in the list!%n", goingOrNot[0]);
                }
            } else if (goingOrNot[1].
                    equals ("is going!")) {
                if (guests.isEmpty ()) {
                    guests.add (goingOrNot[0]);
                } else if (guests.contains (goingOrNot[0])) {
                    System.out.printf ("%s is already in the list!%n", goingOrNot[0]);
                } else {
                    guests.add (goingOrNot[0]);
                }

            }
        }

        for (
                String guest : guests) {
            System.out.println (guest);
        }
    }
}