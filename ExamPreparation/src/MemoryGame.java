import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class MemoryGame {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<String> sequence = new ArrayList<> ();
        String[] sequenceInput = scanner.nextLine ().split (" ");
        for (int i = 0; i < sequenceInput.length; i++) {
            sequence.add (sequenceInput[i]);
        }
        String input = scanner.nextLine ();
        int count = 0;

        while (!"end".equals (input)&&sequence.size ()!=0){
            String[] tokens = input.split (" ");
            count++;
            int firstIndex = Integer.parseInt (tokens[0]);
            int secondIndex = Integer.parseInt (tokens[1]);
            if (firstIndex<0||firstIndex>=sequence.size ()||secondIndex<0||secondIndex>=sequence.size ()||
                firstIndex==secondIndex){
                System.out.println ("Invalid input! Adding additional elements to the board");
                String additionalElement = "-";
                additionalElement = additionalElement + count + "a";
                int middleIndex = sequence.size ()/2;
                sequence.add (middleIndex,additionalElement);
                sequence.add (middleIndex,additionalElement);

            }else if (sequence.get (firstIndex).equals (sequence.get (secondIndex))){
                String element = sequence.get (firstIndex);
                int biggerIndex = Math.max (firstIndex,secondIndex);
                int smallerIndex = Math.min (firstIndex, secondIndex);

                sequence.remove (biggerIndex);
                sequence.remove (smallerIndex);

                System.out.printf ("Congrats! You have found matching elements - %s!%n",element);
                if (sequence.size ()==0){
                    System.out.printf ("You have won in %d turns!",count);return;
                }
            }else {
                System.out.println ("Try again!");
            }

            input= scanner.nextLine ();
        }
        System.out.println ("Sorry you lose :(");
        System.out.println (sequence.toString ().replaceAll ("[\\[\\],]", ""));
    }
}
