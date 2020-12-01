import java.util.*;
import java.util.stream.Collectors;

public
class Commands {
    public static
    void main (String[] args) {
        Scanner      scanner = new Scanner (System.in);
        List<String> list    = Arrays.stream (scanner.nextLine ().split (" ")).collect (Collectors.toList ());

        String command = scanner.nextLine ();
        while (!"end".equals (command)) {
            String[] tokens = command.split ("\\s+");
            switch (tokens[0]) {
                case "reverse":
                    reverseList (tokens, list);
                    break;
                case "sort":
                    sortList (tokens, list);
                    break;
                case "remove":
                    removeFromList (tokens, list);
                    break;
            }
            command = scanner.nextLine ();
        }
        System.out.println (list.toString ().replaceAll ("[\\[\\]]", ""));

    }

    private static
    void sortList (String[] tokens, List<String> list) {
        int          index   = Integer.parseInt (tokens[2]);
        int          count   = Integer.parseInt (tokens[4]);
        List<String> subList = fillSublist (list, index, count);
        Collections.sort (subList);
        refillList (list, index, count, subList);
    }

    private static
    void refillList (List<String> list, int index, int count, List<String> subList) {
        for (int i = index; i < index + count; i++) {
            list.add (i, subList.get (0));
            subList.remove (0);
        }
    }

    private static
    void reverseList (String[] tokens, List<String> list) {
        int          index   = Integer.parseInt (tokens[2]);
        int          count   = Integer.parseInt (tokens[4]);
        List<String> subList = fillSublist (list, index, count);
        reverseElementsInList (subList);
        refillList (list, index, count, subList);
    }

    private static
    void reverseElementsInList (List<String> subList) {
        for (int i = 0; i < subList.size () / 2; i++) {
            String temp = subList.get (i);
            subList.set (i, subList.get (subList.size () - 1 - i));
            subList.set (subList.size () - 1 - i, temp);
        }
    }

    private static
    List<String> fillSublist (List<String> list, int index, int count) {
        List<String> subList = new ArrayList<> ();
        for (int i = 0; i < count; i++) {
            subList.add (list.get (index));
            list.remove (index);
        }
        return subList;
    }

    private static
    void removeFromList (String[] tokens, List<String> list) {
        int count = Integer.parseInt (tokens[1]);
        for (int i = 0; i < count; i++) {
            list.remove (0);
        }
    }
}
