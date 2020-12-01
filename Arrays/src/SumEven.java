import java.util.Scanner;

public
class SumEven {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] numbers = scanner.nextLine ().split (" ");

        int sum = 0;
        for (String number : numbers) {
            int current = Integer.parseInt (number);
            if (current%2==0){
                sum += current;
            }

        }
        System.out.println (sum);
    }
}
