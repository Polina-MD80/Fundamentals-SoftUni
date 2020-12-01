import java.util.Scanner;

public
class MultiplyBigNumber2 {
    public static
    void main (String[] args) {
        Scanner scanner    = new Scanner (System.in);
        String  input      = scanner.nextLine ();
        int     multiplier = Integer.parseInt (scanner.nextLine ());
        int     rest       = 0;
        if (multiplier==0){
            System.out.println (0);return;
        }
        for (int i = 0; i < input.length (); i++) {
            if (input.charAt (i) != '0') {
                int index = i;
                input = input.substring (index);break;
            }
        }

        StringBuilder bigNumber = new StringBuilder (input);

        for (int i = bigNumber.length () - 1; i >= 0; i--) {
            int currant  = Integer.parseInt (String.valueOf (bigNumber.charAt (i)));
            int newDigit = (currant * multiplier + rest) % 10;
            rest = (currant * multiplier + rest) / 10;
            bigNumber.replace (i, i + 1, "" + newDigit);
            if (i == 0 && rest != 0) {
                bigNumber.insert (0, rest);
            }

        }


        System.out.println (bigNumber);
    }
}
