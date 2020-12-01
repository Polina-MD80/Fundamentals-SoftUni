import java.util.Scanner;

public
class PascalTriangle {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int    n          = Integer.parseInt (scanner.nextLine ());
        long[] tempoArray = {1};
        System.out.println (tempoArray[0]);

        for (int i = 2; i <= n; i++) {
            long[] array = new long[i];
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    array[j] = 1;
                } else if (j == i - 1) {
                    array[j] = 1;
                } else {
                    array[j] = tempoArray[j - 1] + tempoArray[j];
                }

            }
            tempoArray = array;
            String[] arrayAsString = new String[array.length];
            for (int j = 0; j < arrayAsString.length; j++) {
                arrayAsString[j] = String.valueOf (array[j]);
            }
            System.out.println (String.join (" ", arrayAsString));

        }
    }
}
