import java.util.Scanner;

public
class ValidUsernames {
    public static
    void main (String[] args) {
        Scanner  scanner   = new Scanner (System.in);
        String[] usernames = scanner.nextLine ().split (", ");
        for (int i = 0; i < usernames.length; i++) {
            Boolean  isValid   = true;
            String currant = usernames[i];
            if (currant.length () < 3 || currant.length () > 16) {
                isValid = false;
                continue;
            }
            for (int j = 0; j < currant.length (); j++) {
                if (!(Character.isAlphabetic (currant.charAt (j))
                      || Character.isDigit (currant.charAt (j))
                      || currant.charAt (j) == '-' || currant.charAt (j) == '_')) {
                    isValid = false;break;
                }
            }
            if (isValid){
                System.out.println (currant);
            }

        }

    }
}
