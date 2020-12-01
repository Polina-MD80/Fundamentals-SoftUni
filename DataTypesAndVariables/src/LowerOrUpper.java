import java.util.Scanner;

public
class LowerOrUpper {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        char    input   = scanner.nextLine ().charAt (0);
        if ((int) input >= 65 && (int) input <= 90){
            System.out.println ("upper-case");
        }else if (input >= 97 && input <= 122){
            System.out.println ("lower-case");
        }
    }
}
