import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class BombNumbers {
    public static
    void main (String[] args) {
        Scanner       scanner = new Scanner (System.in);
        String        input   = scanner.nextLine ();
        List<Integer> numbers = readListOfIntegers (input);
        String[] parameters = scanner.nextLine ().split (" ");
        int specialNum = Integer.parseInt (parameters[0]);
        int power = Integer.parseInt (parameters[1]);

        while (numbers.contains (specialNum)){
            int leftIndex = Math.max(0, numbers.indexOf (specialNum)-power);
            int rightIndex = Math.min (numbers.indexOf (specialNum)+power,numbers.size ()-1);
            for (int i = rightIndex; i >=leftIndex ; i--) {
                numbers.remove (i);
            }
        }
        printSumOfIntList(numbers);



    }

    private static
    void printSumOfIntList (List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum+=number;
        }
        System.out.println (sum);
    }


    private static
    void printIntegerList (List<Integer> numbers) {
        for (Integer number : numbers) {

            System.out.print (number+" ");
        }
    }

    private static
    List<Integer> readListOfIntegers (String input) {
        List<Integer> numbers = new ArrayList<> ();
        String[]num = input.split (" ");
        for (int i = 0; i < num.length; i++) {
            numbers.add (Integer.parseInt (num[i]));

        }
        return numbers;
    }

}