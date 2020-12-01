import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public
class PasswordValidator {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        String  password = scanner.nextLine ();
        passwordValidation (password);
    }


    private static
    void passwordValidation (String password) {
        String output = String.format ("%s%s%s", validCharacters (password), validDigits (password), validLetters (password));
        if (output.equals ("")) {
            System.out.println ("Password is valid");
        } else {
            if (!validCharacters (password).equals ("")) {
                System.out.println (validCharacters (password));
            }if(!validLetters (password).equals (""))
            System.out.println(validLetters (password));
            if (!validDigits (password).equals (""))
                System.out.println (validDigits (password));
        }

    }

    private static
    String validCharacters (String password) {
        String output = "";
        if (password.length () < 6 || password.length () > 10) {
            output = "Password must be between 6 and 10 characters";
        }
        return output;
    }

    private static
    String validDigits (String password) {
        int    countDigits = 0;
        String output      = "Password must have at least 2 digits";
        for (int i = 0; i < password.length (); i++) {
            if (password.charAt (i) >= 48 && password.charAt (i) <= 57) {
                countDigits++;
            }
            if (countDigits == 2) {
                output = "";
                break;
            }
        }
        return output;
    }

    private static
    String validLetters (String password) {
        String output = "";
        password = password.toLowerCase ();
        for (int i = 0; i < password.length (); i++) {
            if (!((password.charAt (i) >= 97 && password.charAt (i) <= 122)) &&
                !((password.charAt (i) >= 48 && password.charAt (i) <= 57))) {
                output = "Password must consist only of letters and digits";
                break;
            }
        }
        return output;
    }
}
