import java.util.Arrays;
import java.util.Scanner;

public
class CarRace {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        double[] array = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToDouble (Double::parseDouble).toArray ();
        double leftTime  = 0;
        double rightTime = 0;
        for (int i = 0; i < array.length / 2; i++) {
            leftTime = leftTime + array[i];
            rightTime = rightTime + array[array.length - 1 - i];
            if (array[i] == 0) {
                leftTime = leftTime * 0.8;
            }
            if (array[array.length - 1 - i] == 0) {
                rightTime = rightTime * 0.8;
            }
        }
        if (leftTime <= rightTime) {
            System.out.printf ("The winner is left with total time: %.1f", leftTime);
        } else {
            System.out.printf ("The winner is right with total time: %.1f", rightTime);
        }
    }
}
