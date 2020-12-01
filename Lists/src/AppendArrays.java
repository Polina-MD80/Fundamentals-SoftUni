import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class AppendArrays {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] arrays = scanner.nextLine ().split ("\\|");
        List<String> reversedArray = new ArrayList<> ();
        for (int i = arrays.length-1; i >=0 ; i--) {
            String[] elements = arrays[i].split ("\\s+");
            for (int j = 0; j < elements.length; j++) {
                if (!elements[j].equals ("")){
                    reversedArray.add (elements[j]);
                }

            }
        }
        printList(reversedArray);

    }

    private static
    void printList (List<String> array) {
        for (String element : array) {
            System.out.print (element+" ");
        }
    }
}
