import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ListOperations {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .map (Integer::parseInt).collect (Collectors.toList ());
        String command = scanner.nextLine ();

        while (!command.equals ("End")) {
            String[] tokens = command.split ("\\s+");

            switch (tokens[0]) {
                case "Add":
                    int num = Integer.parseInt (tokens[1]);
                    numbers.add (num);
                    break;
                case "Insert":
                    int numToInsert = Integer.parseInt (tokens[1]);
                    int index = Integer.parseInt (tokens[2]);
                    if (index < numbers.size () && index >= 0) {
                        numbers.add (index, numToInsert);
                    } else {
                        System.out.println ("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt (tokens[1]);
                    if (indexToRemove < numbers.size () && indexToRemove >= 0) {
                        numbers.remove (indexToRemove);
                    } else {
                        System.out.println ("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt (tokens[2]);
                    switch (tokens[1]) {
                        case "left":
                            for (int i = 0; i < count; i++) {
                                numbers.add (numbers.get (0));
                                numbers.remove (0);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < count; i++) {
                                numbers.add (0, numbers.get (numbers.size () - 1));
                                numbers.remove (numbers.size () - 1);
                            }
                            break;
                    }
                    break;
            }


            command = scanner.nextLine ();
        }

        System.out.println (numbers.toString ().replaceAll ("[\\[\\],]", ""));
    }
}
