import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ListManipulation {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                      .map (Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine ();

        while (!commands.equals ("end")){
            String[]tokens = commands.split (" ");
            int secondCommand = Integer.parseInt (tokens[1]);
            switch (tokens[0]){
                case "Add":
                    numbers.add (secondCommand);
                    break;
                case "Remove":
                    numbers.remove (Integer.valueOf (secondCommand));
                    break;
                case "RemoveAt":
                    numbers.remove (secondCommand);
                    break;
                case "Insert":
                    int thirdCommand = Integer.parseInt (tokens[2]);
                    numbers.add (thirdCommand,secondCommand);
            }


            commands = scanner.nextLine ();
        }

        System.out.println (numbers.toString ().replaceAll("[\\[\\],]", ""));
    }
}
