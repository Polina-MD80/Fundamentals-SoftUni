import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;

public
class ArcheryTournament {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[]   fields  = Arrays.stream (scanner.nextLine ().split ("\\|")).mapToInt (Integer::parseInt).toArray ();

        int    points  = 0;
        String command = scanner.nextLine ();
        while (!"Game over".equals (command)) {
            String[] tokens = command.split ("@");
            switch (tokens[0]) {
                case "Shoot Left":
                    int startIndex = Integer.parseInt (tokens[1]);
                    int length = Integer.parseInt (tokens[2]);
                    if (startIndex >= 0 && startIndex < fields.length) {
                        int indexToShoot = startIndex - length;
                        while (indexToShoot < 0) {
                            indexToShoot = fields.length + indexToShoot;
                        }
                        if (fields[indexToShoot] < 5) {
                            points += fields[indexToShoot];
                            fields[indexToShoot] = 0;
                        } else {
                            fields[indexToShoot] -= 5;
                            points += 5;
                        }
                    }

                    break;
                case "Shoot Right":
                    int startIndexR = Integer.parseInt (tokens[1]);
                    int lengthR = Integer.parseInt (tokens[2]);
                    if (startIndexR >= 0 && startIndexR < fields.length) {
                        int indexToShootR = startIndexR + lengthR;
                        while (indexToShootR > fields.length - 1){
                          indexToShootR = indexToShootR- fields.length;
                        }
                        if (fields[indexToShootR] < 5) {
                            points += fields[indexToShootR];
                            fields[indexToShootR] = 0;
                        } else {
                            fields[indexToShootR] -= 5;
                            points += 5;
                        }
                    }

                    break;
                case "Reverse":
                    for (int i = 0; i < fields.length/2; i++) {
                        int temp = fields[i];
                        fields[i]= fields[fields.length-1-i];
                        fields[fields.length-1-i] = temp;
                    }
                    break;
            }

            command = scanner.nextLine ();
        }

        for (int i = 0; i < fields.length; i++) {
            System.out.print (fields[i]);
            if (i<fields.length-1){
                System.out.print(" - ");
            }
        }
        System.out.println ();
        System.out.printf ("Iskren finished the archery tournament with %d points!", points);
    }
}
