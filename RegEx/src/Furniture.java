import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class Furniture {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  regex   = ">>(?<name>[A-Za-z]+)<<(?<price>[\\d]+[.]?[\\d]*)!(?<quantity>[\\d]+)";
        Pattern pattern = Pattern.compile (regex);
        List<String> items = new ArrayList<> ();
        double sum = 0;
        String  input   = scanner.nextLine ();
        while (!input.equals ("Purchase")) {
            Matcher furniture = pattern.matcher (input);
            while (furniture.find ()){
                items.add (furniture.group ("name"));
                double PricePerName = Double.parseDouble (furniture.group ("price"))
                                      *Integer.parseInt (furniture.group ("quantity"));
                sum+=PricePerName;
            }
            input = scanner.nextLine ();
        }
        System.out.println ("Bought furniture:");
        for (String item : items) {
            System.out.println (item);

        }
        System.out.printf ("Total money spend: %.2f",sum);
    }
}
