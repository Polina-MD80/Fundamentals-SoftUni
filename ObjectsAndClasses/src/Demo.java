import java.util.Random;

public
class Demo {

    public static
    void main (String[] args) {
       // Random rand = new Random ();
        // System.out.println (rand.nextInt (11)+5);
        //System.out.println (rand.nextInt (11)+5);
        //System.out.println (rand.nextInt (11)+5);
        //System.out.println (rand.nextInt (11)+5);
        Dice dice = new Dice (2);
        Dice d2 = new Dice (2);


        dice.setSides (6);
        dice.setSides (7);
        d2.setSides (4);
        System.out.println (dice.roll ());
        System.out.println (d2.roll ());

    }
}
