import java.util.Scanner;

public
class Train {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     n       = Integer.parseInt (scanner.nextLine ());
        int[]   train   = new int[n];
        int     sum     = 0;

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt (scanner.nextLine ());
            sum += train[i];
        }

        String[] trainAsString = new String[train.length];
        for (int i = 0; i < trainAsString.length; i++) {
            trainAsString[i]=String.valueOf (train[i]);
        }
        System.out.println (String.join (" ", trainAsString));
        System.out.println (sum);

    }

}

