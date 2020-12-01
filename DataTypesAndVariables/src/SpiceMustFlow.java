import java.util.Scanner;

public
class SpiceMustFlow {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int yields = Integer.parseInt (scanner.nextLine ());

        int days = 0;
        int spice = 0;

        while (yields>=100){
            spice += yields;
            spice -=26;
            days++;
            yields -= 10;

        }

        spice = spice-Math.min (spice,26);
        System.out.println (days);
        System.out.println (spice);
    }
}
