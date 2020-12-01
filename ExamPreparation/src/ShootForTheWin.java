import java.util.Arrays;
import java.util.Scanner;

public
class ShootForTheWin {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int[] targets = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .mapToInt (Integer::parseInt).toArray ();

        String input       = scanner.nextLine ();
        int    shotTargets = 0;

        while (!"End".equals (input)) {
            int index = Integer.parseInt (input);
            if (index >= 0 && index < targets.length && targets[index] != -1) {
                shotTargets++;
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1 && i != index) {
                        if (targets[i] <= targets[index]) {
                            targets[i] = targets[i] + targets[index];
                        } else targets[i] = targets[i] - targets[index];
                    }
                }

                targets[index] = -1;

            }

            input = scanner.nextLine ();
        }
        System.out.printf ("Shot targets: %d -> %s", shotTargets, Arrays.toString (targets).replaceAll ("[\\[\\],]", ""));
    }
}
