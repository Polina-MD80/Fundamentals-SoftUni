import java.util.*;
import java.util.stream.Collectors;

public
class MergingList {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);
        List<Integer> firstList = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());
        List<Integer> secondList = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());
        List<Integer> result = new ArrayList<> ();

        for (int i = 0; i < Math.min (firstList.size (), secondList.size ()); i++) {
            result.add (firstList.get (i));
            result.add (secondList.get (i));
        }
        if(firstList.size ()>secondList.size ()){
            System.out.println(addRestElementsToResult(result,firstList,secondList)
                    .toString ().replaceAll ("[\\[\\],]", ""));
        }else {
            System.out.println(addRestElementsToResult(result,secondList,firstList)
                    .toString ().replaceAll ("[\\[\\],]", ""));
        }

    }

    private static
    List<Integer> addRestElementsToResult
            (List<Integer> merged, List<Integer> longer, List<Integer>shorter) {
        int startIndex = shorter.size ();
        int endIndex = longer.size ();
        for (int i = startIndex; i < endIndex ; i++) {
            //0123456789
            //01234

            merged.add (longer.get (i));
            //Collections.sort (merged);
            //Collections.reverse (merged);
        }
        return merged;
    }
}
