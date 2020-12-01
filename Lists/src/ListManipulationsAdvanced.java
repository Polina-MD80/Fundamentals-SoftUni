import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class ListManipulationsAdvanced {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream (scanner.nextLine ().split (" "))
                .map (Integer::parseInt).collect (Collectors.toList ());

        String commands = scanner.nextLine ();

        while (!commands.equals ("end")) {
            List<Integer> result = new ArrayList<> ();
            String[]      tokens = commands.split (" ");
            switch (tokens[0]) {
                case "Contains":
                    boolean containsNum = false;
                    int num = Integer.parseInt (tokens[1]);
                    for (Integer number : numbers) {
                        if (number == num) {
                            System.out.println ("Yes");
                            containsNum = true;
                            break;
                        }
                    }
                    if (!containsNum) {
                        System.out.println ("No such number");
                    }
                    break;
                case "Print":
                    switch (tokens[1]) {
                        case "even":
                            for (Integer number : numbers) {
                                if (number % 2 == 0) {
                                    result.add (number);
                                }
                            }
                            System.out.println (result.toString ().replaceAll ("[\\[\\],]", ""));
                            break;
                        case "odd":
                            for (Integer number : numbers) {
                                if (number % 2 != 0) {
                                    result.add (number);
                                }
                            }
                            System.out.println (result.toString ().replaceAll ("[\\[\\],]", ""));
                            break;
                    }
                    break;
                case "Get":
                    if (tokens[1].equals ("sum")) {
                        int sum = 0;
                        for (Integer number : numbers) {
                            sum += number;
                        }
                        System.out.println (sum);
                    }
                    break;
                case "Filter":
                    int constrain = Integer.parseInt (tokens[2]);
                    switch (tokens[1]) {
                        case ">":
                            for (Integer number : numbers) {
                                if (number > constrain) {
                                    result.add (number);
                                }
                            }
                            break;
                        case "<":
                            for (Integer number : numbers) {
                                if (number < constrain) {
                                    result.add (number);
                                }
                            }
                            break;
                        case ">=":
                            for (Integer number : numbers) {
                                if (number >= constrain) {
                                    result.add (number);
                                }
                            }
                            break;
                        case "<=":
                            for (Integer number : numbers) {
                                if (number <= constrain) {
                                    result.add (number);
                                }
                            }
                            break;
                    }

                    System.out.println (result.toString ().replaceAll ("[\\[\\],]", ""));
                    break;
            }


            commands = scanner.nextLine ();
        }
    }
}

