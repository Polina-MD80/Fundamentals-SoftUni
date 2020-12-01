import java.util.Scanner;

public
class IntegerOperations {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        long    n1      = Long.parseLong (scanner.nextLine ());
        long    n2      = Long.parseLong (scanner.nextLine ());
        long    n3      = Long.parseLong (scanner.nextLine ());
        long    n4      = Long.parseLong (scanner.nextLine ());

        long result = (n1 + n2) / n3 * n4;
        System.out.println (result);
    }
}
