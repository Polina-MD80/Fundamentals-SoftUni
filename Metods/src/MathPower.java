import java.text.DecimalFormat;
import java.util.Scanner;

public
class MathPower {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        double number = Double.parseDouble (scanner.nextLine ());
        int power = Integer.parseInt (scanner.nextLine ());
        System.out.println (new DecimalFormat ("0.####").format (mathPower(number,power)));
    }

    private static
    double mathPower (double num, int n) {
        return Math.pow (num,n);
    }
}
