import java.util.Scanner;

public
class ActivationKeys {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String key = scanner.nextLine ();

        String command = scanner.nextLine ();

        while (!"Generate".equals (command)){
            String[] tokens = command.split (">>>");
            switch (tokens[0]){
                case "Contains":
                    containsSubstring(key,tokens);
                    break;
                case "Flip":
                    key = flip(key,tokens);
                    System.out.println (key);
                    break;
                case "Slice":
                   key = slice(key,tokens);
                    System.out.println (key);
                    break;
            }
            command = scanner.nextLine ();
        }
        System.out.println ("Your activation key is: "+key);
    }

    private static
    String slice (String key, String[] tokens) {
        int startIndex = Integer.parseInt (tokens[1]);
        int endIndex = Integer.parseInt (tokens[2]);
        StringBuilder keyBuilder = new StringBuilder (key);
        keyBuilder.replace (startIndex,endIndex,"");
        return keyBuilder.toString ();

    }

    private static
    String flip (String key, String[] tokens) {
        int startIndex = Integer.parseInt (tokens[2]);
        int endIndex = Integer.parseInt (tokens[3]);
        switch (tokens[1]){
            case "Upper":
                key = key.substring (0,startIndex)+key.substring (startIndex,endIndex).toUpperCase ()+key.substring (endIndex);
                break;
            case "Lower":
                key = key.substring (0,startIndex)+key.substring (startIndex,endIndex).toLowerCase ()+key.substring (endIndex);
                break;
        }
        return key;
    }

    private static
    void containsSubstring (String key, String[] tokens) {
        if (key.contains (tokens[1])){
            System.out.println (key+" contains "+tokens[1]);
        }else {
            System.out.println ("Substring not found!");
        }
    }
}
