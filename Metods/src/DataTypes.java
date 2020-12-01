import java.util.Scanner;

public
class DataTypes {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        String  type     = scanner.nextLine ();
        String  variable = scanner.nextLine ();
        switch (type) {
            case "int" -> {
                int number = Integer.parseInt (variable);
                printResult (number);
            }
            case "real" -> {
                double realNumber = Double.parseDouble (variable);
                printResult (realNumber);
            }
            case "string" -> printResult (variable);
        }
    }

    private static
    void printResult (int n) {
        System.out.println (n * 2);
    }

    public static
    void printResult (double n) {
        System.out.printf ("%.2f", n * 1.5);
    }


    public static
    void printResult (String string) {
        System.out.printf ("$%s$", string);
    }
}
