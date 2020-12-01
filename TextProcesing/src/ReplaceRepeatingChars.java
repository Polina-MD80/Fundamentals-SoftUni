import java.util.Scanner;

public
class ReplaceRepeatingChars {
    public static
    void main (String[] args) {
        Scanner       scanner = new Scanner (System.in);
        StringBuilder line    = new StringBuilder (scanner.nextLine ());
        for (int i = 0; i < line.length (); i++) {
            char currant = line.charAt (i);
            for (int j = i + 1; j < line.length (); j++) {
                if (line.charAt (j) == currant) {
                    line.replace (j, j + 1, "");
                    j--;
                } else {
                    break;
                }
            }
        }
        System.out.println (line);
    }
}
