import java.util.Scanner;

public
class NxNMatrix {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        printMatrix(n);
    }

    private static
    void printMatrix (int n) {
        printColumns(n);
    }

    private static
    void printRows (int n) {
        for (int i = 1; i <=n ; i++) {
            System.out.print (n+" ");
        }
        System.out.println ();
    }

    private static void printColumns(int n){
        for (int i = 1; i <=n ; i++) {
            printRows (n);

        }
    }
}
