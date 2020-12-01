import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class SoftUniParking {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());

        Map<String, String> users = new LinkedHashMap<> ();
        for (int i = 0; i < n; i++) {
            String[] tokens  = scanner.nextLine ().split (" ", 2);
            String   command = tokens[0];

            switch (command) {
                case "register":
                    String[] nameAndPlate = tokens[1].split (" ");
                    String name = nameAndPlate[0];
                    String plate = nameAndPlate[1];
                    if (users.containsKey (name)) {
                        System.out.printf ("ERROR: already registered with plate number %s%n", plate);
                    } else {
                        users.put (name, plate);
                        System.out.printf ("%s registered %s successfully%n", name, plate);
                    }
                    break;
                case "unregister":
                    name = tokens[1];
                    if (!users.containsKey (name)) {
                        System.out.printf ("ERROR: user %s not found%n", name);
                    } else {
                        users.remove (name);
                        System.out.printf ("%s unregistered successfully%n", name);
                    }
                    break;
            }
        }
        users
                .forEach ((key, value) -> System.out.printf ("%s => %s%n", key, value));
    }
}
