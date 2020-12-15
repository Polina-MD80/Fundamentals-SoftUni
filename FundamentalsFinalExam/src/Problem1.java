import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public
class Problem1 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  email   = scanner.nextLine ();

        String command = scanner.nextLine ();

        while (!"Complete".equals (command)) {
            String[] tokens = command.split ("\\s+");

            switch (tokens[0]) {
                case "Make":
                    switch (tokens[1]) {
                        case "Upper" -> {
                            email = email.toUpperCase ();
                            System.out.println (email);
                        }
                        case "Lower" -> {
                            email = email.toLowerCase ();
                            System.out.println (email);
                        }
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt (tokens[1]);
                    System.out.println (email.substring (email.length () - count));
                    break;
                case "GetUsername":
                    if (email.contains ("@")) {
                        int indexOfEt = email.indexOf ('@');
                        System.out.println (email.substring (0, indexOfEt));
                    } else {
                        System.out.printf ("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String symbol = tokens[1];
                    email = email.replace (symbol, "-");
                    System.out.println (email);
                    break;
                case "Encrypt":
                    List<Integer> numbers = new ArrayList<> ();
                    for (char c : email.toCharArray ()) {
                        numbers.add ((int) c);
                    }
                    System.out.println (numbers.toString ().replaceAll ("[\\[\\],]", ""));

                    break;

            }
            command = scanner.nextLine ();
        }
    }
}
