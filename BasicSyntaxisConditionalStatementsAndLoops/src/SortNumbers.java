import java.util.Arrays;
import java.util.Scanner;

public
class SortNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt (scanner.nextLine ());
            numbers[i]=number;
        }
        Arrays.sort (numbers);
        for (int i = 2; i >=0 ; i--) {
            System.out.println (numbers[i]);
        }
    }
}
