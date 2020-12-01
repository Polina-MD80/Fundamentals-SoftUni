import java.util.Scanner;

public
class ComputerStore {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input      = scanner.nextLine ();
        double sumWOTaxes = 0;
        while (!"special".equals (input) && !"regular".equals (input)) {
            double pricePerPart = Double.parseDouble (input);
            if (pricePerPart < 0) {
                System.out.println ("Invalid price!");
                input = scanner.nextLine ();
                continue;
            } else {
                sumWOTaxes += pricePerPart;
            }


            input = scanner.nextLine ();
        }
        if (sumWOTaxes == 0) {
            System.out.println ("Invalid order!");
            return;
        } else
            System.out.println ("Congratulations you've just bought a new computer!");
        double taxes      = 0.2 * sumWOTaxes;
        double totalPrise = taxes + sumWOTaxes;
        double discount   = 0;
        switch (input) {
            case "regular":
                discount = 1;
                break;
            case "special":
                discount = 0.9;
                break;
        }
        System.out.printf ("Price without taxes: %.2f$%n", sumWOTaxes);
        System.out.printf ("Taxes: %.2f$%n", taxes);
        System.out.println ("-----------");
        System.out.printf ("Total price: %.2f$", totalPrise * discount);


    }
}
