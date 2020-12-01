import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public
class Article2Main {
    public static
    void main (String[] args) {

        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt (scanner.nextLine ());

        List<Article> articles = new ArrayList<> ();

        for (int i = 0; i < n; i++) {
            String[] text = scanner.nextLine ().split (", ");

            String title = text[0];
            String content = text[1];
            String author = text[2];

            Article article = new Article (title, content,author);

            articles.add (article);

        }
        String command = scanner.nextLine ();

        switch (command){
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;

        }
        for (Article article : articles) {
            System.out.println (article);
        }
    }
}
