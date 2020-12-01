import java.util.Arrays;
import java.util.Scanner;

public
class EncryptSortAndPrintArray {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt (scanner.nextLine ());
        String[] names = new String[n];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.nextLine ();

        }
        int[] numbers = new int[names.length];

        for (int i = 0; i < names.length; i++) {
            int sum = 0;
            for (int j = 0; j < names[i].length (); j++) {
             if (isVowel(names[i].charAt (j))){
                 sum = sum + names[i].charAt (j)*names[i].length ();

            }else{
                 sum = sum + names[i].charAt (j)/names[i].length ();

                }

        }numbers[i] = sum;
    }
        Arrays.sort (numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println (numbers[i]);

        }
}

    private static
    boolean isVowel (char c) {

        if (c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
    }
