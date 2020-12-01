import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public
class VehicleMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Vehicle> vehicles = new ArrayList<> ();

        String input = scanner.nextLine ();

        int carCount = 0;
        int carHorsePower = 0;
        int truckCount = 0;
        int truckHorsePower =0;


        while (!"End".equals (input)){
            String[] tokens = input.split ("\\s+");
            String   type       = tokens[0];
            String   model      = tokens[1];
            String   colour     = tokens[2];
            int      horsePower = Integer.parseInt (tokens[3]);

            Vehicle vehicle = new Vehicle (type,model,colour,horsePower);
            vehicles.add (vehicle);
            if ("car".equals (type)){
                carCount++;
                carHorsePower+=horsePower;

            }else if ("truck".equals (type)){
                truckCount++;
                truckHorsePower+=horsePower;

            }


            input = scanner.nextLine ();
        }
        while (!"Close the Catalogue".equals (input)){

            for (Vehicle vehicle : vehicles) {
                if (input.equals (vehicle.getModel ())){
                    System.out.println (vehicle);
                }
            }

            input = scanner.nextLine ();
        }
        double averageCarHorsePower = 0;
        double averageTruckHorsePower = 0;

        if (carCount>0){
            averageCarHorsePower = 1.0*carHorsePower/carCount;
        }
        if (truckCount>0){
            averageTruckHorsePower = 1.0*truckHorsePower/truckCount;
        }
        System.out.printf ("Cars have average horsepower of: %.2f.%n", averageCarHorsePower);
        System.out.printf ("Trucks have average horsepower of: %.2f.", averageTruckHorsePower);
    }
}
