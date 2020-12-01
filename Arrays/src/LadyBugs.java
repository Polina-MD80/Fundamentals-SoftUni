import java.util.Scanner;

public
class LadyBugs {
    public static
    void main (String[] args) {
        Scanner  scanner       = new Scanner (System.in);
        int      fieldLength   = Integer.parseInt (scanner.nextLine ());
        String[] bugsPositions = scanner.nextLine ().split (" ");
        int[]    bugsPos       = new int[bugsPositions.length];


        for (int i = 0; i < bugsPos.length; i++) {
            bugsPos[i] = Integer.parseInt (bugsPositions[i]);
        }
        int[] initialFieldPic = new int[fieldLength];


        for (int j = 0; j < bugsPos.length; j++) {
            for (int i = 0; i < initialFieldPic.length; i++) {
                if (bugsPos[j] == i) {
                    initialFieldPic[i] = 1;
                    break;

                }


            }

        }
        String[] command = scanner.nextLine ().split (" ");

        while (!command[0].equals ("end")) {

            int initialPosition = Integer.parseInt (command[0]);

            if (initialPosition > (initialFieldPic.length - 1)) {
                command = scanner.nextLine ().split (" ");
                continue;
            } else if (initialFieldPic[initialPosition] == 0) {
                command = scanner.nextLine ().split (" ");
                continue;
            }
            initialFieldPic[initialPosition] = 0;

            if (command[1].equals ("right")) {
                int rightFlies = Integer.parseInt (command[2]);
                while ((initialPosition + rightFlies) <= (initialFieldPic.length - 1) &&
                       (initialPosition + rightFlies) >= 0) {
                    if (initialFieldPic[initialPosition + rightFlies] == 1) {
                        initialPosition += rightFlies;
                    } else {
                        initialFieldPic[initialPosition + rightFlies] = 1;
                        break;
                    }
                }

            }
            if (command[1].equals ("left")) {
                int leftFlies = Integer.parseInt (command[2]);
                while ((initialPosition - leftFlies) >= 0 && (initialPosition - leftFlies) <= (initialFieldPic.length - 1)) {
                    if (initialFieldPic[initialPosition - leftFlies] == 1) {
                        initialPosition -= leftFlies;

                    } else {
                        initialFieldPic[initialPosition - leftFlies] = 1;
                        break;
                    }
                }

            }


            command = scanner.nextLine ().split (" ");
        }
        for (int value : initialFieldPic) {
            System.out.print (value + " ");
        }
    }
}