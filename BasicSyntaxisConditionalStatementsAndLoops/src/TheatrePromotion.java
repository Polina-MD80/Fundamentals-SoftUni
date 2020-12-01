import java.util.Scanner;

public
class TheatrePromotion {
    public static
    void main (String[] args) {
        Scanner scanner   = new Scanner (System.in);
        String  typeOfDay = scanner.nextLine ();
        int     age       = Integer.parseInt (scanner.nextLine ());
        int     price     = 0;
        boolean error = false;


        if (0 <= age && age <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
            }
        } else if (18 < age && age <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
            }
        } else if (64 < age && age <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
            }
        }if (price==0){
            System.out.println ("Error");
        }else {
            System.out.printf ("%d$",price);
        }
    }
}
