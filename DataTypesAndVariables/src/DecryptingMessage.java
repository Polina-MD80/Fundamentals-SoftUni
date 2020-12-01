import java.util.Scanner;

public
class DecryptingMessage {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int key = Integer.parseInt (scanner.nextLine ());
        int n   = Integer.parseInt (scanner.nextLine ());
        String decodedMessage = "";

        int i = 0;
        do {
            int letter = scanner.nextLine ().charAt (0);
           int decodedLetter =letter+key;
           char symbol = (char)decodedLetter;
           decodedMessage +=symbol;
                     i++;
        }while (i<n);
        System.out.println (decodedMessage);
    }

}
