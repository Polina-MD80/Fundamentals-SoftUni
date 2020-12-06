import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class OnlyLetters {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        Pattern pattern = Pattern.compile ("(\\d+)([a-zA-Z])");
        Matcher matcher = pattern.matcher (input);

        while (matcher.find ()){
            String oldStr = matcher.group (1);
            String newStr = matcher.group (2);
            input = input.replace (oldStr,newStr);
        }
        System.out.println (input);
    }
}
