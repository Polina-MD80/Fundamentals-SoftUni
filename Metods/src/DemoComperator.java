import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

class DemoComperator {
    public static void main(String[] args) {

        Map<String, Integer> stringIntegerMap = new LinkedHashMap<> ();

        stringIntegerMap.put("hotel", 5);
        stringIntegerMap.put("bravo", 5);
        stringIntegerMap.put("siera", 3);

        stringIntegerMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%s: %d%n", entry.getKey (),entry.getValue ()));




    }
}