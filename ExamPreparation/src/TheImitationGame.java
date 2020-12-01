import java.util.Scanner;

public
class TheImitationGame {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  message = scanner.nextLine ();
        String  command = scanner.nextLine ();

        while (!"Decode".equals (command)) {
            String[] token = command.split ("\\|");
            switch (token[0].trim ()) {
                case "Move":
                    int index = Integer.parseInt (token[1]);
                    if (index >0 && index < message.length ()) {
                        String sb = message.substring (0, index);
                        message = message.substring (index) + sb;
                    }
                    break;
                case "Insert":
                    int indexToInsert = Integer.parseInt (token[1]);
                    StringBuilder sb = new StringBuilder (message);
                    if (indexToInsert >= 0 && indexToInsert < message.length ()) {
                        message = sb.insert (indexToInsert,token[2]).toString ();
                    }else if (indexToInsert<=0){
                        message = token[2]+message;
                    }else message=message+token[2];

                    break;
                case "ChangeAll":
                    if (message.contains (token[1])) {
                        message = message.replace (token[1], token[2]);
                    }
                    break;
            }


            command = scanner.nextLine ();
        }
        System.out.print ("The decrypted message is: ");
        System.out.println (message);
    }
}
