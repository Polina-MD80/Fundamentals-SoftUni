import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class AMinerTask {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Integer> resources = new LinkedHashMap<> ();

        String oddInput = scanner.nextLine ();
        while (!"stop".equals (oddInput)) {
            Integer evenInput = Integer.parseInt (scanner.nextLine ());
            resources.putIfAbsent (oddInput, 0);
            resources.put (oddInput, resources.get (oddInput) + evenInput);
            oddInput = scanner.nextLine ();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet ()) {
            System.out.printf ("%s -> %d%n", entry.getKey (), entry.getValue ());
        }
    }
}
