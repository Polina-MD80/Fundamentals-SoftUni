import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public
class OrdersWithTwoMaps {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, Double>  priceList  = new LinkedHashMap<> ();
        Map<String, Integer> quantities = new LinkedHashMap<> ();

        String input = scanner.nextLine ();
        while (!"buy".equals (input)) {
            String[] tokens = input.split ("\\s+");
            String item = tokens[0];
            double price = Double.parseDouble (tokens[1]);
            int quantity = Integer.parseInt (tokens[2]);

            priceList.put (item,price);
            quantities.putIfAbsent (item,0);
            int newQuantity = quantities.get (item)+quantity;
            quantities.put (item,newQuantity);

            input = scanner.nextLine ();
        }
        priceList
                .forEach ((k,v)->System.out.printf
                        ("%s -> %.2f%n",k, v * quantities.get (k)));
    }
}
