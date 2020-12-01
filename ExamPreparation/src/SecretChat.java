import java.util.Scanner;

public
class SecretChat {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  message = scanner.nextLine ();
        String  command = scanner.nextLine ();
        while (!command.equals ("Reveal")) {
            String[] tokens = command.split (":\\|:");
            switch (tokens[0]) {
                case "InsertSpace":
                    message = insertSpace (message, tokens);
                    System.out.println (message);
                    break;
                case "Reverse":
                   message = reverseSb (message,tokens);

                    break;
                case "ChangeAll":
                    message = changeAll (message, tokens);
                    System.out.println (message);
                    break;
            }


            command = scanner.nextLine ();
        }
        System.out.println ("You have a new text message: " + message);

    }

    private static
    String reverseSb (String message, String[] tokens) {
        String toReverse = tokens[1];
        StringBuilder substring = new StringBuilder (toReverse);
        if (!message.contains (substring.toString ())){
            System.out.println ("error");
        }else {
            StringBuilder reversed = new StringBuilder (toReverse);
            reversed.reverse ();
            StringBuilder newMessage = new StringBuilder (message);
            newMessage.append (reversed);
            newMessage.replace (newMessage.indexOf (toReverse),newMessage.indexOf (toReverse)+ toReverse.length (),"");
            message = newMessage.toString ();
            System.out.println (message);
        }
        return message;

    }

    private static
    String changeAll (String message, String[] tokens) {
        String toReplace   = tokens[1];
        String replacement = tokens[2];
        while (message.contains (toReplace)) {
            message = message.replace (toReplace, replacement);
        }

        return message;

    }

   
    private static
    String insertSpace (String message, String[] tokens) {
        int           index  = Integer.parseInt (tokens[1]);
        StringBuilder result = new StringBuilder (message);
        result.insert (index, " ");
        return result.toString ();
    }
}
