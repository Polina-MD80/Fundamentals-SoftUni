import java.util.*;

public
class Problem {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        Map<String, List<String>> users = new TreeMap<> ();

        String command = scanner.nextLine ();

        while (!"Statistics".equals (command)){
            String[] tokens = command.split ("->");
            String name = tokens[1];
            switch (tokens[0]){
                case "Add":
                    if (users.containsKey (name)){
                        System.out.printf ("%s is already registered%n", name);
                    }else {
                        users.put (name,new ArrayList<> ());
                    }
                    break;
                case "Send":
                    if (users.containsKey (name)){
                        users.get (name).add (tokens[2]);
                    }
                    break;
                case "Delete":
                    if (!users.containsKey (name)){
                        System.out.printf ("%s not found!%n",name);
                    }else {
                        users.remove (name);
                    }
                    break;
            }

            command = scanner.nextLine ();
        }
        System.out.printf ("Users count: %d%n", users.size ());
        users.entrySet ().stream ().sorted ((f,s)->Integer.compare (s.getValue ().size (),f.getValue ().size ()))
                .forEach (e->{
                    System.out.println (e.getKey ());
                    e.getValue ().forEach (v-> System.out.printf (" - %s%n",v));
                });
    }
}
