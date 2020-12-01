import java.util.Scanner;

public
class BalancedBrackets {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        int     n        = Integer.parseInt (scanner.nextLine ());
        String  brackets = "";
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine ();
            if (input.equals ("(") || input.equals (")")) {
                brackets += input;
            }
        }
        if (brackets.length () % 2 != 0) {
            System.out.println ("UNBALANCED");
            return;
        }
        boolean isBalanced = true;
        for (int i = 0; i < brackets.length (); i++) {
            if (i % 2 == 0 && brackets.charAt (i) == ')') {
                isBalanced = false;
                break;
            }
            if (i % 2 != 0 && brackets.charAt (i) == '(') {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println ("BALANCED");
        } else {
            System.out.println ("UNBALANCED");
        }

    }
}
