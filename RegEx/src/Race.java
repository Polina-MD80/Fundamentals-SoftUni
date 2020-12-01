import java.util.*;
import java.util.stream.Collectors;

public
class Race {
    public static
    void main (String[] args) {
        Scanner              scanner     = new Scanner (System.in);
        List<String>         namesInList = Arrays.stream (scanner.nextLine ().split (", ")).collect (Collectors.toList ());
        Map<String, Integer> competitors = new LinkedHashMap<> ();
        for (int i = 0; i < namesInList.size (); i++) {
            competitors.putIfAbsent (namesInList.get (i), 0);
        }
        String line = scanner.nextLine ();
        while (!"end of race".equals (line)) {
            String name   = "";
            int    points = 0;
            for (int i = 0; i < line.length (); i++) {
                if (Character.isAlphabetic (line.charAt (i))) {
                    name += "" + line.charAt (i);
                }
                if (Character.isDigit (line.charAt (i))) {
                    points += Integer.parseInt ("" + line.charAt (i));
                }
            }
            if (competitors.containsKey (name)) {
                competitors.put (name, competitors.get (name) + points);
            }

            line = scanner.nextLine ();
        }
        List<String>output = new ArrayList<> ();
        output.add ("1st place: ");
        output.add ("2nd place: ");
        output.add ("3rd place: ");
        competitors
                .entrySet ()
                .stream ()
                .sorted ((c1,c2)->c2.getValue ().compareTo (c1.getValue ()))
                .limit (3)
                .forEach (c->{
                    System.out.println (output.remove (0)+c.getKey ());
                });




    }
}
