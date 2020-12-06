import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class Mines {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String line = scanner.nextLine ();

        Pattern pattern = Pattern.compile ("<\\S\\S>");
        Matcher matcher = pattern.matcher (line);

        while (matcher.find ()){
            String mine = matcher.group ();
            int power = Math.abs (mine.charAt (1)- mine.charAt (2));
           // line = line.replace (mine,"____");
            int index = line.indexOf (mine);
            int leftIndex = Math.max (0,index-power);
            int rightIndex = Math.min (index+4+power-1,line.length ()-1);
            StringBuilder sb = new StringBuilder ();
            for (int i = 0; i < line.length (); i++) {
                if (i>=leftIndex&&i<=rightIndex){
                    sb.append ('_');
                }
                else sb.append (line.charAt (i));
            }
            line = sb.toString ();

        }
        System.out.println (line);
    }
}
