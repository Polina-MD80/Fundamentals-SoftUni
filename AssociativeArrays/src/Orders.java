import java.util.*;

public
class Orders {
    public static
    void main (String[] args) {
        Scanner                   scanner = new Scanner (System.in);
        Map<String, List<Double>> order   = new LinkedHashMap<> ();
        String                    input   = scanner.nextLine ();
        while (!"buy".equals (input)) {
            String[]     tokens        = input.split (" ");
            String       item          = tokens[0];
            double       pricePerOne   = Double.parseDouble (tokens[1]);
            double       amount        = Double.parseDouble (tokens[2]);
            List<Double> productPrices = new ArrayList<> ();
            productPrices.add (0.0);
            productPrices.add (0.0);
            order.putIfAbsent (item, productPrices);
            order.get (item).set (0, pricePerOne);
            double temp = order.get (item).get (1);
            order.get (item).set (1, temp + amount);

            input = scanner.nextLine ();
        }
        for (Map.Entry<String, List<Double>> entry : order.entrySet ()) {
            entry.getValue ().set (0, entry.getValue ().get (0) * entry.getValue ().get (1));
            System.out.printf ("%s -> %.2f%n", entry.getKey (), entry.getValue ().get (0));

        }

    }
}
