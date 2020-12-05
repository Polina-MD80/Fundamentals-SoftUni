import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class MorseCodeUpgraded {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] input = scanner.nextLine ().split ("\\|");

        String regex = "(1{2,})|(0{2,})";
        Pattern pattern = Pattern.compile (regex);
        StringBuilder result = new StringBuilder ();
        for (String s : input) {
            int sum = 0;
            for (int i = 0; i < s.length (); i++) {
                if (s.charAt (i)=='0'){
                    sum+=3;
                }else {
                    sum+=5;
                }
            }
            Matcher matcher = pattern.matcher (s);
            while (matcher.find ()){
               sum+= matcher.group ().length ();
            }
           result.append ((char)sum);
        }
        System.out.println (result);
    }
}
