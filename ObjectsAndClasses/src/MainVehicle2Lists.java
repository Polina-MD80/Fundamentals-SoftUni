import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class MainVehicle2Lists {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String      input           = scanner.nextLine ();
        List<Car>   cars            = new ArrayList<> ();
        List<Truck> trucks          = new ArrayList<> ();
        int         carHorsePower   = 0;
        int         truckHorsePower = 0;

        while (!"End".equals (input)) {
            String[] tokens     = input.split (" ");
            String   type       = tokens[0];
            String   model      = tokens[1];
            String   colour     = tokens[2];
            int      horsePower = Integer.parseInt (tokens[3]);

            if ("car".equals (type)) {
                Car car = new Car (type, model, colour, horsePower);
                cars.add (car);
                carHorsePower += car.getHorsepower ();
            } else if ("truck".equals (type)) {
                Truck truck = new Truck (type, model, colour, horsePower);
                trucks.add (truck);
                truckHorsePower += truck.getHorsepower ();
            }


            input = scanner.nextLine ();

        }

        while (!"Close the Catalogue".equals (input)) {
            if (trucks.size () > 0) {
                for (Truck truck : trucks) {
                    if (truck.getModel ().equals (input) && "truck".equals (truck.getType ())) {
                        System.out.println (truck);
                    }
                }
            }
            if (cars.size () > 0) {
                for (Car car : cars) {
                    if (car.getModel ().equals (input) && "car".equals (car.getType ())) {
                        System.out.println (car);
                    }

                }

            }
            input = scanner.nextLine ();
        }
        if (cars.size () > 0) {
            double averageCarHorsePower = 1.0 * carHorsePower / cars.size ();
            System.out.printf ("Cars have average horsepower of: %.2f.%n", averageCarHorsePower);
        } else {
            System.out.println ("Cars have average horsepower of: 0.00");
        }
        if (trucks.size () > 0) {
            double averageTruckHorsePower = 1.0 * truckHorsePower / trucks.size ();
            System.out.printf ("Trucks have average horsepower of: %.2f.", averageTruckHorsePower);
        }else {
            System.out.println ("Truck have average horsepower of: 0.00");
        }

    }
}
