import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class SoftUniBarIncome {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  regex   = "%(?<customer>[A-Z][a-z]+)%[^$%|.]*<(?<product>\\w+)>[^$%|.]*\\|(?<quantity>\\d+)\\|[^$%|.]*?(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile (regex);
        String  order   = scanner.nextLine ();
        double  sum     = 0;
        while (!"end of shift".equals (order)) {
            Matcher validOrder = pattern.matcher (order);
            while (validOrder.find ()) {
                int quantity = Integer.parseInt (validOrder.group ("quantity"));
                double price =Double.parseDouble (validOrder.group ("price"));
                sum += (quantity * price);
                System.out.printf ("%s: %s - %.2f%n",validOrder.group ("customer"),validOrder.group ("product"), quantity*price );
            }
            order = scanner.nextLine ();
        }
        System.out.printf ("Total income: %.2f", sum);
    }
}
