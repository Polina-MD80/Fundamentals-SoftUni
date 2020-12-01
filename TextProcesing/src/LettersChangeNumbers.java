import java.util.Scanner;

public
class LettersChangeNumbers {
    public static
    void main (String[] args) {
        Scanner  scanner = new Scanner (System.in);
        String[] input   = scanner.nextLine ().split ("\\s+");
        double   sum     = 0;
        for (String currant : input) {
            int    leadingChar = currant.charAt (0);
            int    tailChar    = currant.charAt (currant.length () - 1);
            double number      = Double.parseDouble (currant.substring (1, currant.length () - 1));
            number = getNumber (leadingChar, tailChar, number);

            sum += number;

        }
        System.out.printf ("%.2f", sum);
    }

    private static
    double getNumber (int leadingChar, int tailChar, double number) {
        if (leadingChar >= 65 && leadingChar <= 90) {
            int divider = leadingChar - 64;
            number = number / divider;
        } else if (leadingChar >= 97 && leadingChar <= 122) {
            int multiplier = leadingChar - 96;
            number = number * multiplier;
        }
        if (tailChar >= 65 && tailChar <= 90) {
            int subtract = tailChar - 64;
            number = number - subtract;
        } else if (tailChar >= 97 && tailChar <= 122) {
            int additive = tailChar - 96;
            number = number + additive;
        }
        return number;
    }
}
