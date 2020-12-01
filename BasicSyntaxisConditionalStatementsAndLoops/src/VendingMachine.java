import java.util.Scanner;

public
class VendingMachine {
    public static
    void main (String[] args) {
        Scanner scanner       = new Scanner (System.in);
        String  moneyInserted = scanner.nextLine ();
        double  totalInserted = 0;
        while (!moneyInserted.equals ("Start")) {
            double coins = Double.parseDouble (moneyInserted);
            //with 0.1, 0.2, 0.5, 1, and 2 coins.
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                totalInserted += coins;
            } else System.out.printf ("Cannot accept %.2f%n", coins);
            moneyInserted = scanner.nextLine ();

        }
        double beforeLast = 0;
        String beverage   = scanner.nextLine ();
        while (!beverage.equals ("End")) {
            beforeLast = totalInserted;
            switch (beverage) {
                //&quot;Nuts&quot;, &quot;Water&quot;, &quot;Crisps&quot;, &quot;Soda&quot;, &quot;Coke&quot;.
                case "Nuts":
                    totalInserted -= 2.0;
                    break;
                case "Water":
                    totalInserted -= 0.7;
                    break;
                case "Crisps":
                    totalInserted -= 1.5;
                    break;
                case "Soda":
                    totalInserted -= 0.8;
                    break;
                case "Coke":
                    totalInserted -= 1.0;
                    break;
                default:
                    System.out.println ("Invalid product");
                    beverage = scanner.nextLine ();
                    continue;
            }
            if (totalInserted >= 0) {
                System.out.printf ("Purchased %s%n", beverage);
            } else {
                System.out.println ("Sorry, not enough money");
                totalInserted = beforeLast;
            }


            beverage = scanner.nextLine ();
        }
        System.out.printf ("Change: %.2f", totalInserted);

    }
}
