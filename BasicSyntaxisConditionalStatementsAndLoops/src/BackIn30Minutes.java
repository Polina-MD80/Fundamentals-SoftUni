import java.util.Scanner;

public
class BackIn30Minutes {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int hour = Integer.parseInt (scanner.nextLine ());
        int minute = Integer.parseInt (scanner.nextLine ());
        minute += 30;
        if (minute>59){
            hour++;
            minute = minute-60;
        }
        if (hour>23){
            hour = 0;
        }
        System.out.printf ("%d:%02d",hour,minute);
    }
}
