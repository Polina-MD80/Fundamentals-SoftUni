import java.util.Scanner;

public
class SmallestOfThreeNumbers2 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     a       = Integer.parseInt (scanner.nextLine ());
        int     b       = Integer.parseInt (scanner.nextLine ());
        int     c       = Integer.parseInt (scanner.nextLine ());
        System.out.println (smallestNum (a, b, c));
    }

    private static
    int smallestNum (int a, int b, int c) {
        return smallestNum (smallestNum (a, b), c);
    }

    private static
    int smallestNum (int a, int b) {
        if (a > b) {
            return b;
        }
        return a;
    }
}
