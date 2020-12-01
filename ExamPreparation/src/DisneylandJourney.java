import java.util.Scanner;

public
class DisneylandJourney {
    public static
    void main (String[] args) {
        Scanner scanner     = new Scanner (System.in);
        double  neededMoney = Double.parseDouble (scanner.nextLine ());
        int     months      = Integer.parseInt (scanner.nextLine ());
        double  sum         = 0.25*neededMoney;

        for (int i = 2; i <= months; i++) {
            if (i % 2 != 0) {
                sum = sum - 0.16 * sum;
            }
            if (i%4==0){
                sum = sum + 0.25*sum;
            }
            sum = sum + 0.25*neededMoney;
        }
        double diff = sum - neededMoney;
        if (diff>=0){
            System.out.printf ("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", diff);
        }else {
            System.out.printf ("Sorry. You need %.2flv. more.", Math.abs (diff));
        }
    }
}
