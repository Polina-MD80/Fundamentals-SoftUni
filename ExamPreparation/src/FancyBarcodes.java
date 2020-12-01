import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public
class FancyBarcodes {
    public static
    void main (String[] args) {
        Scanner scanner        = new Scanner (System.in);
        int     n              = Integer.parseInt (scanner.nextLine ());
        String  barcodeRegex   = "(@#+)([A-Z][A-Za-z\\d]{4,}[A-Z])(@#+)";
        String  digitRegex     = "\\d";
        Pattern barcodePattern = Pattern.compile (barcodeRegex);
        Pattern digitPattern   = Pattern.compile (digitRegex);

        for (int i = 0; i < n; i++) {
            String  input        = scanner.nextLine ();
            Matcher barcode      = barcodePattern.matcher (input);
            String  productGroup = "";
            if (barcode.find ()) {
                Matcher digit = digitPattern.matcher (input);
                while (digit.find ()) {
                    String newDigit = digit.group ();
                    productGroup = productGroup + newDigit;
                }

                if (productGroup.length () == 0) {
                    productGroup = "00";
                }
                System.out.println ("Product group: " + productGroup);
            } else {
                System.out.println ("Invalid barcode");
            }
        }

    }
}
