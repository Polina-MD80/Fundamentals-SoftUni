import java.util.Scanner;

public
class EasterCake {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        double budget = Double.parseDouble (scanner.nextLine ());
        double flowerPrice = Double.parseDouble (scanner.nextLine ());

        double pricePerCake = flowerPrice + 0.75*flowerPrice +0.25*(flowerPrice*1.25);

        int colouredEggs = 0;
        int cakes = 0;

        while (budget-pricePerCake>=0){
            budget -= pricePerCake;
            cakes++;
            colouredEggs += 3;

            if (cakes%3 == 0){
                colouredEggs-=(cakes-2);
            }
        }
        System.out.printf ("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",cakes,colouredEggs,budget);

    }
}
