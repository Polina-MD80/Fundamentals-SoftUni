import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public
class ArrayManipulator {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int[]   numbers = readMyIntArray (scanner.nextLine ());
        String  command = scanner.nextLine ();

        while (!"end".equals (command)) {
            String[] tokens = command.split ("\\s+");
            if ("exchange".equals (tokens[0])) {
                int index = Integer.parseInt (tokens[1]);
                if (index >= 0 && index < numbers.length) {
                    exchangeArrayAfterIndex (numbers, index);
                } else System.out.println ("Invalid index");
            } else if ("max".equals (tokens[0])) {
                switch (tokens[1]) {
                    case "even":
                        if (maxEvenNumber (numbers) == -1) {
                            System.out.println ("No matches");
                        } else System.out.println (maxEvenNumber (numbers));
                        break;
                    case "odd":
                        if (maxOddNumber (numbers) == -1) {
                            System.out.println ("No matches");
                        } else System.out.println (maxOddNumber (numbers));
                        break;
                }
            } else if ("min".equals (tokens[0])) {
                switch (tokens[1]) {
                    case "even":
                        if (minEvenNumber (numbers) == -1) {
                            System.out.println ("No matches");
                        } else System.out.println (minEvenNumber (numbers));
                        break;
                    case "odd":
                        if (minOddNumber (numbers) == -1) {
                            System.out.println ("No matches");
                        } else System.out.println (minOddNumber (numbers));
                        break;
                }
            } else if ("first".equals (tokens[0])) {
                int quantity = Integer.parseInt (tokens[1]);
                switch (tokens[2]) {
                    case "even":
                        firstNumEvens (numbers, quantity);
                        break;
                    case "odd":
                        firstNumOdds (numbers, quantity);
                        break;
                }
            } else if ("last".equals (tokens[0])) {
                int quantity = Integer.parseInt (tokens[1]);
                switch (tokens[2]) {
                    case "even":
                        lastNumEvens (numbers, quantity);
                        break;
                    case "odd":
                        lastNumOdds (numbers, quantity);
                        break;
                }

            }
            command = scanner.nextLine ();
        }
        // printIntArrayInBrackets (numbers);
        printArrayToString (numbers);
    }

    private static
    void lastNumEvens (int[] arr, int n) {
        int count = 0;
        if (n < 1 || n > arr.length) {
            System.out.println ("Invalid count");
            return;
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        int[] lastNumEvens = new int[count];
        int   index        = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] % 2 == 0) {
                lastNumEvens[index] = arr[i];
                if (index==count-1){
                    break;
                }
                index++;
            }
        }
        reverseArray(lastNumEvens);
        printArrayToString (lastNumEvens);
    }

    private static
    void lastNumOdds (int[] arr, int n) {
        int count = 0;
        if (n < 1 || n > arr.length) {
            System.out.println ("Invalid count");
            return;
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        int[] lastNumOdds = new int[count];
        int   index        = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                lastNumOdds[index] = arr[i];
                if (index==count-1){
                    break;
                }
                index++;
            }
        }
        reverseArray(lastNumOdds);
        printArrayToString (lastNumOdds);
    }

    private static
    void reverseArray (int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }

    private static
    void firstNumOdds (int[] arr, int n) {
        int count = 0;
        if (n < 1 || n > arr.length) {
            System.out.println ("Invalid count");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        int[] firstNumOdds = new int[count];
        int   index        = 0;
        for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    firstNumOdds[index] = arr[i];
                    if (index==count-1){
                        break;
                    }
                    index++;
                }
            }
        printArrayToString (firstNumOdds);
    }

    private static
    void firstNumEvens (int[] arr, int n) {
        int count = 0;
        if (n < 1 || n > arr.length) {
            System.out.println ("Invalid count");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
                if (count == n) {
                    break;
                }
            }
        }
        int[] firstNumEvens = new int[count];
        int   index        = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                firstNumEvens[index] = arr[i];
                if (index==count-1){
                    break;
                }
                index++;
            }
        }
        printArrayToString (firstNumEvens);
    }

    private static
    int[] readMyIntArray (String scan) {
        String[] arrayAsString = scan.split ("\\s+");
        int[]    arr           = new int[arrayAsString.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt (arrayAsString[i]);
        }
        return arr;
    }

    private static
    void printArrayToString (int[] arr) {
        System.out.println (Arrays.toString (arr));
    }

    private static
    int minOddNumber (int[] arr) {
        int index  = -1;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] <= minOdd) {
                minOdd = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static
    int minEvenNumber (int[] arr) {
        int index   = -1;
        int minEven = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= minEven) {
                minEven = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static
    int maxOddNumber (int[] arr) {
        int index  = -1;
        int maxOdd = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= maxOdd) {
                maxOdd = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static
    int maxEvenNumber (int[] arr) {
        int index   = -1;
        int maxEven = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= maxEven) {
                maxEven = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static
    void exchangeArrayAfterIndex (int[] arr, int index) {
        int[] firstPart  = new int[index + 1];
        int[] secondPart = new int[arr.length - index - 1];
        for (int i = 0; i < firstPart.length; i++) {
            firstPart[i] = arr[i];
        }
        int subIndex = 0;
        for (int i = index + 1; i < arr.length; i++) {
            secondPart[subIndex] = arr[i];
            subIndex++;
        }
        for (int i = 0; i < secondPart.length; i++) {
            arr[i] = secondPart[i];
        }
        int arrSubIndex = secondPart.length;
        for (int i = 0; i < firstPart.length; i++) {
            arr[arrSubIndex] = firstPart[i];
            arrSubIndex++;
        }
    }

    private static
    void printIntArrayInBrackets (int[] arr) {
        String[] arrAsString = new String[arr.length];
        for (int i = 0; i < arrAsString.length; i++) {
            arrAsString[i] = String.valueOf (arr[i]);
        }
        System.out.println ("[" + String.join (", ", arrAsString) + "]");
    }


}
