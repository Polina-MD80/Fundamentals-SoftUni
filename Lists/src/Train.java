import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Train {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> wagons = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());
        int maxCapacity = Integer.parseInt (scanner.nextLine ());

        String command = scanner.nextLine ();
        while (!command.equals ("end")) {
            String[] tokens = command.split (" ");
            if (tokens[0].equals ("Add")) {
                int nextWagon = Integer.parseInt (tokens[1]);
                wagons.add (nextWagon);
            } else {
                int paxToTake = Integer.parseInt (tokens[0]);
                for (int i = 0; i < wagons.size (); i++) {
                    if (wagons.get (i) + paxToTake <= maxCapacity) {
                        wagons.set (i, wagons.get (i) + paxToTake);
                        break;

                    }
                }
            }

            command = scanner.nextLine ();
        }
        System.out.println (wagons.toString ().replaceAll ("[\\[\\],]", ""));
    }
}

