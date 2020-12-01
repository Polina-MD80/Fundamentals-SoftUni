import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public
class Lists {
    public static
    void main (String[] args) {
        List<Integer> list = new ArrayList<> ();
        List<Integer> numbers = new ArrayList<> (Arrays.asList (10, 20, 30));
        numbers.remove (Integer.valueOf (10));

        list.add (1);
        list.add (2);
        System.out.println (list.toString().replaceAll ("[\\[\\],]", ""));
        System.out.println (numbers);
    }
    // List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
    //                .map(Integer::parseInt).collect(Collectors.toList());
    //-------------------------------------------------------------------------------
    //List<Double> numbers = Arrays.stream (scanner.nextLine ().split (" "))
    //                     .map (Double::parseDouble).collect(Collectors.toList());
    //-------------------------------------------------------------------------------

    //List<Integer> pokemonList = new ArrayList<> ();
    //        String[] numbers = scanner.nextLine ().split (" ");
    //
    //        for (int i = 0; i < numbers.length; i++) {
    //            int pokemon = Integer.parseInt (numbers[i]);
    //            pokemonList.add (pokemon);
    //   ---------------------------------------------------------------------------
    //System.out.println (numbers.toString ().replaceAll("[\\[\\],]", ""));
    //--------------------------------------------------------------------------------
    // List<Integer> numbers = new ArrayList<> (Arrays.asList (10, 20, 30));
    //--------------------------------------------------------------------------------
   // Arrays.sort(arr);!!!
    //Collections.sort(list);!!!



}
