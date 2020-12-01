import java.util.*;

public
class AnonymousThreat {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        String[]     input   = scanner.nextLine ().split ("\\s+");
        List<String> list    = new ArrayList<> (Arrays.asList (input));
        String command = scanner.nextLine ();
        while (!command.equals ("3:1")) {
            String[] tokens      = command.split (" ");
            int      firstIndex  = Integer.parseInt (tokens[1]);
            int      secondInput = Integer.parseInt (tokens[2]);

            if (tokens[0].equals ("merge")) {
                int startIndex = Math.max (firstIndex, 0);
                int endIndex   = Math.min (list.size () - 1, secondInput);
                if (startIndex >= list.size ()) {
                    command = scanner.nextLine ();
                    continue;
                }
                String mergedElement = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    mergedElement = mergedElement + list.get (i);

                }
                for (int i = endIndex; i >= startIndex; i--) {
                    list.remove (i);
                }
                list.add (startIndex, mergedElement);

            } else if (tokens[0].equals ("divide")) {
                List<String> dividedList     = new ArrayList<> ();
                String       element         = list.get (firstIndex);
                int          subStringLength = element.length () / secondInput;
                int          count           = 0;
                int          totalCounter    = 0;
                String       subElement      = "";

                for (int i = 0; i < element.length (); i++) {
                    char symbol = element.charAt (i);
                    subElement += symbol;
                    count++;

                    if (count == subStringLength && totalCounter + 1 < secondInput) {
                        dividedList.add (subElement);
                        count = 0;
                        totalCounter++;
                        subElement = "";
                    }
                }
                dividedList.add (subElement);
                list.remove (firstIndex);

                for (int i = dividedList.size () - 1; i >= 0; i--) {
                    list.add (firstIndex, dividedList.get (i));

                }

            }

            command = scanner.nextLine ();
        }

        for (String s : list) {
            System.out.print (s + " ");
        }
    }

}

