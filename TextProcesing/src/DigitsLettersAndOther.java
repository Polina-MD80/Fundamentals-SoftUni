import java.util.Scanner;

public
class DigitsLettersAndOther {
    public static
    void main (String[] args) {
        Scanner       scanner = new Scanner (System.in);
        String        line    = scanner.nextLine ();
        StringBuilder letters = new StringBuilder ();
        StringBuilder digits  = new StringBuilder ();
        StringBuilder symbols = new StringBuilder ();
        for (int i = 0; i < line.length (); i++) {
            char tempo = line.charAt (i);
            if (Character.isAlphabetic (tempo)) {
                letters.append (tempo);
            } else if (Character.isDigit (tempo)) {
                digits.append (tempo);
            }else if (Character.isDefined (tempo)){
            symbols.append (tempo);}

        }
        System.out.println (digits);
        System.out.println (letters);
        System.out.println (symbols);
    }
}
