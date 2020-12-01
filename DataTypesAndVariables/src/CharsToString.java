import java.util.Scanner;

public
class CharsToString {
    public static
    void main (String[] args) {
        Scanner       scanner = new Scanner (System.in);
        StringBuilder output  = new StringBuilder ();
        for (int i = 0; i < 3; i++) {
            char input = scanner.nextLine ().charAt (0);
            output.append (input);
            if (i==2){
                System.out.println (output);
            }
        }

    }
}
