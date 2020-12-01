
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ChangeList {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split ("\\s+"))
                .map (Integer::parseInt).collect (Collectors.toList ());


        String command = scanner.nextLine ();
        while (!command.equals ("end")) {
            String[] tokens = command.split ("\\s+");
            switch (tokens[0]) {
                case "Delete":
                    int numToDelete = Integer.parseInt (tokens[1]);
                    for (int i = numbers.size ()-1; i >=0 ; i--) {
                        numbers.remove (Integer.valueOf (numToDelete));
                    }
                    break;
                case "Insert":
                    int numberToAdd = Integer.parseInt (tokens[1]);
                    int indexToAdd = Integer.parseInt (tokens[2]);
                    if (indexToAdd <= numbers.size () - 1 && indexToAdd >= 0) {
                        numbers.add (indexToAdd, numberToAdd);
                    }
                    break;
            }


            command = scanner.nextLine ();
        }
        System.out.println (numbers.toString ().replaceAll ("[\\[\\],]", ""));
    }
}

