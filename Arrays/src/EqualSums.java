import java.util.Scanner;

public
class EqualSums {
    public static
    void main (String[] args) {
        Scanner  scanner  = new Scanner (System.in);
        String[] input    = scanner.nextLine ().split (" ");
        int[]    numbers  = new int[input.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt (input[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            int      sumLeft  = 0;
            int      sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + numbers[j];
            }
            for (int j = i + 1; j < numbers.length; j++) {
                sumRight = sumRight + numbers[j];
            }
            if (sumLeft == sumRight) {
                System.out.println (i);return;
            }

        }
        System.out.println ("no");

    }
}
