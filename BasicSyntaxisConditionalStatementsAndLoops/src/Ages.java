import java.util.Scanner;

public
class Ages {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     age     = Integer.parseInt (scanner.nextLine ());
        String  output  = "";
        //0-2 – baby;
        // 3-13 – child;
        // 14-19 – teenager;
        // 20-65 – adult;
        // &gt;=66 – elder;
        // All the values are inclusive.

        if (age >= 0) {
            if (age <= 2) {
                output = "baby";
            }else if (age <= 13) {
                output = "child";
            }else if (age <= 19) {
                output = "teenager";
            }else if (age <= 65) {
                output = "adult";
            }else  {
                output = "elder";
            }
            System.out.println (output);
        }
    }
}
