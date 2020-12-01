import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class MovingTarget {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Integer> targets = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .map (Integer::parseInt).collect (Collectors.toList ());
        String command = scanner.nextLine ();

        while (!"End".equals (command)) {
            String[] tokens = command.split ("\\s+");
            switch (tokens[0]) {
                case "Shoot":
                    int indexToShoot = Integer.parseInt (tokens[1]);
                    int power = Integer.parseInt (tokens[2]);
                    if (indexToShoot >= 0 && indexToShoot < targets.size ()) {
                        targets.set (indexToShoot, targets.get (indexToShoot) - power);
                        if (targets.get (indexToShoot) <= 0) {
                            targets.remove (indexToShoot);
                        }
                    }
                    break;
                case "Add":
                    int indexToAdd = Integer.parseInt (tokens[1]);
                    int targetToAdd = Integer.parseInt (tokens[2]);
                    if (indexToAdd >= 0 && indexToAdd < targets.size ()) {
                        targets.add (indexToAdd, targetToAdd);
                    } else {
                        System.out.println ("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int targetToStrike = Integer.parseInt (tokens[1]);
                    int radius = Integer.parseInt (tokens[2]);
                    int startIndex = targetToStrike - radius;
                    int endIndex = targetToStrike + radius;
                    if (startIndex >= 0 && startIndex <= targets.size () && endIndex >= 0 && endIndex <= targets.size ()) {
                       if(startIndex<endIndex) strike (targets, startIndex, endIndex);
                       else strike (targets,endIndex,startIndex);
                    } else {
                        System.out.println ("Strike missed!");
                    }
                    break;
            }


            command = scanner.nextLine ();
        }
        System.out.print (targets.get (0));
        if (targets.size () > 0) {
            for (int i = 1; i < targets.size (); i++) {
                System.out.print ("|" + targets.get (i));
            }
        }
    }

    private static
    void strike (List<Integer> targets, int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex; i--) {
            targets.remove (i);
        }
    }
}
