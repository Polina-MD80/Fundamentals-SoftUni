import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class NetherRealms {


    public static
    void main (String[] args) {
        Scanner               scanner   = new Scanner (System.in);
        String[]              input     = scanner.nextLine ().split (",\\s*");
        Map<String, double[]> demonsMap = new TreeMap<> ();

        for (int i = 0; i < input.length; i++) {

            String name = input[i].trim ().replaceAll ("\\s+","");
            if (name.length ()==0){
                continue;
            }
            int           health         = 0;
            double        damage         = 0;
            Pattern       healthPattern  = Pattern.compile ("[^\\d\\-+*/.]");
            Matcher       healthAdditive = healthPattern.matcher (name);
            Pattern       damagePattern  = Pattern.compile ("(-?\\d+(\\.\\d+)*)");
            Matcher       damageAdditive = damagePattern.matcher (name);
            StringBuilder healthString   = new StringBuilder ();

            while (healthAdditive.find ()) {
                healthString.append (healthAdditive.group ());
            }
            for (int j = 0; j < healthString.length (); j++) {
                health += healthString.charAt (j);
            }
            while (damageAdditive.find ()) {
                damage+=Double.parseDouble (damageAdditive.group ());
            }

            for (int j = 0; j < name.length (); j++) {
                if (name.charAt (j) == '/') {
                    damage = damage / 2;
                } else if (name.charAt (j) == '*') {
                    damage = damage * 2;
                }
            }
            double[] healthDamage = new double[]{health, damage};

            demonsMap.put (name, healthDamage);
        }
        for (Map.Entry<String, double[]> entry : demonsMap.entrySet()) {
            System.out.printf("%s - %d health, %.2f damage%n",
                    entry.getKey(), (int)entry.getValue()[0], entry.getValue()[1]);
        }
    }
}
