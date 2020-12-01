import java.util.Arrays;
import java.util.Scanner;

public
class ArrayModifier {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[] numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .mapToInt (Integer::parseInt).toArray ();
        String command = scanner.nextLine ();
        while (!"end".equals (command)) {
            String[] tokens = command.split (" ");

            switch (tokens[0]) {
                case "swap":
                    int index1 = Integer.parseInt (tokens[1]);
                    int index2 = Integer.parseInt (tokens[2]);
                    swap (numbers, index1, index2);
                    break;
                case "multiply":
                    int index1m = Integer.parseInt (tokens[1]);
                    int index2m = Integer.parseInt (tokens[2]);
                    multiply (numbers, index1m, index2m);
                    break;
                case "decrease":
                    decrease (numbers);
                    break;
            }
            command = scanner.nextLine ();
        }


        System.out.println (Arrays.toString (numbers).replaceAll ("[\\[\\]]", ""));
    }

    private static
    void decrease (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] - 1;

        }
    }

    private static
    void multiply (int[] numbers, int index1m, int index2m) {
        numbers[index1m]= numbers[index1m] * numbers[index2m];
    }

    private static
    void swap (int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}
