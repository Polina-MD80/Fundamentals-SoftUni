import java.util.Arrays;
import java.util.Scanner;

public
class HeartDelivery {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int[] houses = Arrays.stream (scanner.nextLine ().split ("@")).mapToInt (Integer::parseInt).toArray();

        int lastPosition = 0;

        String line = scanner.nextLine ();

        while (!"Love!".equals (line)){
             String[] command = line.split ("\\s+");
             int jumpLength = Integer.parseInt (command[1]);
             lastPosition = lastPosition+jumpLength;
             if (lastPosition>= houses.length){
                 lastPosition=0;
             }
             if (houses[lastPosition]>0){
                 houses[lastPosition]-=2;
                 if (houses[lastPosition]<=0){
                     System.out.printf ("Place %d has Valentine's day.%n",lastPosition);
                 }
             }else {
                 System.out.printf ("Place %d already had Valentine's day.%n",lastPosition);
             }
             line = scanner.nextLine ();

         }
        System.out.printf ("Cupid's last position was %d.%n",lastPosition);
         int failedCount = 0;
        for (int house : houses) {
            if (house>0){
                failedCount++;
            }
        }
        if (failedCount==0){
            System.out.println ("Mission was successful.");
        }else {
            System.out.printf ("Cupid has failed %d places.",failedCount);
        }
    }
}
