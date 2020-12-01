import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class CardsGame {
    public static
    void main (String[] args) {
        Scanner       scanner      = new Scanner (System.in);
        List<Integer> firstPlayer  = readListOfIntegers (scanner);
        List<Integer> secondPlayer = readListOfIntegers (scanner);


        for (int i = 0; i < Math.min (firstPlayer.size (), secondPlayer.size ()); i++) {

            if (firstPlayer.get (i).equals (secondPlayer.get (i))) {
                firstPlayer.remove (i);
                secondPlayer.remove (i);
            } else if (firstPlayer.get (i) > secondPlayer.get (i)) {
                firstPlayer.add (firstPlayer.get (i));
                firstPlayer.remove (i);
                firstPlayer.add (secondPlayer.get (i));
                secondPlayer.remove (i);
            } else if (secondPlayer.get (i) > firstPlayer.get (i)) {
                secondPlayer.add (secondPlayer.get (i));
                secondPlayer.remove (i);
                secondPlayer.add (firstPlayer.get (i));
                firstPlayer.remove (i);
            }
            i = -1;

        }
        int sum = 0;
        if (firstPlayer.size () > secondPlayer.size ()) {
            System.out.printf ("First player wins! Sum: %d",sumOfWinner (firstPlayer));
        }else {
            System.out.printf ("Second player wins! Sum: %d",sumOfWinner(secondPlayer));
        }


    }

    private static
    int sumOfWinner (List<Integer> deck) {
      int sum = 0;
        for (int i = 0; i < deck.size (); i++) {
            sum+=deck.get(i);
        }
        return sum;
    }

    private static
    List<Integer> readListOfIntegers (Scanner scanner) {
        List<Integer> numbers = new ArrayList<> ();
        String[]      input   = scanner.nextLine ().split (" ");
        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt (input[i]);
            numbers.add (num);
        }
        return numbers;
    }

}
