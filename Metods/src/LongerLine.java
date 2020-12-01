import java.util.Scanner;

public
class LongerLine {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     x11     = Integer.parseInt (scanner.nextLine ());
        int     y11     = Integer.parseInt (scanner.nextLine ());
        int     x21     = Integer.parseInt (scanner.nextLine ());
        int     y21     = Integer.parseInt (scanner.nextLine ());
        double  line1   = findLineLength (x11, y11, x21, y21);
        int     x12     = Integer.parseInt (scanner.nextLine ());
        int     y12     = Integer.parseInt (scanner.nextLine ());
        int     x22     = Integer.parseInt (scanner.nextLine ());
        int     y22     = Integer.parseInt (scanner.nextLine ());
        double  line2   = findLineLength (x12, y12, x22, y22);
        if (compareLines (line1, line2) == line1) {
            System.out.printf ("(%d, %d)(%d, %d)", x11, y11, x21, y21);
        } else {
            System.out.printf ("(%d, %d)(%d, %d)", x12, y12, x22, y22);
        }


    }

    private static
    double compareLines (double a, double b) {
        if (a>=b){
            return a;
        }else return b;
    }

    private static
    double findLineLength (int x1, int y1, int x2, int y2) {
        return Math.sqrt (Math.pow (x1 - x2, 2) + Math.pow ((y1 - y2), 2));
    }
}
