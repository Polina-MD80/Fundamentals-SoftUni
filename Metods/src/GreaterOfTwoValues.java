import java.util.Scanner;

public
class GreaterOfTwoValues {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String variable = scanner.nextLine ();
        String firstString = scanner.nextLine ();
        String secondString = scanner.nextLine ();
        if (variable.equals ("int")){
            int firstInt = Integer.parseInt (firstString);
            int secondInt = Integer.parseInt (secondString);
            System.out.println (getMax( firstInt,  secondInt));return;
        }else if (variable.equals ("char")){
            char firstChar = firstString.charAt (0);
            char secondChar = secondString.charAt (0);
            System.out.println (getMax(firstChar,secondChar));return;
        }

        System.out.println (getMax(firstString,secondString));
    }

    private static
    int getMax (int a,int b) {
        return (Math.max(a,b));
    }


    private static char getMax( char a, char b){
        if (a>=b){
            return a;
        }else {
            return b;
        }
    }

    private static String getMax(String a,String b){
        if (a.compareTo (b) >= 0) {
            return a;
        }else return b;
    }
}
