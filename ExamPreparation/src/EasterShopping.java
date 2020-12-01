import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class EasterShopping {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        List<String> shops   = Arrays.stream (scanner.nextLine ().split ("\\s+")).collect (Collectors.toList ());
        int          n       = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine ().split (" ");
            switch (command[0]) {
                case "Include":
                    include (shops, command);
                    break;
                case "Visit":
                    visit (shops, command);
                    break;
                case "Prefer":
                    prefer(shops, command);
                    break;
                case "Place":
                    place(shops,command);
                    break;
            }
        }

        System.out.println ("Shops left:");
        System.out.println (String.join (" ", shops));

    }

    private static
    void place (List<String> shops, String[] command) {
        int index = Integer.parseInt (command[2])+1;
        if (index>=0&&index<shops.size ()){
            shops.add (index,command[1]);
        }
    }

    private static
    void prefer (List<String> shops, String[] command) {
        int index1 = Integer.parseInt (command[1]);
        int index2 = Integer.parseInt (command[2]);
        if (index1>=0&&index1<shops.size ()&&index2>=0&&index2<shops.size ()){
            String temp = shops.get (index1);
            shops.set (index1, shops.get (index2));
            shops.set (index2,temp);
        }
    }

    private static
    void visit (List<String> shops, String[] command) {
        int number = Integer.parseInt (command[2]);
        if (number <= shops.size ()) {
            switch (command[1]) {
                case "first":
                    if (number > 0) {
                        shops.subList (0, number).clear ();
                    }
                    break;
                case "last":
                    for (int i = 0; i < number; i++) {
                        shops.remove (shops.size ()-1);
                    }
                    break;
            }
        }
    }

    private static
    void include (List<String> shops, String[] command) {
        shops.add (command[1]);
    }
}
