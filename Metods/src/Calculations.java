import java.util.Scanner;

public
class Calculations {
    public static
    void main (String[] args) {
        Scanner scanner      = new Scanner (System.in);
        String  action       = scanner.nextLine ();
        int     firstNum     = Integer.parseInt (scanner.nextLine ());
        int     secondNumber = Integer.parseInt (scanner.nextLine ());
        switch (action) {
            case "add":
                add (firstNum, secondNumber);
                break;
            case "subtract":
                subtract (firstNum, secondNumber);
                break;
            case "multiply":
                multiply (firstNum, secondNumber);
                break;
            case "divide":
                divide (firstNum, secondNumber);
                break;

        }
    }

    private static void add(int a, int b){
        System.out.println (a+b);
    }

    private static void subtract(int a, int b){
        System.out.println (a-b);
    }

    private static void multiply(int a, int b){
        System.out.println (a*b);
    }

    private static void divide(int a, int b){
        System.out.println (a/b);
    }


}
