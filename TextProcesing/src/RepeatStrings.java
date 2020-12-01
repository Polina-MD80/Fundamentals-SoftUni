import java.util.Scanner;

public
class RepeatStrings {
    public static
    void main (String[] args) {
        Scanner       scanner        = new Scanner (System.in);
        String[]      words          = scanner.nextLine ().split ("\\s+");
        StringBuilder result         = new StringBuilder ();
        String        resultAsString = "";
        printResultAsString (words, resultAsString);
        //printResult (words, result);
    }

    private static
    void printResultAsString (String[] words, String resultAsString) {
        for (String word : words) {
            int times = word.length ();
            for (int i = 0; i < times; i++) {
                resultAsString = resultAsString.concat (word);
            }

        }
        System.out.println (resultAsString);
    }

   /* private static
    void printResult (String[] words, StringBuilder result) {
        for (String word : words) {
            int times = word.length();
            for (int i = 0; i < times; i++) {
                result.append (word);
            }

        }
        System.out.println (result);
    }*/
}
