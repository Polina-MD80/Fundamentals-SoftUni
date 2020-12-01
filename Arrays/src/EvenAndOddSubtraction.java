import javax.swing.*;
import java.util.Scanner;

public
class EvenAndOddSubtraction {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] numbers      = scanner.nextLine ().split (" ");
        int oddSum = 0;
        int evenSum = 0;
        for (String number : numbers) {
            int current = Integer.parseInt (number);
            if (current%2==0){
                evenSum+=current;
            }else {
                oddSum+=current;
            }

        }
        System.out.println (evenSum-oddSum);
    }
}
