import java.util.Scanner;

public
class ExtractFile {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        String[] tokens = scanner.nextLine ().split ("\\\\");
        String[] fileWithExtension = tokens[tokens.length-1].split ("\\.");
        System.out.println ("File name: "+fileWithExtension[0]);
        System.out.println ("File extension: "+fileWithExtension[1]);

    }
}
