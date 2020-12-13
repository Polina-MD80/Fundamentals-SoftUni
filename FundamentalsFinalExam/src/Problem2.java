import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class Problem2 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        String regex = "^U\\$([A-Z][a-z]{2,})U\\$P@\\$([A-Za-z]{5,}\\d+)P@\\$$";
        Pattern pattern = Pattern.compile (regex);
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine ();
            Matcher matcher = pattern.matcher (input);
            if (matcher.find ()){
                count++;
                System.out.println ("Registration was successful");
                System.out.println ("Username: "+ matcher.group (1)+", Password: " + matcher.group (2));

            }else {
                System.out.println ("Invalid username or password");
            }

        }
        System.out.println ("Successful registrations: " + count);
    }
}
