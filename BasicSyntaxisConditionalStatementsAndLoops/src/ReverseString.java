import java.util.Scanner;

public
class ReverseString {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        System.out.print (reversedString(input));
    }

    private static
    String reversedString (String text) {
        String resultString = "";
        for (int i = text.length ()-1; i >=0 ; i--) {
            resultString = resultString + text.charAt (i);
        }
        return resultString;
    }
}
