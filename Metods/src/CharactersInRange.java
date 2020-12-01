import java.util.Scanner;

public
class CharactersInRange {
    public static
    void main (String[] args) {
        Scanner scanner    = new Scanner (System.in);
        char    firstChar  = scanner.nextLine ().charAt (0);
        char    secondChar = scanner.nextLine ().charAt (0);
        if (firstChar < secondChar) {
            printCharsBetween (firstChar, secondChar);
        }else {
            printCharsBetween (secondChar,firstChar);
        }


    }

    private static
    void printCharsBetween (char firstChar, char secondChar) {
        for (int i = firstChar+1; i < secondChar; i++) {
            System.out.print (String.format ("%c ", i));
        }
    }
}