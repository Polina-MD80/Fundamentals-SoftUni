import java.util.Scanner;

public
class PalindromeIntegers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ();
        while (!input.equals ("END")) {
            System.out.println (isPalindrome (input));
            input = scanner.nextLine ();
        }
    }

    private static
    boolean isPalindrome (String input) {
        boolean isPalindromeInt = false;
        String oppositeString = "";
        for (int i = input.length () - 1; i >= 0; i--) {
            oppositeString = oppositeString + input.charAt (i);
        }
        if (input.equals (oppositeString)) {
            isPalindromeInt=true;
        }
        return isPalindromeInt;

    }
}
