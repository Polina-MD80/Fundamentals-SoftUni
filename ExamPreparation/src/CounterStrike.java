import java.util.Scanner;

public
class CounterStrike {

    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int energy = Integer.parseInt (scanner.nextLine ());
        String input = scanner.nextLine ();
        int wonBattles = 0;

        while (!"End of battle".equals (input)){

            int distanceToEnemy = Integer.parseInt (input);
            energy= energy - distanceToEnemy;

            if (energy>=0){
                wonBattles++;
                if (wonBattles%3==0){
                    energy+=wonBattles;
                }
            }else {System.out.printf ("Not enough energy! " +
                                     "Game ends with %d won battles and %d energy",
                    wonBattles,energy+distanceToEnemy);return;}

            input = scanner.nextLine ();
        }
        System.out.printf ("Won battles: %d. Energy left: %d", wonBattles,energy);
    }
}
