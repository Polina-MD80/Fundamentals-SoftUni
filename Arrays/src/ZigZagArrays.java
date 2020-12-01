import java.util.Scanner;

public
class ZigZagArrays {
    public static
    void main (String[] args) {
        Scanner  scanner     = new Scanner (System.in);
        int      n           = Integer.parseInt (scanner.nextLine ());
        String[] firstArray  = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine ().split (" ");
            if (i % 2 == 0) {
                firstArray[i] = input[0];
                secondArray[i] = input[1];
            } else {
                firstArray[i] = input[1];
                secondArray[i] = input[0];
            }


        }
        System.out.print (String.join (" ", firstArray));
        System.out.println ();
        System.out.println (String.join (" ", secondArray));
    }
}
