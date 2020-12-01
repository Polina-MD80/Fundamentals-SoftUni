import java.util.Scanner;

public
class PadawanEquipment {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        double budget                 = Double.parseDouble (scanner.nextLine ());
        int    students               = Integer.parseInt (scanner.nextLine ());
        double lightsabersPricePerOne = Double.parseDouble (scanner.nextLine ());
        double robesPricePerOne       = Double.parseDouble (scanner.nextLine ());
        double beltsPricePerOne       = Double.parseDouble (scanner.nextLine ());
        int    lihtsabers             = (int) Math.ceil (students * 1.1);
        int    belts                  = students - (students / 6);
        double total = students * robesPricePerOne + lightsabersPricePerOne * lihtsabers +
                       belts * beltsPricePerOne;
        double diff = budget - total;
        if (diff >= 0) {
            System.out.printf ("The money is enough - it would cost %.2flv.", total);
        } else {
            System.out.printf ("Ivan Cho will need %.2flv more.", Math.abs (diff));
        }

    }
}
