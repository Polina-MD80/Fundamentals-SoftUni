import java.util.Scanner;

public
class MuOnline {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] rooms    = scanner.nextLine ().split ("\\|");
        int      health   = 100;
        int      bitcoins = 0;

        for (int i = 0; i < rooms.length; i++) {
            String[] command = rooms[i].split ("\\s+");
            String   action  = command[0];
            int      number  = Integer.parseInt (command[1]);

            switch (action) {
                case "potion":
                    health = potionCalculation (health, number);
                    break;
                case "chest":
                    bitcoins = chestActions (bitcoins, number);
                    break;
                default:
                    health = slayedAction (action, health, i, number);
                    if (health<=0){
                        return;
                    }

            }

        }

            System.out.printf ("You've made it!%nBitcoins: %d%nHealth: %d%n", bitcoins, health);
    }

    private static
    int slayedAction (String action, int health, int i, int number) {
        health -= number;
        if (health > 0) {
            System.out.printf ("You slayed %s.%n", action);
        } else {
            System.out.printf ("You died! Killed by %s.%n", action);
            System.out.printf ("Best room: %d%n", i + 1);

        }
        return health;
    }

    private static
    int chestActions (int bitcoins, int number) {
        bitcoins += number;
        System.out.printf ("You found %d bitcoins.%n", number);
        return bitcoins;
    }

    private static
    int potionCalculation (int health, int number) {

        if (health + number <= 100) {
            health+=number;
            System.out.printf ("You healed for %d hp.%n", number);
            System.out.printf ("Current health: %d hp.%n", health);
        } else {
           number = 100 - health;
            health = 100;
            System.out.printf ("You healed for %d hp.%n", number);
            System.out.println ("Current health: 100 hp.");
        }
        return health;
    }
}
