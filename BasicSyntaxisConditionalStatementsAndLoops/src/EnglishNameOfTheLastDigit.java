import java.util.Scanner;

public
class EnglishNameOfTheLastDigit {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int     number  = Integer.parseInt (scanner.nextLine ());
        lastDigitInEnglish (number);
    }

    private static
    void lastDigitInEnglish (int n) {
        int lastDigit = n % 10;

        String[] inEnglish = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        System.out.println (inEnglish[lastDigit]);
    }
}

