import java.util.Scanner;

public
class ArticleMain {
    public static
    void main (String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] article = scanner.nextLine ().split (", ");

        String title   = article[0];
        String content = article[1];
        String author  = article[2];

        Article text = new Article (title, content, author);

        int n = Integer.parseInt (scanner.nextLine ());

        for (int i = 0; i < n; i++) {

            String[] command = scanner.nextLine ().split (" ", 2);

            if (command[0].equals ("Edit:")) {
                text.edit (command[1]);
            } else if (command[0].equals ("ChangeAuthor:")) {
                text.changeAuthor (command[1]);
            } else if (command[0].equals ("Rename:")) {
                text.rename (command[1]);
            }


        }
        System.out.println (text);


    }
}
