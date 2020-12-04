import java.util.Scanner;

public
class EmailMe {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] email = scanner.nextLine ().split ("@");
        int leftSum = getSum(email[0]);
        int rightSum = getSum(email[1]);
        if(leftSum>=rightSum){
            System.out.println ("Call her!");
        }else {
            System.out.println ("She is not the one.");
        }
    }

    private static
    int getSum (String s) {
        int sum = 0;
        for (int i = 0; i < s.length (); i++) {
            sum += s.charAt (i);
        }
        return sum;
    }
}
