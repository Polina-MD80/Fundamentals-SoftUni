import java.util.Scanner;

public
class CalculateRectangleArea {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     width   = Integer.parseInt (scanner.nextLine ());
        int     height  = Integer.parseInt (scanner.nextLine ());

       int area=  calculatedArea (width, height);
        System.out.println (area);
    }

    private static int calculatedArea (int a, int b) {
        return a*b;
    }
}
