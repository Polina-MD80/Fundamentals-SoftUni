import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class AssociativeArrays {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] input = scanner.nextLine ().split (" ");
        Map<Double,Integer> elements = new TreeMap<> ();
        for (String s : input) {
            Double element = Double.parseDouble (s);
            if (elements.containsKey (element)) {
                Integer count = elements.get (element);
                elements.put (element, count + 1);
            } else {
                elements.put (element, 1);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat ("#.#######");
        for (Map.Entry<Double,Integer> entry : elements.entrySet ()) {
            System.out.printf ("%s -> %d%n", decimalFormat.format (entry.getKey ()),entry.getValue ());

        }
    }
}
