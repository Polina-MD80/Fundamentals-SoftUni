import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class SumAdjacentEqualNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Double> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                     .map (Double::parseDouble).collect(Collectors.toList());
        for (int i = 0; i < numbers.size ()-1; i++) {
            double currantNum = numbers.get (i);
            double nextNum = numbers.get(i+1);
            if (currantNum==nextNum){
                numbers.set (i, currantNum+nextNum);
                numbers.remove (numbers.get (i+1));
                i=-1;
            }


        }
        System.out.print(stringJoinedByDelimiter(numbers," "));
    }

    private static
    String stringJoinedByDelimiter (List<Double> numbers, String delimiter) {
        String s="";
        for (Double number : numbers) {
            s = s+ new DecimalFormat ("0.#").format (number)+delimiter;
        }return s;
    }
}
