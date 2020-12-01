import java.util.Scanner;

public
class AddAndSubtract {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int firstInt = Integer.parseInt (scanner.nextLine ());
        int secondInt = Integer.parseInt (scanner.nextLine ());
        int thirdInt = Integer.parseInt (scanner.nextLine ());
        System.out.println (addAndSubtract (firstInt,secondInt,thirdInt));
    }

    private static
    int addAndSubtract (int a,int b, int c) {
        return addResult(a,b) - c;
    }

    private static
    int addResult (int a, int b) {
        return a + b;
    }
}
