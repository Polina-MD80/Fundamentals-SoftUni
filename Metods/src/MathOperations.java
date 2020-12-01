import java.text.DecimalFormat;
import java.util.Scanner;

public
class MathOperations {
    public static
    void main (String[] args) {
        Scanner scanner      = new Scanner (System.in);
        double  firstNumber  = Double.parseDouble (scanner.nextLine ());
        String  operator     = scanner.nextLine ();
        double  secondNumber = Double.parseDouble (scanner.nextLine ());

        System.out.println (new DecimalFormat ("0.##").format(calculation (firstNumber, operator, secondNumber)));
    }

    private static
    double calculation (double a, String operator, double b) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = (a + b);
                break;
            case "-":
                result = (a - b);
                break;
            case "*":
                result = (a * b);
                break;
            case "/":
                result = (a / b);
                break;
        }
        return result;


    }
}
