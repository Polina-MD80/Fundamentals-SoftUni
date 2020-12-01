import java.util.Scanner;

public
class ReverseArrayOfStrings {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] elements      = scanner.nextLine ().split (" ");
        for (int i = 0; i < elements.length/2 ; i++) {
            int reverseIndex = elements.length - 1 -i;
            String tmp = elements[i];
            elements[i]= elements[reverseIndex];
            elements[reverseIndex]=tmp;

        }
        System.out.println (String.join (" ",elements));

    }
}
