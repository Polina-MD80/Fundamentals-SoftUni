import java.util.Arrays;
import java.util.Scanner;

public
class AngryPet {
    public static
    void main (String[] args) {
        Scanner scanner     = new Scanner (System.in);
        int[]   prices      = Arrays.stream (scanner.nextLine ().split ("\\s+")).mapToInt (Integer::parseInt).toArray ();
        int     entryPoint  = Integer.parseInt (scanner.nextLine ());
        String  value       = scanner.nextLine ();
        String  sign        = scanner.nextLine ();
        int     leftDamage  = 0;
        int     rightDamage = 0;

        switch (value) {
            case "cheap":
                for (int i = 0; i < entryPoint; i++) {
                    if (prices[i] < prices[entryPoint]) {
                        switch (sign) {
                            case "all":
                                leftDamage += prices[i];
                                break;
                            case "positive":
                                if (prices[i] >= 0) {
                                    leftDamage += prices[i];
                                }
                                break;
                            case "negative":
                                if (prices[i] < 0) {
                                    leftDamage += prices[i];
                                }
                                break;
                        }
                    }
                }
                for (int i = entryPoint + 1; i < prices.length; i++) {
                    if (prices[i] < prices[entryPoint]) {
                        switch (sign) {
                            case "all":
                                rightDamage += prices[i];
                                break;
                            case "positive":
                                if (prices[i] >= 0) {
                                    rightDamage += prices[i];
                                }
                                break;
                            case "negative":
                                if (prices[i] < 0) {
                                    rightDamage += prices[i];
                                }
                                break;
                        }
                    }
                }
                break;
            case "expensive":
                for (int i = 0; i < entryPoint; i++) {
                    if (prices[i] >= prices[entryPoint]) {
                        switch (sign) {
                            case "all":
                                leftDamage += prices[i];
                                break;
                            case "positive":
                                if (prices[i] > 0) {
                                    leftDamage += prices[i];
                                }
                                break;
                            case "negative":
                                if (prices[i] < 0) {
                                    leftDamage += prices[i];
                                }
                                break;
                        }
                    }
                }
                for (int i = entryPoint + 1; i < prices.length; i++) {
                    if (prices[i] >= prices[entryPoint]) {
                        switch (sign) {
                            case "all":
                                rightDamage += prices[i];
                                break;
                            case "positive":
                                if (prices[i] > 0) {
                                    rightDamage += prices[i];
                                }
                                break;
                            case "negative":
                                if (prices[i] < 0) {
                                    rightDamage += prices[i];
                                }
                                break;
                        }
                    }
                }


                break;
        }
        if (leftDamage >= rightDamage) {
            System.out.printf ("Left - %d", leftDamage);
        } else {
            System.out.printf ("Right - %d", rightDamage);
        }

    }
}
