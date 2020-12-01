import java.util.Scanner;

public
class ManOWar {
    public static
    void main (String[] args) {
        Scanner  scanner      = new Scanner (System.in);
        String[] pirateInput  = scanner.nextLine ().split (">");
        String[] warShipInput = scanner.nextLine ().split (">");
        int      capacity     = Integer.parseInt (scanner.nextLine ());

        int[] pirateHealth  = new int[pirateInput.length];
        int[] warshipHealth = new int[warShipInput.length];
        pirateHealth = readIntFromStringArray (pirateInput);
        warshipHealth = readIntFromStringArray (warShipInput);

        String command = scanner.nextLine ();
        while (!"Retire".equals (command)) {
            String[] tokens = command.split (" ");
            switch (tokens[0]) {
                case "Fire":
                    if (fire (warshipHealth, tokens)) return;
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt (tokens[1]);
                    int endIndex = Integer.parseInt (tokens[2]);
                    if (startIndex >= 0 && startIndex < pirateHealth.length && endIndex >= 0 && endIndex < pirateHealth.length) {
                        int damage = Integer.parseInt (tokens[3]);
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateHealth[i] = pirateHealth[i] - damage;
                            if (pirateHealth[i] <= 0) {
                                System.out.println ("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt (tokens[1]);
                    if (indexToRepair >= 0 && indexToRepair < pirateHealth.length) {
                        int health = Integer.parseInt (tokens[2]);
                        pirateHealth[indexToRepair] = pirateHealth[indexToRepair] + health;
                        if (pirateHealth[indexToRepair] > capacity) {
                            pirateHealth[indexToRepair] = capacity;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateHealth.length; i++) {
                        double percent = 100.0*pirateHealth[i]/capacity;
                        if (percent<20){
                            count++;
                        }
                    }
                    System.out.printf ("%d sections need repair.%n", count);
                    break;
            }


            command = scanner.nextLine ();
        }
        int pirateSum = 0;
        for (int i = 0; i < pirateHealth.length; i++) {
            pirateSum += pirateHealth[i];
        }
        System.out.printf ("Pirate ship status: %d%n", pirateSum);
        int warshipSum = 0;
        for (int i = 0; i < warshipHealth.length; i++) {
            warshipSum += warshipHealth[i];
        }
        System.out.printf ("Warship status: %d", warshipSum);

    }

    private static
    boolean fire (int[] warshipHealth, String[] tokens) {
        int indexToFire = Integer.parseInt (tokens[1]);
        if (indexToFire >= 0 && indexToFire < warshipHealth.length) {
            int damage = Integer.parseInt (tokens[2]);
            warshipHealth[indexToFire] = warshipHealth[indexToFire] - damage;
            if (warshipHealth[indexToFire] <= 0) {
                System.out.println ("You won! The enemy ship has sunken.");
                return true;
            }
        }
        return false;
    }

    private static
    int[] readIntFromStringArray (String[] text) {
        int[] intArray = new int[text.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt (text[i]);
        }
        return intArray;
    }
}
