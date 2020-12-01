import java.util.Arrays;
import java.util.Scanner;

public
class TriSequence {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        int     num      = Integer.parseInt (scanner.nextLine ());
        long[]  sequence = new long[3];
        sequence[0] = 1;
        sequence[1] = 1;
        sequence[2] = 2;
        printTriSequence (num, sequence);
    }

    private static
    void printTriSequence (int n, long[] sequence) {
        long[] sequence1 = new long[n];
        for (int i = 0; i < sequence.length; i++) {
            sequence1[i] = sequence[i];
        }
        sequence1[n-1]= sequence1[n-2]+sequence1[n-3]+sequence[n-4];

        }



    }

