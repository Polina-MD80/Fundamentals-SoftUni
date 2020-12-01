import java.util.Scanner;

public
class TheLift {
    public static
    void main (String[] args) {
        Scanner  scanner = new Scanner (System.in);
        int      people  = Integer.parseInt (scanner.nextLine ());
        String[] input   = scanner.nextLine ().split ("\\s+");
        int[]    wagons  = new int[input.length];

        for (int i = 0; i < wagons.length; i++) {
            wagons[i] = Integer.parseInt (input[i]);
        }
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] < 4) {
                int freeSpace = 4 - wagons[i];
                int add       = Math.min (freeSpace, people);
                wagons[i] += add;
                people -= add;
                if (people == 0) {
                    break;
                }
            }
        }
        if (people == 0) {
            for (int i = 0; i < wagons.length; i++) {
                if (wagons[i] < 4) {
                    System.out.println ("The lift has empty spots!");
                    for (int wagon : wagons) {
                        System.out.print (wagon + " ");


                    }
                    return;

                }
            }

            for (int wagon : wagons) {
                System.out.print (wagon + " ");
            }


        } else if (people > 0) {
            System.out.printf ("There isn't enough space! %d people in a queue!%n", people);
            for (int wagon : wagons) {
                System.out.print (wagon + " ");
            }

        }
    }
}