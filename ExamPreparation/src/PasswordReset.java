import java.util.Scanner;

public
class PasswordReset {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        String  password = scanner.nextLine ();
        String  command  = scanner.nextLine ();
        while (!"Done".equals (command)) {
            String[] tokens = command.split (" ");
            switch (tokens[0]) {
                case "TakeOdd":
                    password = takeOdd (password, tokens);
                    break;
                case "Cut":
                    password = cut (password, tokens);
                    break;
                case "Substitute":
                    password = substitute (password, tokens);
                    break;
            }
            command = scanner.nextLine ();
        }
        System.out.printf ("Your password is: %s",password);
    }

    private static
    String substitute (String password, String[] tokens) {
        if (!password.contains (tokens[1])) {
            System.out.println ("Nothing to replace!");
        } else {
            while (password.contains (tokens[1])) {
                password = password.replace (tokens[1], tokens[2]);
            }
            System.out.println (password);
        }
        return password;
    }

    private static
    String cut (String password, String[] tokens) {
        int           index       = Integer.parseInt (tokens[1]);
        int           length      = Integer.parseInt (tokens[2]);
        StringBuilder newPassword = new StringBuilder (password);
        newPassword.replace (index, index + length, "");

        password =  newPassword.toString ();
        System.out.println (password);
        return password;

    }

    private static
    String takeOdd (String password, String[] tokens) {
        StringBuilder newPassword = new StringBuilder ();
        for (int i = 0; i < password.length (); i++) {
            if (i % 2 != 0) {
                newPassword.append (password.charAt (i));
            }
        }
        password = newPassword.toString ();
        System.out.println (password);
        return password;
    }
}
