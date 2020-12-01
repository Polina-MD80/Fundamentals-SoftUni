import java.util.Scanner;

public
class TopIntegers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        topIntegers (n);
    }

    private static
    void topIntegers (int n) {
        for (int i = 1; i <= n; i++) {
            int sum        = 0;
            int count      = 0;
            int currantNum = i;
            while (currantNum > 0) {
                int digit = currantNum % 10;
                if (digit % 2 != 0) {
                    count++;
                }
                sum = sum + digit;
                currantNum = currantNum / 10;
            }
            if (sum % 8 == 0 && count >= 1) {
                System.out.println (i);
            }

        }
    }
}
