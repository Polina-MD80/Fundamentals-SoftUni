import java.util.Scanner;

public
class SoftUniReception2 {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     capacity = 0;
        for (int i = 0; i < 3; i++) {
            int singleCapacity = scanner.nextInt ();
            capacity += singleCapacity;
        }
        int students = scanner.nextInt ();
        int hours = 0;
        while (students>0){
           students-=capacity;
           hours++;
           if (hours%4==0){
               hours++;
           }
        }
        System.out.printf ("Time needed: %dh.", hours);
    }
}
