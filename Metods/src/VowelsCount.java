import java.util.Scanner;

public
class VowelsCount {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  input   = scanner.nextLine ().toLowerCase ();
        System.out.println (vowelsCount (input));
    }

    private static
    int vowelsCount (String input) {
        int countOfVowels = 0;
        for (int i = 0; i < input.length (); i++) {
            char letter = input.charAt (i);
            if (letter == 'a' || letter == 'e' || letter == 'o' || letter == 'i' || letter == 'u' ) {
                countOfVowels++;
            }

        }
        return countOfVowels;
    }
}
