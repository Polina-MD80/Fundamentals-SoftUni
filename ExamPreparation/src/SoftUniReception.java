import java.util.Scanner;

public
class SoftUniReception {
    public static
    void main (String[] args) {
        Scanner scanner  = new Scanner (System.in);
        int     capacity = 0;
        for (int i = 0; i < 3; i++) {
            int singleCapacity = scanner.nextInt ();
            capacity += singleCapacity;
        }
        int students = scanner.nextInt ();
        if (students == 0) {
            System.out.println ("Time needed: 0h.");
        } else {
            int hours = students / capacity;
            if (hours >= 3) {
                hours = hours + hours / 3;
            }
            if (students % capacity != 0) {
                hours += 1;
            }
            System.out.printf ("Time needed: %dh.", hours);
        }
    }
}
