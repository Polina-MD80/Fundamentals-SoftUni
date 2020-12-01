import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public
class OddOccurrences {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        //Java C# PHP PHP JAVA C java
        Map<String,Integer> words = new LinkedHashMap<> ();
        List<String> input = Arrays.stream(scanner.nextLine ().split (" ")).map (String::toLowerCase).collect (Collectors.toList ());
        for (String s : input) {
            words.putIfAbsent (s,0);
            words.put (s, words.get (s)+1);
        }
        List <String> output = new ArrayList<> ();
        words.entrySet ().stream ().filter (w->w.getValue ()%2!=0).forEach (w->output.add (w.getKey ()));
        System.out.println (String.join (", ",output));



    }
}
