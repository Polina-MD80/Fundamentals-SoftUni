import java.util.*;

public
class DragonArmy {
    public static
    void main (String[] args) {
        Scanner                         scanner     = new Scanner (System.in);
        Map<String, Map<String, int[]>> dragonTypes = new LinkedHashMap<> ();
        int                             n           = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {
            String[] info       = scanner.nextLine ().split (" ");
            int[]    dragonInts = new int[]{45, 250, 10};
            //{type} {name} {damage} {health} {armor}.
            String type = info[0];
            String name = info[1];
            dragonTypes.putIfAbsent (type, new TreeMap<> ());
            dragonTypes.get (type).put (name, dragonInts);
            if (!info[2].equals ("null")) {
                dragonTypes.get (type).get (name)[0] = Integer.parseInt (info[2]);
            }
            if (!info[3].equals ("null")) {
                dragonTypes.get (type).get (name)[1] = Integer.parseInt (info[3]);
            }
            if (!info[4].equals ("null")) {
                dragonTypes.get (type).get (name)[2] = Integer.parseInt (info[4]);
            }
        }

        for (Map.Entry<String, Map<String, int[]>> type : dragonTypes.entrySet ()) {
            System.out.printf ("%s::(%.2f/%.2f/%.2f)%n", type.getKey (),
                    type.getValue ().values ().stream ().map (ints -> ints[0]).mapToDouble (i -> Double.parseDouble (i + "")).average ().orElseThrow (),
                    type.getValue ().values ().stream ().map (ints -> ints[1]).mapToDouble (i -> Double.parseDouble (i + "")).average ().orElseThrow (),
                    type.getValue ().values ().stream ().map (ints -> ints[2]).mapToDouble (i -> Double.parseDouble (i + "")).average ().orElseThrow ());

            for (Map.Entry<String, int[]> dragon : type.getValue ().entrySet ()) {
                System.out.printf ("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey (), dragon.getValue ()[0], dragon.getValue ()[1], dragon.getValue ()[2]);
            }
        }
    }
}

