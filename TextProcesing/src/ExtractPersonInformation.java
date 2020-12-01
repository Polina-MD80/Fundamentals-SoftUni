import java.util.Scanner;

public
class ExtractPersonInformation {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        //3
        //random name @lilly| random digits #5* age
        //@Marry| with age #19*
        //here Comes @Garry| he is #48* years old
        int n = Integer.parseInt (scanner.nextLine ());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine ();
            int nameStartIndex = text.indexOf ("@")+1;
            int nameEndIndex = text.indexOf ("|");
            int ageStartIndex = text.indexOf ("#")+1;
            int ageEndIndex = text.indexOf ("*");
            //George is 18 years old.
            //Billy is 35 years old.
            String name = text.substring (nameStartIndex,nameEndIndex);
            String age = text.substring (ageStartIndex,ageEndIndex);
            System.out.println (String.format ("%s is %s years old.", name,age));
        }
    }
}
