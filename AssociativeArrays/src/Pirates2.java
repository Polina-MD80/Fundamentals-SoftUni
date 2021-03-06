import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class Pirates2 {
    public static
    void main (String[] args) {
        Scanner            scanner = new Scanner (System.in);
        String             line    = scanner.nextLine ();
        Map<String, int[]> towns   = new TreeMap<> ();

        setTowns (scanner, line, towns);

        String command = scanner.nextLine ();
        while (!"End".equals (command)) {
            String[] tokens = command.split ("=>");
            switch (tokens[0]) {
                case "Plunder":
                    plunder (towns, tokens);
                    break;
                case "Prosper":
                    prosper (towns, tokens);
            }
            command = scanner.nextLine ();
        }
        if (towns.isEmpty ()) {
            System.out.println ("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf ("Ahoy, Captain! There are %d wealthy settlements to go to:%n", towns.size ());
            towns.entrySet ().stream ().sorted ((e1, e2) -> {
                int first  = e2.getValue ()[1];
                int second = e1.getValue ()[1];
                return Integer.compare (first, second);
            }).forEach (e -> System.out.printf ("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey (), e.getValue ()[0], e.getValue ()[1]));
        }
    }

    private static
    void prosper (Map<String, int[]> towns, String[] tokens) {
        String townToProsper = tokens[1];
        int goldToAdd = Integer.parseInt (tokens[2].trim ());
        if (goldToAdd < 0) {
            System.out.println ("Gold added cannot be a negative number!");
        } else {
            towns.get (townToProsper)[1] += goldToAdd;
            System.out.printf ("%d gold added to the city treasury. %s now has %d gold.%n", goldToAdd, townToProsper, towns.get (townToProsper)[1]);
        }
    }

    private static
    void plunder (Map<String, int[]> towns, String[] tokens) {
        String townToPlunder = tokens[1];
        int people = Integer.parseInt (tokens[2].trim ());
        int gold = Integer.parseInt (tokens[3].trim ());
        System.out.printf ("%s plundered! %d gold stolen, %d citizens killed.%n", tokens[1], gold, people);
        towns.get (townToPlunder)[0] -= people;
        towns.get (townToPlunder)[1] -= gold;
        if (towns.get (townToPlunder)[0] == 0 || towns.get (townToPlunder)[1] == 0) {
            towns.remove (townToPlunder);
            System.out.printf ("%s has been wiped off the map!%n",townToPlunder);
        }
    }

    private static
    void setTowns (Scanner scanner, String line, Map<String, int[]> towns) {
        while (!"Sail".equals (line)) {
            String[] town           = line.split ("\\|\\|");
            String currantTown = town[0];
            int[]    populationGold = new int[]{Integer.parseInt (town[1].trim ()), Integer.parseInt (town[2].trim ())};
            towns.putIfAbsent (currantTown, new int[2]);
            towns.get (currantTown)[0]= towns.get (currantTown)[0] + populationGold[0];
            towns.get (currantTown)[1]= towns.get (currantTown)[1] + populationGold[1];

            line = scanner.nextLine ();
        }
    }
}

