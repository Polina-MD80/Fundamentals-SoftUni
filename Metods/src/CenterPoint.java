import java.util.Scanner;

public
class CenterPoint {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        int    x1        = Integer.parseInt (scanner.nextLine ());
        int    y1        = Integer.parseInt (scanner.nextLine ());
        double distance1 = findDistanceToCenter (x1, y1);
        int    x2        = Integer.parseInt (scanner.nextLine ());
        int    y2        = Integer.parseInt (scanner.nextLine ());
        double distance2 = findDistanceToCenter (x2, y2);
        if (findClosestPoint (distance1, distance2)==distance1){
            System.out.printf ("(%d, %d)", x1,y1);
        }else {
            System.out.printf ("(%d, %d)", x2,y2);
        }


    }

    private static
    double findClosestPoint (double a, double b) {
        if (a <= b) {
            return a;
        } else {
            return b;
        }
    }

    private static
    double findDistanceToCenter (int x, int y) {
        return Math.sqrt (x * x + y * y);
    }
}
