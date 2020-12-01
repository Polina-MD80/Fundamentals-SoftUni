import java.util.Scanner;

public
class SumOfOddNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        int sum = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            sum+=k;
            System.out.println (k);
            k+=2;
        }
        System.out.printf ("Sum: %d",sum);
    }
}
