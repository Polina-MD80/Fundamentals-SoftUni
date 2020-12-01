import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class LegendaryFarming {
    public static
    void main (String[] args) {
        Scanner              scanner     = new Scanner (System.in);
        String               input       = scanner.nextLine ();
        Map<String, Integer> neededItems = new LinkedHashMap<> ();
        Map<String, Integer> junkItems   = new LinkedHashMap<> ();
        //Shards, Fragments and Motes
        neededItems.put ("shards", 0);
        neededItems.put ("fragments", 0);
        neededItems.put ("motes", 0);
        boolean isObtained = false;
        while (!isObtained) {
            String[] tokens = input.split (" ");
            for (int i = 0; i < tokens.length; i += 2) {
                int    quantity = Integer.parseInt (tokens[i]);
                String item     = tokens[i + 1].toLowerCase ();
                if (neededItems.containsKey (item)) {
                    int newQuantity = neededItems.get (item) + quantity;
                    if (newQuantity < 250) {
                        neededItems.put (item, newQuantity);
                    } else {
                        neededItems.put (item, newQuantity - 250);
                        isObtained = true;
                        switch (item) {
                            case "shards":
                                System.out.println ("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println ("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println ("Dragonwrath obtained!");
                                break;
                        }break;

                    }

                } else {
                    junkItems.putIfAbsent (item, 0);
                    int newQuantity = junkItems.get (item) + quantity;
                    junkItems.put (item, newQuantity);
                }
            }if (isObtained){
                break;
            }
            input = scanner.nextLine();
        }neededItems
                .entrySet ()
                .stream ()
                .sorted ((e1, e2) -> {
                    int result = e2.getValue ().compareTo (e1.getValue ());
                    if (result == 0) {
                        result = e1.getKey ().compareTo (e2.getKey ());
                    }
                    return result;
                })
                .forEach (i -> System.out.printf ("%s: %d%n", i.getKey (), i.getValue ()));
        junkItems
                .entrySet ()
                .stream ()
                .sorted ((e1, e2) -> e1.getKey ().compareTo (e2.getKey ()))
                .forEach (e -> System.out.printf ("%s: %d%n", e.getKey (), e.getValue ()));


    }
}
