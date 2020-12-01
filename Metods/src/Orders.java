import java.util.Scanner;

public
class Orders {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        String  beverage = scanner.nextLine ();
        int     number   = Integer.parseInt (scanner.nextLine ());

        switch (beverage) {

            case "coffee":
                coffee (number);
                break;
            case "water":
                water (number);
                break;
            case "coke":
                coke (number);
                break;
            case "snacks":
                snacks (number);
                break;


        }
    }

    private static
    void coffee (int n) {
        System.out.printf ("%.2f", n * 1.50);
    }

    private static
    void water (int n) {
        System.out.printf ("%.2f", n * 1.00);
    }

    private static
    void coke (int n) {
        System.out.printf ("%.2f", n * 1.40);
    }

    private static
    void snacks (int n) {
        System.out.printf ("%.2f", n * 2.0);
    }
}