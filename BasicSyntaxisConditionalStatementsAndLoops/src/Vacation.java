import java.util.Scanner;

public
class Vacation {
    public static
    void main (String[] args) {
        Scanner scanner     = new Scanner (System.in);
        int     people      = Integer.parseInt (scanner.nextLine ());
        String  typeOfGroup = scanner.nextLine ();
        String  day         = scanner.nextLine ();

        double discount       = 1;
        double pricePerPerson = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        pricePerPerson = 8.45;
                        break;
                    case "Saturday":
                        pricePerPerson = 9.80;
                        break;
                    case "Sunday":
                        pricePerPerson = 10.46;
                        break;
                }
                if (people >= 30) {
                    discount = 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        pricePerPerson = 10.90;
                        break;
                    case "Saturday":
                        pricePerPerson = 15.60;
                        break;
                    case "Sunday":
                        pricePerPerson = 16;
                        break;

                }
                if (people >= 100) {
                    people = people - 10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        pricePerPerson = 15;
                        break;
                    case "Saturday":
                        pricePerPerson = 20;
                        break;
                    case "Sunday":
                        pricePerPerson = 22.50;
                        break;

                }
                if (10 <= people && people <= 20) {
                    discount = 0.95;
                }
                break;
        }
        double total = people * pricePerPerson * discount;
        System.out.printf ("Total price: %.2f", total);
    }
}
