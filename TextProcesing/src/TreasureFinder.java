import java.util.Scanner;

public
class TreasureFinder {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String key = scanner.nextLine ();
        String input = scanner.nextLine ();
        key = key.replaceAll ("\\s+","");
        while (!input.equals ("find")){
            while (input.length ()>key.length ()){
               key = key.concat (key);
            }
            StringBuilder result = new StringBuilder ();
            for (int i = 0; i < input.length (); i++) {
                result.append ((char) (input.charAt (i)-Integer.parseInt (String.valueOf (key.charAt (i)))));
            }
            int startTreasureIndex = result.indexOf ("&")+1;
            int endTreasureIndex = result.lastIndexOf ("&");
            String treasure = result.substring (startTreasureIndex,endTreasureIndex);
            int startCoordinatesIndex = result.indexOf ("<")+1;
            int endCoordinatesIndex = result.indexOf (">");
            String coordinates = result.substring (startCoordinatesIndex,endCoordinatesIndex);

            System.out.printf ("Found %s at %s%n",treasure,coordinates);

            input = scanner.nextLine ();
        }
    }
}
