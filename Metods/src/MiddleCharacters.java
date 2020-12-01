import java.util.Scanner;

public
class MiddleCharacters {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine ();
        System.out.println (middleCharacters(input));
    }

    private static
    String middleCharacters (String s) {
        String result = "";
        if(s.length ()%2==0){
            result =evenInputMiddleCharacters(s);
        }else {
           result = oddInputMiddleCharacters(s);
        }
        return result;
    }

    private static String
    oddInputMiddleCharacters (String s) {
        int  n      = s.length ()/2;
        return s.charAt (n)+"";
    }

    private static
    String evenInputMiddleCharacters (String s) {
        int n = s.length ()/2;
        return "" + s.charAt (n - 1) + s.charAt (n);
    }
}
