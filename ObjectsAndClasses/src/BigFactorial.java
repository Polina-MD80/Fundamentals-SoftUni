

import java.math.BigInteger;
import java.util.Scanner;

public
class BigFactorial {
    public static
    void main (String[] args) {
        Scanner    scanner   = new Scanner (System.in);
        int        number    = Integer.parseInt (scanner.nextLine ());
        BigInteger factorial = factorial (number);
        System.out.println (factorial);
    }

    private static
    BigInteger factorial (int number) {
        BigInteger result = BigInteger.valueOf (1);
        for (int i = 1; i <= number; i++) {
            result = result.multiply (BigInteger.valueOf (i));
        }
        return result;

    }

}
