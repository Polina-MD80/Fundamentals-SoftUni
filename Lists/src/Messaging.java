import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Messaging {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();
        List<String> line   = Arrays.stream (scanner.nextLine ().split ("")).collect (Collectors.toList ());
        for (int i = 0; i < numbers.length; i++) {
            int sum = 0;
            while (numbers[i] > 0) {
                sum += numbers[i] % 10;
                numbers[i] = numbers[i] / 10;
            }
            numbers[i] = sum;
        }

        String       result = "";
        for (int i = 0; i < numbers.length; i++) {
            String symbol = "";
            int    index  = numbers[i];
            while (line.size () - 1 < index) {
                index = index - line.size ();
            }
            symbol = line.get (index);
            result = result + symbol;
            line.remove (index);

        }
        System.out.println (result);

    }
}
