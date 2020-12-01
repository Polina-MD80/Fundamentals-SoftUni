import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Inventory {
    public static
    void main (String[] args) {
        Scanner      scanner   = new Scanner (System.in);
        List<String> inventory = Arrays.stream (scanner.nextLine ().split (", ")).collect (Collectors.toList ());
        String       command   = scanner.nextLine ();
        while (!"Craft!".equals (command)) {
            String[] tokens = command.split (" - ");
            switch (tokens[0]) {
                case "Collect":
                    collect (tokens[1], inventory);
                    break;
                case "Drop":
                    drop (tokens[1], inventory);
                    break;

                case "Combine Items":
                    combineItems (tokens[1], inventory);
                    break;
                case "Renew":
                    renew (tokens[1], inventory);
                    break;
            }
            command = scanner.nextLine ();
        }
        printList(inventory);
    }

    private static
    void printList (List<String> inventory) {
        for (int i = 0; i < inventory.size () ; i++) {
            System.out.print (inventory.get (i));
            if(i!=inventory.size ()-1){
                System.out.print (", ");
            }
        }
    }

    private static
    void renew (String token, List<String> inventory) {
        if (inventory.contains (token)) {
            inventory.remove (token);
            inventory.add (token);
        }
    }

    private static
    void combineItems (String token, List<String> inventory) {
        String[] itemsToCombine = token.split (":");
        if (inventory.contains (itemsToCombine[0])) {
            inventory.add (inventory.indexOf (itemsToCombine[0]) + 1, itemsToCombine[1]);
        }
    }

    private static
    void drop (String token, List<String> inventory) {
        inventory.remove (token);
    }


    private static
    void collect (String token, List<String> inventory) {
        if (!inventory.contains (token)) {
            inventory.add (token);
        }

    }
}
