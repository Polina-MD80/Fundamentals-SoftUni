import java.util.Scanner;

public
class MultiplyEvensByOdds {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int number = Integer.parseInt (scanner.nextLine ());
        System.out.println (getMultipleOfEvenAndOdds(number));
    }

    private static
    int getMultipleOfEvenAndOdds (int n) {
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);
        return (evenSum*oddSum);
    }

    private static
    int getSumOfOddDigits (int n) {
        int oddSum = 0;
        while (Math.abs (n)>0){
            int digit = n%10;
            n=n/10;
            if (digit%2!=0){
                oddSum+=digit;
            }
        }
        return oddSum;


    }

    private static
    int getSumOfEvenDigits (int n) {
        int evenSum = 0;
        while (Math.abs (n) >0){
            int digit = n%10;
            n=n/10;
            if (digit%2==0){
                evenSum+=digit;
            }
        }
        return evenSum;

    }

}
