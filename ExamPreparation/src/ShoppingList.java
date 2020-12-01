import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ShoppingList {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);

        List<String> list    = Arrays.stream (scanner.nextLine ().split ("!")).collect (Collectors.toList ());

        String input = scanner.nextLine ();

        while (!"Go Shopping!".equals (input)) {
            String[] command = input.split ("\\s+");
            switch (command[0]) {
                case "Urgent":
                    if (!list.contains (command[1])) {
                        list.add (0, command[1]);
                    }
                    break;
                case "Unnecessary":
                    list.remove (String.valueOf (command[1]));
                    break;
                case "Correct":
                    String itemToCorrect = command[1];
                    String newItem = command[2];
                    if (list.contains (itemToCorrect)) {
                        int index = list.indexOf (itemToCorrect);
                        list.set (index, newItem);
                    }
                    break;
                case "Rearrange":
                    String itemToMove = command[1];
                    if (list.contains (itemToMove)) {
                        list.remove (itemToMove);
                        list.add (itemToMove);
                    }
                    break;
            }


            input = scanner.nextLine ();
        }

        System.out.println (list.toString ().replaceAll ("[\\[\\]]", ""));
    }
}
