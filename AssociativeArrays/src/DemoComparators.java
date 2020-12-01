import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

class DemoComparators {
    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = new LinkedHashMap<> ();

        stringIntegerMap.put("hotel", 5);
        stringIntegerMap.put("bravo", 5);
        stringIntegerMap.put("sierra", 3);
        stringIntegerMap.put ("delta", 6);
        stringIntegerMap.put ("charlie", 0);
        stringIntegerMap.put ("alpha", 0);

        stringIntegerMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey (),entry.getValue ()));




    }
}