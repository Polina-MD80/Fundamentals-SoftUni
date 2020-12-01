import java.util.*;
import java.util.stream.Collectors;

public
class Numbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());
        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        double average = sum / numbers.size ();
        for (int i = numbers.size () - 1; i >= 0; i--) {
            if (numbers.get (i) <= average) {
                numbers.remove (i);
            }

        }
        if (numbers.isEmpty ()) {
            System.out.println ("No");
        } else {
            Collections.sort (numbers);
            Collections.reverse (numbers);
            for (int i = 0; i < Math.min (5, numbers.size ()); i++) {
                System.out.print (numbers.get (i) + " ");


            }

        }
    }
}
