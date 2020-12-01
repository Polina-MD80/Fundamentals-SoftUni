import java.util.Scanner;

public
class SmallestNumber {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int num1 = Integer.parseInt (scanner.nextLine ());
        int num2 = Integer.parseInt (scanner.nextLine ());
        int num3 = Integer.parseInt (scanner.nextLine ());
        System.out.println ( smallestNumber(num1,num2,num3));
    }

    private static
    int smallestNumber (int num1, int num2, int num3) {
        int minNum=Integer.MAX_VALUE;
        if (num1<minNum){
            minNum=num1;
        }if (num2<minNum){
            minNum=num2;
        }if (num3<minNum){
            minNum=num3;
        }return minNum;
    }
}
