import java.util.Scanner;

public
class Login {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        String  userName = scanner.nextLine ();
        String  password = "";
        boolean isLogged = false;

        for (int i = userName.length () - 1; i >= 0; i--) {
            password = password + userName.charAt (i);
        }
        for (int i = 0; i < 4; i++) {
            String input = scanner.nextLine ();
            if (input.equals (password)) {
                System.out.printf ("User %s logged in.", userName);
                isLogged = true;
                break;
            } else if (i < 3) {
                System.out.println ("Incorrect password. Try again.");
            }


        }
        if (!isLogged) {
            System.out.printf ("User %s blocked!", userName);
        }
    }
}
