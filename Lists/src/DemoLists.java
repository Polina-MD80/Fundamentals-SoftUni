import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class DemoLists {
    public static
    void main (String[] args) {
        Scanner       scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt)
                .sorted (Comparator.reverseOrder ())//(a,b)->b.comparedTo(a)
                .collect(Collectors.toList());
        System.out.println (numbers);
        for (int i = numbers.size ()-1; i >=0 ; i--) {
            if (numbers.get (i)<0){
                numbers.remove (i);
            }

        }
        numbers.remove (Integer.valueOf (3));//premahva samo pyrvoto 3
        System.out.println (numbers);

    }
}
