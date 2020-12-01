import java.util.Scanner;

public
class Substring {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String wordToRemove = scanner.nextLine ();
        String text = scanner.nextLine ();
       // StringBuilder result = new StringBuilder (text);
        while (text.contains (wordToRemove)){
            //int startIndex = result.indexOf (wordToRemove);
           //result.replace (startIndex,startIndex+wordToRemove.length (),"");
            text = text.replace (wordToRemove,"");
           // text = result.toString ();

        }
        System.out.println (text);
    }
}
