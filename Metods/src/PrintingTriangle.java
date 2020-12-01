import java.util.Scanner;

public
class PrintingTriangle {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        printTriangle (n);


    }public static void printTriangle (int num){
        upperPart(num);
        lowerPart(num-1);

    }

    private static
    void upperPart (int num) {
        for (int i = 1; i <=num; i++) {
            printRow(i);
            System.out.println ();
        }

    }

    private static
    void printRow (int num) {
        for (int i = 1; i <= num; i++) {
            System.out.print (i+" ");
        }
    }

    private static
    void lowerPart (int num) {
        for (int i = num; i >=1 ; i--) {
            printRow (i);
            System.out.println ();
        }

    }

}
