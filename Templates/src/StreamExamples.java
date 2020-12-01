import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public
class StreamExamples {

    public static
    void main (String[] args) {
        /*List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        long count = stream
                .map(String::toLowerCase)
                .count();
        Stream<String> stream1 = stream
                .map(String::toLowerCase)
                .map(String::toUpperCase)
                .map((value) -> { return value.substring(0,3); });

        System.out.println (Arrays.toString (stream1.toArray ()));*/
/*
        System.out.println("count = " + count);*/
       /* List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.stream (split);
        })
                .forEach(System.out::println)
        ;
*/
        List<String> stringList = new ArrayList<String>();

        stringList.add("abc");
        stringList.add("def");
        stringList.add("dev");

        Stream<String> stream = stringList.stream();

        Optional<String> max = stream.max((val1, val2) -> {
            return val1.compareTo(val2);
        });

        String maxString = max.get();

        System.out.println(maxString);
    }
}