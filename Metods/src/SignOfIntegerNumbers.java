import java.util.Scanner;

public
class SignOfIntegerNumbers {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int number = Integer.parseInt (scanner.nextLine ());
        signOfNumber(number);
    }

    private static
    void signOfNumber (int num) {
        String sign = "zero";
        if (num>0){
            sign="positive";
        }else if (num<0){
            sign = "negative";
        }
        System.out.printf ("The number %d is %s.",num,sign);
    }
}
