import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class Algorithm {
    public static
    void main (String[] args) {
        Scanner       scanner  = new Scanner (System.in);
        List<Integer> list     = Arrays.stream (scanner.nextLine ().split (" ")).map (Integer::parseInt).collect (Collectors.toList ());
        List<Integer> listCopy = new ArrayList<> (list);
        List<Integer> sorted   = new ArrayList<> ();
        for (int i = 0; i < list.size (); i++) {
            int minNum = listCopy.stream ().mapToInt (n -> n).min ().getAsInt ();
            sorted.add (minNum);
            listCopy.remove (Integer.valueOf (minNum));
        }
        System.out.println (sorted);
        int count = list.indexOf (sorted.get (0));
        if (count + 1 < list.size ()) {
            for (int i = count+1; i < list.size ()-1; i++) {
                for (int j = i+1; j <list.size () ; j++) {
                    if (list.get (i)>list.get (j)){
                        count++;break;
                    }
                }

            }
        }
        for (int i = 0; i <= count; i++) {
            if (list.get (list.size ()-1)>list.get (i)){
                count++;break;
            }
        }
        System.out.println (count);

    }
}
