import java.util.Map;
import java.util.Scanner;

public
class CharacterMultiplier {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] words  = scanner.nextLine ().split (" ");
        String   first  = words[0];
        String   second = words[1];

        int sum = 0;

        System.out.println (characterMultiplierInSum (first, second));
    }

    private static
    int characterMultiplierInSum (String first, String second) {
        int result = 0;
        for (int i = 0; i < Math.min (first.length (), second.length ()); i++) {
            result = result + first.charAt (i) * second.charAt (i);
        }
        if (first.length () != second.length ()) {
            int additive=0;
            if (first.length () > second.length ()) {
                additive = additionalSumOfLongerWord (first, second);
            } else {
                additive = additionalSumOfLongerWord (second, first);
            }
            result += additive;
        }
        return result;

    }

    private static
    int additionalSumOfLongerWord (String longer, String shorter) {
        int additive = 0;
        for (int i = shorter.length (); i < longer.length (); i++) {
            additive = additive + longer.charAt (i);
        }
        return additive;
    }
}
