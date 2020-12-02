import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class ThePianist {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        Map<String,String[]> collection = new TreeMap<> ();
        for (int i = 0; i < n; i++) {
            String[] piece = scanner.nextLine ().split ("\\|");
            String[] info = new String[]{piece[1],piece[2]};
            collection.put (piece[0],info);
        }

        String command = scanner.nextLine ();

        while (!"Stop".equals (command)){
            String[] tokens = command.split ("\\|");
            switch (tokens[0]){
                case "Add":
                    if (collection.containsKey (tokens[1])){
                        System.out.printf ("%s is already in the collection!%n", tokens[1]);
                    }else {
                        collection.put (tokens[1],new String[2]);
                        collection.get (tokens[1])[0] = tokens[2];
                        collection.get (tokens[1])[1]=tokens[3];
                        System.out.printf ("%s by %s in %s added to the collection!%n", tokens[1],tokens[2],tokens[3]);
                    }
                    break;
                case "Remove":
                    if (collection.containsKey (tokens[1])){
                        collection.remove (tokens[1]);
                        System.out.printf ("Successfully removed %s!%n", tokens[1]);
                    }else {
                        System.out.printf ("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
                case "ChangeKey":
                    if (collection.containsKey (tokens[1])){
                        collection.get (tokens[1])[1] = tokens[2];
                        System.out.printf ("Changed the key of %s to %s!%n", tokens[1],tokens[2]);
                    }else {
                        System.out.printf ("Invalid operation! %s does not exist in the collection.%n", tokens[1]);
                    }
                    break;
            }


            command = scanner.nextLine ();
        }
        collection.entrySet ().stream ().sorted (Comparator.comparing (f -> f.getValue ()[0]))
                .sorted (Map.Entry.comparingByKey ())
                .forEach (p->System.out.printf ("%s -> Composer: %s, Key: %s%n",
                        p.getKey (),p.getValue ()[0],p.getValue ()[1]));

    }
}
