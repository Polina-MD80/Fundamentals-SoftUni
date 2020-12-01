import java.util.Scanner;

public
class SpringVacationTrip {
    public static
    void main (String[] args) {
        Scanner scanner                   = new Scanner (System.in);
        int     days                      = Integer.parseInt (scanner.nextLine ());
        double  budget                    = Double.parseDouble (scanner.nextLine ());
        int     people                    = Integer.parseInt (scanner.nextLine ());
        double  fuelPerKm                 = Double.parseDouble (scanner.nextLine ());
        double  foodPricePerPerson        = Double.parseDouble (scanner.nextLine ());
        double  hotelPricePerPersonPerDay = Double.parseDouble (scanner.nextLine ());
        if (people > 10) {
            hotelPricePerPersonPerDay *= 0.75;
        }
        double dayExpenses   = days * people * (hotelPricePerPersonPerDay + foodPricePerPerson);
        double totalExpenses = 0;


        for (int i = 1; i <= days; i++) {
            double dailyTravelDist = Double.parseDouble (scanner.nextLine ());
            double currantDayExpenses = dayExpenses + dailyTravelDist*fuelPerKm;
            totalExpenses = totalExpenses + currantDayExpenses;
            if (i % 3 == 0 || i % 5 == 0) {
                totalExpenses += currantDayExpenses * 0.4;
            }
            if (i % 7 == 0) {
                totalExpenses -= totalExpenses / people;
            }
            if (budget < totalExpenses) {
                System.out.printf ("Not enough money to continue the trip. You need %.2f$ more.", totalExpenses - budget);break;
            }

        }
        double diff = budget - totalExpenses;
        if (diff >= 0) {
            System.out.printf ("You have reached the destination. You have %.2f$ budget left.", diff);


        }
    }
}
