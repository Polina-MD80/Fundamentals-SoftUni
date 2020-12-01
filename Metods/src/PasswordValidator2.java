import java.util.Scanner;

public
class PasswordValidator2 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String password = scanner.nextLine ();
        isValidOrNeedCorrection (password);
    }

    private static
    void isValidOrNeedCorrection (String password) {
        validNumberOfCharacters(password);
        validOnlyLetterAndDigits(password);
        haveAtLeastTwoDigits (password);

    }

    private static
    boolean haveAtLeastTwoDigits (String password) {
        int count = 0;
        for (int i = 0; i < password.length (); i++) {
            if (password.charAt (i)>=48&&password.charAt (i)<=57){
                count++;
            }if (count==2){
                return true;
            }
        }
        System.out.println ("Password must have at least 2 digits");
        return false;
    }

    private static
    boolean validOnlyLetterAndDigits (String password) {
        for (int i = 0; i < password.length (); i++) {
            if(!((password.charAt (i)>=48&&password.charAt (i)<=57)||(password.charAt (i)>=65&&password.charAt (i)<=90)||(password.charAt (i)>=97&&password.charAt (i)<=122))){
                System.out.println ("Password must consist only of letters and digits");
                return false;
            }
        }return true;
    }

    private static
    boolean validNumberOfCharacters (String password) {
        if (!(password.length ()>=6&&password.length ()<=10)){
            System.out.println ("Password must be between 6 and 10 characters");
            return false;
        }
        return true;
    }
}
