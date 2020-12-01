import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class HelloFrance {
    public static
    void main (String[] args) {
        Scanner  scanner     = new Scanner (System.in);
        String[] items       = scanner.nextLine ().split ("\\|");
        double   budget      = Double.parseDouble (scanner.nextLine ());
        double   neededMoney = 150;
        double   profit      = 0;
        double   soldItems   = 0;
        List<Double> newPrices = new ArrayList<> ();


        for (int i = 0; i < items.length; i++) {
            String[] tokens       = items[i].split ("->");
            double   pricePerItem = Double.parseDouble (tokens[1]);
            if ((tokens[0].equals ("Clothes") && pricePerItem > 50.00) ||
                (tokens[0].equals ("Shoes") && pricePerItem > 35.00) ||
                (tokens[0].equals ("Accessories") && pricePerItem > 20.50) || (budget - pricePerItem < 0)) {
                continue;
            }
            budget -= pricePerItem;
            double newPricePerItem = pricePerItem + pricePerItem * 0.4;
            newPrices.add (newPricePerItem);
            soldItems += newPricePerItem;
            profit = profit + pricePerItem * 0.4;

        }

        for (int i = 0; i < newPrices.size (); i++) {
            System.out.printf ("%.2f",newPrices.get (i));
            if (i!=newPrices.size ()-1){
                System.out.print (" ");
            }
        }
        System.out.println ();
        System.out.printf ("Profit: %.2f%n", profit);
        budget = budget + soldItems;
        if (budget >= neededMoney) {
            System.out.println ("Hello, France!");
        } else System.out.println ("Time to go.");

    }
}