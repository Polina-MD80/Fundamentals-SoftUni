import java.util.Scanner;

public
class CaesarCipher {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String line = scanner.nextLine ();
       /* StringBuilder result = new StringBuilder ();
        for (int i = 0; i < line.length (); i++) {
            result.append ((char) (line.charAt (i)+3));
        }
        System.out.println (result);*/
        for (char c : line.toCharArray ()) {
            System.out.print ((char)(c+3));
        }

    }
}
