import java.util.Scanner;

public
class Pirates {
    public static
    void main (String[] args) {
        Scanner scanner       = new Scanner (System.in);
        int     days          = Integer.parseInt (scanner.nextLine ());
        double  plunderPerDay = Integer.parseInt (scanner.nextLine ());
        double  targetPlunder = Double.parseDouble (scanner.nextLine ());

        double gainedPlunder = 0;

        for (int i = 1; i <= days; i++) {
            gainedPlunder += plunderPerDay;
            if (i % 3 == 0) {
                gainedPlunder += plunderPerDay / 2;
            }
            if (i % 5 == 0) {
                gainedPlunder = gainedPlunder * 0.7;
            }
        }
        if (gainedPlunder >= targetPlunder) {
            System.out.printf ("Ahoy! %.2f plunder gained.", gainedPlunder);
        } else {
            System.out.printf ("Collected only %.2f%% of the plunder.", 100 * gainedPlunder / targetPlunder);
        }
    }
}
