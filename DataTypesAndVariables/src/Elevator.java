import java.util.Scanner;

public
class Elevator {
    public static
    void main (String[] args) {
        Scanner scanner          = new Scanner (System.in);
        int     numberOfPeople   = Integer.parseInt (scanner.nextLine ());
        int     elevatorCapacity = Integer.parseInt (scanner.nextLine ());
        int     travels          = (int) (Math.ceil (1.0 * numberOfPeople / elevatorCapacity));
        System.out.println (travels);

    }
}
