import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public
class NeedForSpeedIII {
    public static
    void main (String[] args) {
        Scanner            scanner = new Scanner (System.in);
        int                n       = Integer.parseInt (scanner.nextLine ());
        Map<String, int[]> cars    = new TreeMap<> ();

        for (int i = 0; i < n; i++) {
            String[] parts   = scanner.nextLine ().split ("\\|");
            int[]    carData = new int[2];
            String   car     = parts[0];
            carData[0] = Integer.parseInt (parts[1]);
            carData[1] = Integer.parseInt (parts[2]);
            cars.put (car, carData);
        }
        String command = scanner.nextLine ();
        while (!"Stop".equals (command)) {
            String[] tokens = command.split (" : ");
            switch (tokens[0]) {
                case "Drive":
                    drive (cars, tokens);
                    break;
                case "Refuel":
                    refuel (cars, tokens);
                    break;
                case "Revert":
                    revert(cars,tokens);
                    break;
            }
            command = scanner.nextLine ();
        }
        cars.entrySet ()
                .stream ()
                .sorted ((c1,c2)->Integer.compare (c2.getValue ()[0],c1.getValue ()[0]))
                .forEach (c-> System.out.printf ("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        c.getKey (),c.getValue ()[0],c.getValue ()[1]));

    }

    private static
    void revert (Map<String,int[]> cars, String[] tokens) {
        String car = tokens[1];
        int kilometersToRevert = Integer.parseInt (tokens[2]);
        int kilometers = cars.get (car)[0] - kilometersToRevert;
        if (kilometers<10000){
            cars.get (car)[0]=10000;
        }else {
            cars.get (car)[0] = kilometers;
            System.out.printf ("%s mileage decreased by %d kilometers%n", car, kilometersToRevert);
        }
    }

    private static
    void refuel (Map<String, int[]> cars, String[] tokens) {
        String car          = tokens[1];
        int    fuelToRefuel = Integer.parseInt (tokens[2]);
        int    fuel         = cars.get (car)[1] + fuelToRefuel;
        if (fuel > 75) {
            fuelToRefuel = fuelToRefuel - (fuel - 75);
            fuel = 75;
        }
        cars.get (car)[1] = fuel;
        System.out.printf ("%s refueled with %d liters%n", car, fuelToRefuel);


    }

    private static
    void drive (Map<String, int[]> cars, String[] tokens) {
        String car                 = tokens[1];
        int    kilometers          = Integer.parseInt (tokens[2]);
        int    consumptionPerDrive = Integer.parseInt (tokens[3]);
        if (cars.get (car)[1] < consumptionPerDrive) {
            System.out.println ("Not enough fuel to make that ride");
        } else {
            cars.get (car)[0] = cars.get (car)[0] + kilometers;
            cars.get (car)[1] = cars.get (car)[1] - consumptionPerDrive;
            System.out.printf ("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, kilometers, consumptionPerDrive);
            if (cars.get (car)[0] >= 100000) {
                System.out.printf ("Time to sell the %s!%n",car);
                cars.remove (car);
            }
        }
    }
}
