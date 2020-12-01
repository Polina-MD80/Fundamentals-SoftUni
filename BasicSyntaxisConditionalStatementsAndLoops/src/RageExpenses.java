import java.util.Scanner;

public
class RageExpenses {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int    lostGames     = Integer.parseInt (scanner.nextLine ());
        double headSetPrice  = Double.parseDouble (scanner.nextLine ());
        double mousePrice    = Double.parseDouble (scanner.nextLine ());
        double keyboardPrice = Double.parseDouble (scanner.nextLine ());
        double displayPrice  = Double.parseDouble (scanner.nextLine ());

        double total = (lostGames / 2) * headSetPrice + (lostGames / 3) * mousePrice +
                       (lostGames / 6) * keyboardPrice + (lostGames / 12) * displayPrice;
        System.out.printf ("Rage expenses: %.2f lv.", total);

    }
}
