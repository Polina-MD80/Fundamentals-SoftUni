import java.util.Scanner;

public
class AsciiSumator {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        char fist = scanner.nextLine ().charAt (0);
        char second = scanner.nextLine ().charAt (0);
        String line = scanner.nextLine ();
        if(fist<second){
            findSum(fist,second,line);
        }else {
            findSum (second,fist,line);
        }
    }

    private static
    void findSum (char fist, char second,String line) {
        int sum = 0;
        for (int i = 0; i < line.length (); i++) {
           if (line.charAt (i)>fist&&line.charAt (i)<second){
               sum+=line.charAt (i);
           }
        }
        System.out.println (sum);
    }
}
