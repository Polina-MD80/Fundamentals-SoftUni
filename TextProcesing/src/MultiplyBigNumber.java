import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class MultiplyBigNumber {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> bigNumber = Arrays.stream (scanner.nextLine ().split (""))
                .map (Integer::parseInt).collect (Collectors.toList ());
        int multiplier = Integer.parseInt (scanner.nextLine ());
        int rest = 0;

        for (int i = bigNumber.size () - 1; i >= 0; i--) {
            int currant = bigNumber.get (i);
            int newDigit = (currant*multiplier+rest)%10;
            rest = (currant*multiplier+rest)/10;
            bigNumber.set (i,newDigit);
            if (i==0&& rest!=0){
                bigNumber.add (0,rest);
            }


        }
        System.out.println (bigNumber.toString ().replaceAll ("[\\[\\], ]", ""));

    }
}
