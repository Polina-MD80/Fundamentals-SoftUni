import java.util.Scanner;

public
class Snowballs {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int snowBalls = Integer.parseInt (scanner.nextLine ());
        long maxValue = 0;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;

        for (int i = 0; i < snowBalls; i++) {
            int snowballSnow = Integer.parseInt (scanner.nextLine ());
            int snowballTime = Integer.parseInt (scanner.nextLine ());
            int snowballQuality = Integer.parseInt (scanner.nextLine ());
            int dividedSnow = snowballSnow/snowballTime;
            long snowballValue =(long) Math.pow (dividedSnow, snowballQuality);

            if (snowballValue>=maxValue){
                maxValue = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }

        }
        System.out.printf ("%d : %d = %d (%d)",maxSnow,maxTime,maxValue,maxQuality);


    }
}
