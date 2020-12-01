import java.util.Scanner;

public
class FromLeftToTheRight {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] input    = scanner.nextLine ().split (" ");
            long      leftNum  =Long.parseLong (input[0]);
            long      rightNum = Long.parseLong (input[1]);
            if (leftNum >= rightNum) {
                System.out.println (sumOfDigitsInNumber (leftNum));
            } else {
                System.out.println (sumOfDigitsInNumber (rightNum));
            }

        }

    }

    private static
    int sumOfDigitsInNumber (long number) {
        int sum = 0;
        long num = Math.abs (number);
         while (num>0){
             sum+= num%10;
             num=num/10;
         }

        return sum;
    }
}
