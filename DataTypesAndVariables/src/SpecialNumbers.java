import java.util.Scanner;

public
class SpecialNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        for (int i = 1; i <= n; i++) {
            int sum        = 0;
            int currantNum = i;
            while (currantNum != 0) {

                sum = sum + currantNum %10;
                currantNum = currantNum/10;
            }
            boolean isSpecial = (sum == 7)||(sum==5)||(sum==11);
            if (isSpecial){
                System.out.println (i + " -> " + "True");
            }else {
                System.out.println (i + " -> " + "False");

            }
        }
    }
}
