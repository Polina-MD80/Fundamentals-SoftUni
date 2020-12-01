import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class LogicHeroesOfCodeAndLogic {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        Map<String, int[]> heroes = new TreeMap<> ();
        int n = Integer.parseInt (scanner.nextLine ());
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine ().split (" ");
            String name = parts[0];
            int hp = Integer.parseInt (parts[1]);
            int mp = Integer.parseInt (parts[2]);
            int[] status = new int[]{hp,mp};
            heroes.put (name,status);
        }

        String command = scanner.nextLine ();
        while (!"End".equals (command)){
            String[] tokens = command.split ("\\s-\\s");
            switch (tokens[0]){
                case "CastSpell":
                    castSpell(heroes,tokens);
                    break;
                case "TakeDamage":
                    takeDamage(heroes,tokens);
                    break;
                case "Recharge":
                    recharge(heroes,tokens);
                    break;
                case "Heal":
                    heal(heroes,tokens);
                    break;
            }


            command = scanner.nextLine ();
        }

        heroes.entrySet ().stream ().sorted ((h1,h2)->Integer.compare (h2.getValue ()[0],h1.getValue ()[0]))
                .forEach (h->{
                    System.out.printf ("%s%n  HP: %d%n  MP: %d%n", h.getKey (),h.getValue ()[0],h.getValue ()[1]);
                });

    }

    private static
    void heal (Map<String,int[]> heroes, String[] tokens) {
        //Heal – {hero name} – {amount}
        //•	The hero increases his HP. If a command is given that would bring the HP of the hero above 100,
        // HP is increased so that it reaches the maximum. Print the following message:
        //o	"{hero name} healed for {amount recovered} HP!"
        String heroName = tokens[1];
        int addHP = Integer.parseInt (tokens[2]);

        heroes.get (heroName)[0] += addHP;
        if (heroes.get (heroName)[0]>100){
            addHP = addHP - (heroes.get (heroName)[0] - 100);
            heroes.get (heroName)[0] = 100;
        }
        System.out.printf ("%s healed for %d HP!%n", heroName, addHP);

    }

    private static
    void recharge (Map<String,int[]> heroes, String[] tokens) {

        String heroName = tokens[1];
        int addMP = Integer.parseInt (tokens[2]);
        heroes.get (heroName)[1]+=addMP;
        if (heroes.get (heroName)[1]>200){
            addMP = addMP - (heroes.get (heroName)[1]-200);
            heroes.get (heroName)[1]=200;
        }
        System.out.printf ("%s recharged for %d MP!%n",heroName,addMP);

    }

    private static
    void takeDamage (Map<String,int[]> heroes, String[] tokens) {

        String heroName = tokens[1];
        int damageHP = Integer.parseInt (tokens[2]);
        String attacker = tokens[3];
        heroes.get (heroName)[0]-= damageHP;
        if (heroes.get (heroName)[0]<=0){
            System.out.printf ("%s has been killed by %s!%n", heroName, attacker);
            heroes.remove (heroName);
        }else {
            System.out.printf ("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damageHP, attacker, heroes.get (heroName)[0]);
        }
    }

    private static
    void castSpell (Map<String,int[]> heroes, String[] tokens) {
        String heroName = tokens[1];
        int neededMP = Integer.parseInt (tokens[2]);
        String spellName = tokens[3];
        if (heroes.get (heroName)[1]<neededMP){
            System.out.printf ("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }else {
            heroes.get (heroName)[1]-=neededMP;
            System.out.printf ("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,heroes.get (heroName)[1]);
        }
    }
}
