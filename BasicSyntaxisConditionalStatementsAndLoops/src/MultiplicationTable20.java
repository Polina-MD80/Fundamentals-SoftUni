import java.util.Scanner;

public
class MultiplicationTable20 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        int startN = Integer.parseInt (scanner.nextLine ());
        if (startN>10){
            System.out.printf ("%d X %d = %d",n,startN,n*startN);
        }else {
            for (int i = startN; i <=10 ; i++) {
                System.out.printf ("%d X %d = %d%n",n,i, n*i);
            }
        }
    }
}
