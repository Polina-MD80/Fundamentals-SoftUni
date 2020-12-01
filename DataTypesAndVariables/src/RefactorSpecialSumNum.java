import java.util.Scanner;

public
class RefactorSpecialSumNum {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean isSpecial = false;
        for (int i = 1; i<= n; i++) {
            int currantNum = i;
            int sum = 0;
            while (currantNum > 0) {
                sum = sum + currantNum % 10;
                currantNum = currantNum / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            System.out.printf("%d -> %b%n", i, isSpecial);

        }
    }
}
