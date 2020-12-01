import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class StarEnigma {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String regex = "[^@\\-!:>]*@(?<planet>[A-Z][a-z]+)[^@\\-\\!\\:\\>]*\\:(?<population>\\d+)[^@\\-\\!\\:\\>]*!(?<attack>[AD])![^@\\-\\!\\:\\>]*->(?<soldiers>\\d+)[^@\\-\\!\\:\\>]*";
        Pattern pattern = Pattern.compile (regex);
        int n = Integer.parseInt (scanner.nextLine ());
        int attacked = 0;
        List<String> attackedPlanets = new ArrayList<> ();
        List<String> destroyedPlanets = new ArrayList<> ();
        int destroyed = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine ();
            String input = line.toLowerCase ();
            int key = 0;
            for (int j = 0; j < input.length (); j++) {
                if (input.charAt (j)=='s'||input.charAt (j)=='t'||input.charAt (j)=='a'||input.charAt (j)=='r'){
                    key++;
                }

            }
            StringBuilder message = new StringBuilder ();
            for (int j = 0; j < line.length (); j++) {
                message.append ((char)(line.charAt (j)-key));
            }
            input = message.toString ();
            Matcher matcher = pattern.matcher (input);


            while (matcher.find ()){
                if (matcher.group ("attack").equals ("A")){
                    attacked++;
                    attackedPlanets.add (matcher.group ("planet"));
                }else if (matcher.group ("attack").equals ("D")){
                    destroyed++;
                    destroyedPlanets.add (matcher.group ("planet"));
                }

            }

        }
        Collections.sort (attackedPlanets);
        Collections.sort (destroyedPlanets);
        System.out.println ("Attacked planets: "+attacked);
        for (String attackedPlanet : attackedPlanets) {
            System.out.println ("-> "+ attackedPlanet);
        }
        System.out.println ("Destroyed planets: "+destroyed);
        for (String destroyedPlanet : destroyedPlanets) {
            System.out.println ("-> "+destroyedPlanet);
        }
    }
}
