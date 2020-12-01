import java.util.Scanner;

public
class MultiplicationTable {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
     int i= 1;
     do {
            System.out.printf ("n X %d = %d%n",i, n*i);
            i++;

        }while (i<=10);
    }
}
