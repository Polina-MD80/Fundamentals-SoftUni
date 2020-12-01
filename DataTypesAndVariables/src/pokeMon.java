import java.util.Scanner;

public
class pokeMon {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int powerN    = Integer.parseInt (scanner.nextLine ());
        int initialN  = powerN;
        int distanceM = Integer.parseInt (scanner.nextLine ());
        int reduceY   = Integer.parseInt (scanner.nextLine ());
        int pokes     = 0;

        while (powerN >= distanceM) {
            powerN -= distanceM;
            pokes++;
            if (powerN!=0&&initialN / powerN == 2 && initialN % powerN == 0) {
                if (powerN >= reduceY && reduceY != 0) {
                    powerN = powerN / reduceY;
                }
            }

        }
        System.out.println (powerN);
        System.out.println (pokes);
    }
}
