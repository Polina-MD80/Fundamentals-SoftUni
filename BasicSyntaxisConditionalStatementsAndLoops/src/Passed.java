import java.util.Scanner;

public
class Passed {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        double input = Double.parseDouble (scanner.nextLine ());
        if (input>=3.00){
            System.out.println ("Passed!");
        }else {
            System.out.println ("Failed!");
        }

    }
}
