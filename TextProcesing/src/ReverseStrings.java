import java.util.Scanner;

public
class ReverseStrings {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ();
        while (!"end".equals (input)) {
            printReversedWord (input);
            input = scanner.nextLine ();
        }
    }

    private static
    void printReversedWord (String input) {
        String[] reversedWord = new String[input.length ()];
        for (int i = 0; i < reversedWord.length; i++) {
            reversedWord[i] = "" + input.charAt (input.length () - 1 - i);
        }
        System.out.printf("%s = %s%n", input,String.join ("",reversedWord));
    }

//    private static
//    void printReversedWord (String input) {
//        String reversedWord = "";
//        for (int i = input.length ()-1; i >=0 ; i--) {
//            reversedWord += input.charAt (i);
//
//        }
//        System.out.printf ("%s = %s%n", input,reversedWord);
//    }
}
