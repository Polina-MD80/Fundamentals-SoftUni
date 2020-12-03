import java.util.*;

public
class PlantDiscovery {
    public static
    void main (String[] args) {
        Scanner               scanner   = new Scanner (System.in);
        int                   n         = Integer.parseInt (scanner.nextLine ());
        Map<String, double[]> plantInfo = new LinkedHashMap<> ();
        for (int i = 0; i < n; i++) {
            String[] info       = scanner.nextLine ().split ("<->");
            double[] parameters = new double[]{0.0, 0.0};
            String   plantName  = info[0].trim ();
            plantInfo.putIfAbsent (plantName, parameters);
            plantInfo.get (plantName)[0] = Double.parseDouble (info[1].trim ());
        }
        String                    command = scanner.nextLine ();
        Map<String, List<Double>> ratings = new LinkedHashMap<> ();
        while (!"Exhibition".equals (command)) {
            String[] tokens = command.split ("\\s+");
            if (!plantInfo.containsKey (tokens[1].trim ())){
                System.out.println ("error");
                command = scanner.nextLine ();
                continue;
            }
            switch (tokens[0]) {
                case "Rate:":
                    rate (ratings, tokens);
                    break;
                case "Update:":
                    update (plantInfo, tokens);
                    break;
                case "Reset:":
                    reset (ratings, tokens);
                    break;
                default:
                    System.out.println ("error");
            }
            command = scanner.nextLine ();
        }
        ratings.forEach ((key, value) -> {
            for (String s : plantInfo.keySet ()) {
                if (key.equals (s) && value.size () > 0) {
                    plantInfo.get (s)[1] = value.stream ().mapToDouble (Double::doubleValue).average ().orElseThrow ();
                }
            }
        });
        System.out.println ("Plants for the exhibition:");
        plantInfo.entrySet ().stream ().sorted ((f,s)-> Double.compare (s.getValue ()[1],f.getValue ()[1]))
                .sorted ((f,s)-> Double.compare (s.getValue ()[0],f.getValue ()[0]))
                .forEach (e-> System.out.printf ("- %s; Rarity: %.0f; Rating: %.2f%n", e.getKey (),e.getValue ()[0],e.getValue ()[1]));



    }

    private static
    void reset (Map<String, List<Double>> ratings, String[] tokens) {
        ratings.get (tokens[1]).clear ();
    }


    private static
    void update (Map<String, double[]> plantInfo, String[] tokens) {
        plantInfo.get (tokens[1])[0] = Double.parseDouble (tokens[3].trim ());
    }

    private static
    void rate (Map<String, List<Double>> ratings, String[] tokens) {
        ratings.putIfAbsent (tokens[1], new ArrayList<> ());
        ratings.get (tokens[1]).add (Double.parseDouble (tokens[3].trim ()));
    }
}
