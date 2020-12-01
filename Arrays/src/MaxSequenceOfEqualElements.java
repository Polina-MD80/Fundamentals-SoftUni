import java.util.Scanner;

public
class MaxSequenceOfEqualElements {
    public static
    void main (String[] args) {
        Scanner  scanner   = new Scanner (System.in);
        String[] input     = scanner.nextLine ().split (" ");
        int      count     = 1;
        String   best      = input[0];
        int      bestCount = 1;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i].equals (input[i + 1])) {
                count++;
                if (count > bestCount) {
                    bestCount = count;
                    best = input[i];
                }
            } else {
                count = 1;

            }
        }
        for (int i = 0; i < bestCount; i++) {
            System.out.print (best + " ");
        }
    }
}
