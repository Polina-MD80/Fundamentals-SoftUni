import java.util.Scanner;

public
class WaterTank {
    public static
    void main (String[] args) {
        Scanner scanner       = new Scanner (System.in);
        int     n             = Integer.parseInt (scanner.nextLine ());
        int     capacity      = 255;
        int     poweredLiters = 0;
        for (int i = 0; i < n; i++) {
            int litersToPower = Integer.parseInt (scanner.nextLine ());
            if (litersToPower + poweredLiters <= capacity) {
                poweredLiters += litersToPower;
            } else {
                System.out.println ("Insufficient capacity!");
            }


        }
        System.out.println (poweredLiters);
    }
}
