import java.util.Scanner;

public
class Censorship {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String word = scanner.nextLine ();
        String line = scanner.nextLine ();
        line = line.replace (word,stars (word));
        System.out.println (line);
    }

    private static
    CharSequence stars (String word) {
        StringBuilder starWord = new StringBuilder ();
        for (int i = 0; i < word.length (); i++) {
            starWord.append ("*");
        }
        return starWord.toString ();
    }
}
