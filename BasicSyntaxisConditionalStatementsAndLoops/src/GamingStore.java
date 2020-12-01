import java.util.Scanner;

public
class GamingStore {
    public static
    void main (String[] args) {
        Scanner scanner        = new Scanner (System.in);
        double  currantBalance = Double.parseDouble (scanner.nextLine ());
        String[] gamesInList = {"OutFall 4", "CS: OG", "Zplinter Zell",
                "Honored 2", "RoverWatch", "RoverWatch Origins Edition"};
        double[] pricePerGame = {39.99, 15.99, 19.99, 59.99, 29.99, 39.99};

        String wantedGame = scanner.nextLine ();
        double spentMoney =0;

        while (!wantedGame.equals ("Game Time")) {


            for (int i = 0; i < gamesInList.length; i++) {
                if (wantedGame.equals (gamesInList[i])) {

                    if (currantBalance >= pricePerGame[i]) {
                        currantBalance = currantBalance - pricePerGame[i];
                        spentMoney = spentMoney + pricePerGame[i];
                        System.out.println ("Bought " + wantedGame);
                        break;

                    } else {
                        System.out.println ("Too Expensive");break;
                    }
                } else if (i == gamesInList.length - 1) {
                    System.out.println ("Not Found");
                }

            }
            if (currantBalance == 0) {
                System.out.println ("Out of money!");
                return;
            }

            wantedGame = scanner.nextLine ();
        }
        System.out.printf ("Total spent: $%.2f. Remaining: $%.2f", spentMoney,currantBalance);
    }
}
