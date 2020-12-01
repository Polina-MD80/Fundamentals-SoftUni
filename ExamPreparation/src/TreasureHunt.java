import java.util.*;

public
class TreasureHunt {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        List<String> loots   = new ArrayList<> ();
        String[]     input   = scanner.nextLine ().split ("\\|");
        for (int i = 0; i < input.length; i++) {
            loots.add (input[i]);
        }

        String command = scanner.nextLine ();

        while (!"Yohoho!".equals (command)) {
            String[] tokens = command.split (" ");
            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (loots.contains (tokens[i])) {
                            continue;
                        } else loots.add (0, tokens[i]);
                    }

                    break;
                case "Drop":
                    int indexToRemove = Integer.parseInt (tokens[1]);
                    if (indexToRemove >= 0 && indexToRemove < loots.size ()) {
                        String temp = loots.get (indexToRemove);
                        loots.remove (indexToRemove);
                        loots.add (temp);
                    }
                    break;
                case "Steal":
                    int itemsToSteal = Integer.parseInt (tokens[1]);
                    int minItemsToSteal = Math.min (loots.size (), itemsToSteal);
                    List<String> stolenItems = new ArrayList<> ();
                    for (int i = 1; i <= minItemsToSteal; i++) {
                        stolenItems.add (loots.get (loots.size ()-1));
                        loots.remove (loots.size ()-1);

                    }
                    Collections.reverse (stolenItems);
                    System.out.println (stolenItems.toString ().replaceAll ("[\\]\\[]", ""));

                    break;

            }

            command = scanner.nextLine ();
        }
        if (loots.size () == 0) {
            System.out.println ("Failed treasure hunt.");
        } else {
            int sum = 0;
            for (int i = 0; i < loots.size (); i++) {
                sum += loots.get (i).length ();
            }
            double average = 1.0 * sum / loots.size ();
            System.out.printf ("Average treasure gain: %.2f pirate credits.", average);

        }


    }
}
