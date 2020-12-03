import java.util.*;

public
class PlantDiscovery2 {
    private static
    class Plant {
        String name;
        int rarity;
        List<Double> ratings;

        public
        Plant (String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<> ();
        }

        public
        String getName () {
            return name;
        }

        public
        int getRarity () {
            return rarity;
        }

        public
        void setRarity (int rarity) {
            this.rarity = rarity;
        }

        public
        void addRating (double rating) {
            this.ratings.add (rating);
        }

        public
        void clearRatings () {
            this.ratings.clear ();
        }

        private
        double getAverage (List<Double> numbs) {
            double result = 0.0;
            if (numbs.isEmpty ()) {
                return result;
            } else {
                double sum = 0;
                for (Double num : numbs) {
                    sum += num;
                }
                result = sum / numbs.size ();
            }
            return result;
        }

        @Override
        public
        String toString () {
            return String.format ("- %s; Rarity: %d; Rating: %.2f", this.name, this.rarity, getAverage (this.ratings));
        }
    }

    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int                n              = Integer.parseInt (scanner.nextLine ());
        Map<String, Plant> plantsByRarity = new HashMap<> ();

        for (int i = 0; i < n; i++) {
            String[] plantRarity = scanner.nextLine ().split ("<->");
            String   name        = plantRarity[0];
            int      rarity      = Integer.parseInt (plantRarity[1]);
            Plant    plant       = new Plant (name, rarity);
            plantsByRarity.put (plant.getName (), plant);
        }

        String command = scanner.nextLine ();

        while (!"Exhibition".equals (command)) {
            String[] tokens = command.split ("\\s+");
            if (!plantsByRarity.containsKey (tokens[1])) {
                System.out.println ("error");
                command = scanner.nextLine ();
                continue;
            }
            switch (tokens[0]) {
                case "Rate:":
                    double rating = Double.parseDouble (tokens[3]);
                    plantsByRarity.get (tokens[1]).addRating (rating);
                    break;
                case "Update:":
                    plantsByRarity.get (tokens[1]).setRarity (Integer.parseInt (tokens[3]));
                    break;
                case "Reset:":
                    plantsByRarity.get (tokens[1]).clearRatings ();
                    break;
                default:
                    System.out.println ("error");
            }
            command = scanner.nextLine ();
        }
        System.out.println ("Plants for the exhibition:");
        plantsByRarity.entrySet ().stream ()
                .sorted ((f, s) -> Double.compare (s.getValue ().getAverage (s.getValue ().ratings), f.getValue ().getAverage (f.getValue ().ratings)))
                .sorted ((f, s) -> Integer.compare (s.getValue ().rarity, f.getValue ().rarity))
                //.forEach (entry -> System.out.printf ("- %s; Rarity: %d; Rating: %.2f%n",entry.getValue ().getName (),entry.getValue ().getRarity (),entry.getValue ().getAverage (entry.getValue ().ratings)));
                .forEach (entry -> System.out.println (entry.getValue ()));


    }
}
