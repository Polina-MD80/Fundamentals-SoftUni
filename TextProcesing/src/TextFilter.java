import java.util.Scanner;

public
class TextFilter {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] bannedWords = scanner.nextLine ().split (", ");
        String text = scanner.nextLine ();

        for (String bannedWord : bannedWords) {
            text = replaceBannedWord(text, bannedWord);
        }
        System.out.println (text);
    }

    private static
    String replaceBannedWord (String text, String word) {
        String  asterisks = "";
        for (int i = 0; i < word.length (); i++) {
           asterisks =  asterisks.concat ("*");
        }
        while (text.contains (word)){
            text = text.replace (word,asterisks);

        }
        return text;
    }
}
