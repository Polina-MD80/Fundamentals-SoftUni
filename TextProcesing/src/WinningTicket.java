import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class WinningTicket {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] tickets = scanner.nextLine ().split (",\\s+");
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = tickets[i].trim ();
            if (tickets[i].length () != 20) {
                System.out.println ("invalid ticket");
            } else {
                String  first     = tickets[i].substring (0, 10);
                String  second    = tickets[i].substring (10);
                winningOrNoMachTicket (first, second);
            }
        }
    }

    private static
    void winningOrNoMachTicket (String first, String second) {
        Pattern pattern  = Pattern.compile ("(?<dollar>\\${6,})|(?<roof>\\^{6,})|(?<et>@{6,})|(?<hash>#{6,})");
        Matcher matcher1 = pattern.matcher (first);
        Matcher matcher2 = pattern.matcher (second);
        if (matcher1.find () && matcher2.find ()) {
            String found1 = matcher1.group ();
            String found2 = matcher2.group ();
            if (found1.charAt (0) == found2.charAt (0)) {
                int maxLength = Math.min (found1.length (), found2.length ());
                if (maxLength == 10) {
                    System.out.printf ("ticket \"%s%s\" - 10%c Jackpot!%n", first, first, found1.charAt (0));
                } else {
                    System.out.printf ("ticket \"%s%s\" - %d%c%n", first, second, maxLength, found1.charAt (0));
                }
            } else {
                System.out.printf ("ticket \"%s%s\" - no match", first, second);
            }
        } else System.out.printf ("ticket \"%s%s\" - no match%n", first, second);
    }
}
