import java.util.Scanner;

public
class BlackFlag {
    public static
    void main (String[] args) {
        Scanner scanner       = new Scanner (System.in);
        int     days          = Integer.parseInt (scanner.nextLine ());
        int     dailyPlunder  = Integer.parseInt (scanner.nextLine ());
        double  targetPlunder = Double.parseDouble (scanner.nextLine ());


        double plunder = 0;

        int i = 1;
        while (i<=days){
            plunder = plunder + dailyPlunder;
            if (i%3==0){
                plunder = plunder + dailyPlunder/2.0;
            }
            if (i%5==0){
                plunder = plunder - 0.3*plunder;
            }
            i++;
        }
        if (plunder>=targetPlunder){
            System.out.printf ("Ahoy! %.2f plunder gained.", plunder);
        }else {
            double percent = plunder/targetPlunder*100.0;
            System.out.printf ("Collected only %.2f%% of the plunder.", percent);
        }



    }
}
