import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public
class FactorialDivision {
    public static
    void main (String[] args) {
        Scanner scanner   = new Scanner (System.in);
        int     firstNum  = Integer.parseInt (scanner.nextLine ());
        int     secondNum = Integer.parseInt (scanner.nextLine ());
       // if (firstNum >= secondNum) {
        //            System.out.printf ("%.2f", factorialDivision (firstNum, secondNum));
        //        } else {
        //            System.out.printf ("%.2f", factorialDivision (secondNum, firstNum));
        //        }
        System.out.printf ("%.2f",factorialDivision (firstNum,secondNum));
    }

    private static
    double factorialDivision (int firstNum, int secondNum) {
        double result = 1.0;

        result = 1.0*factorial(firstNum)/factorial (secondNum);

        return result;


    }

    private static
    long factorial (int n) {
        long result = 1;
        for (int i = 1; i <=n; i++) {
            result*=i;
        }return result;
    }

}
