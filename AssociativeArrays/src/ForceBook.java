import java.util.*;

public
class ForceBook {
    public static
    void main (String[] args) {
        Scanner                   scanner = new Scanner (System.in);
        String                    line    = scanner.nextLine ();
        Map<String, List<String>> sides   = new TreeMap<> ();

        while (!"Lumpawaroo".equals (line)) {
            String[] input = line.split ("\\s+");
            String   side  = "";
            String   name  = "";
            for (String s : input) {
                if (s.equals ("|")) {
                    String[] tokens = splitByDash (line);
                    side = tokens[0];
                    name = tokens[1];
                    //sides.putIfAbsent (side, new ArrayList<> ());
                    //if (!sides.get (side).contains (name)) {
                       // sides.get (side).add (name);
                    //}
                    Boolean nameExists = false;
                   for( Map.Entry<String, List<String>> currant : sides.entrySet () ){
                       if (currant.getValue().contains(name)) {
                           nameExists = true;
                           break;
                       }
                   }
                   if (!nameExists){
                       sides.putIfAbsent (side, new ArrayList<> ());
                       sides.get (side).add (name);
                   }


                } else if (s.equals ("->")) {
                    String[] tokens = splitByArrow (line);
                    side = tokens[1];
                    name = tokens[0];
                    sides.putIfAbsent (side, new ArrayList<> ());
                    String finalName = name;
                    if (!sides.get (side).contains (name)) {
                        sides
                                .entrySet ()
                                .forEach ((k) -> {
                                    k.getValue ().remove (finalName);
                                });
                        sides.get (side).add (name);
                        System.out.printf ("%s joins the %s side!%n", name, side);
                    }
                }
            }
            line = scanner.nextLine ();

        }
        sides
                .entrySet ()
                .stream ()
                .filter (s -> s.getValue ().size () > 0)
                .sorted ((s1, s2) -> Integer.compare (s2.getValue ().size (), s1.getValue ().size ()))
                .forEach (s -> {
                    System.out.printf ("Side: %s, Members: %d%n", s.getKey (), s.getValue ().size ());
                    s.getValue ()
                            .stream ()
                            .sorted (String::compareTo)
                            .forEach (k -> System.out.printf ("! %s%n", k));

                });
    }

    private static
    String[] splitByArrow (String line) {
        String[] tokens = line.split (" -> ");
        return tokens;
    }

    private static
    String[] splitByDash (String line) {
        String[] tokens = line.split (" \\| ");
        return tokens;
    }
}
