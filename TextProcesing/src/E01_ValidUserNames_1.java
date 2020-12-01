import java.util.Scanner;


public
class E01_ValidUserNames_1 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] userNames = scanner.nextLine ().split (", ");

        for (String currentUserName : userNames) {
            if (isValid (currentUserName)) {
                System.out.println (currentUserName);
            }
        }
    }

    public static
    boolean isValid (String username) {

        if (username.length () < 3 || username.length () > 16) {
            return false;
        }
        for (int i = 0; i < username.length (); i++) {
            char currentChar = username.charAt (i);
            if (!(Character.isLetterOrDigit (currentChar) || currentChar =='-' || currentChar =='_')) {
                return false;
            }
        }
        return true;
    }
}


