
import java.util.Scanner;


public
class WorldTour {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String  stops   = scanner.nextLine ();
        String  command = scanner.nextLine ();
        while (!"Travel".equals (command)) {
            String[] tokens = command.split (":");
            switch (tokens[0]) {
                case "Add Stop":
                    stops = addStop (stops, tokens);
                    break;
                case "Remove Stop":
                    stops = remove (stops, tokens);
                    break;
                case "Switch":
                    stops = switchStops (stops, tokens);
                    break;
            }


            command = scanner.nextLine ();
        }
        System.out.printf ("Ready for world tour! Planned stops: %s", stops);

    }

    private static
    String switchStops (String stops, String[] tokens) {
        if (stops.contains (tokens[1])) {
            stops = stops.replaceAll (tokens[1], tokens[2]);
        }
        System.out.println (stops);
        return stops;
    }

    private static
    String remove (String stops, String[] tokens) {
        int startIndex = Integer.parseInt (tokens[1]);
        int endIndex   = Integer.parseInt (tokens[2]);
        if (startIndex >= 0 && endIndex >= 0 && startIndex < stops.length () & endIndex < stops.length ()) {
            if (endIndex == stops.length ()-1) {
                stops = stops.substring (0, startIndex);
            } else {
                stops = stops.substring (0, startIndex) + stops.substring (endIndex + 1);
            }
        }
        System.out.println (stops);
        return stops;
    }

    private static
    String addStop (String stops, String[] tokens) {
        int index = Integer.parseInt (tokens[1]);
        if (index >= 0 && index < stops.length ()) {
            stops = stops.substring (0, index) + tokens[2] + stops.substring (index);
        }
        System.out.println (stops);
        return stops;
    }
}
