import java.util.Scanner;

public
class KaminoFactory {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        String input         = scanner.nextLine ();
        int    maxSum        = 0;
        int    maxSequence   = 0;
        int    leftIndex     = 101;
        int    bestDnaNumber = 0;
        int    dnaNumber     = 0;
        int[]  bestDna       = new int[n];
        while (!"Clone them!".equals (input)) {
            dnaNumber++;
            String[] line  = input.split ("!");
            int[]    dna   = new int[n];
            int      index = 0;

            for (int i = 0; i < line.length; i++) {
                if (!line[i].equals ("")) {
                    dna[index] = Integer.parseInt (line[i]);
                    index++;
                }

            }
            int localBestSequence = 0;
            int localBestIndex    = 0;
            int localSum          = 0;
            int onesStartIndex    = 0;
            int onesCount         = 0;
            for (int i = 0; i < dna.length ; i++) {
                localSum += dna[i];
                if (dna[i] == 1) {
                    onesStartIndex = i;
                    onesCount = 1;
                    for (int j = i + 1; j < dna.length; j++) {
                        if (dna[j] == 0) {
                            break;
                        } else {
                            onesCount++;
                        }
                    }
                    if (onesCount > localBestSequence) {
                        localBestSequence = onesCount;
                        localBestIndex = onesStartIndex;
                    }
                }

            }
            if (localBestSequence > maxSequence) {
                leftIndex = localBestIndex;
                maxSequence = localBestSequence;
                bestDna = dna;
                bestDnaNumber = dnaNumber;
                maxSum = localSum;
            } else if (localBestSequence == maxSequence) {
                if (localBestIndex < leftIndex) {
                    leftIndex = localBestIndex;
                    bestDna = dna;
                    bestDnaNumber = dnaNumber;
                    maxSum = localSum;
                } else if (localBestIndex == leftIndex) {
                    if (localSum > maxSum) {
                        bestDna = dna;
                        bestDnaNumber = dnaNumber;
                        maxSum = localSum;
                    }
                }
            }


            input = scanner.nextLine ();

        }
        System.out.printf ("Best DNA sample %d with sum: %d.%n", bestDnaNumber, maxSum);
        for (int i = 0; i < n; i++) {
            System.out.print (bestDna[i] + " ");

        }


    }
}
