import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public
class SchoolLibrary {
    public static
    void main (String[] args) {
        Scanner      scanner   = new Scanner (System.in);
        List<String> bookShelf = Arrays.stream (scanner.nextLine ().split ("&")).collect (Collectors.toList ());

        String command = scanner.nextLine ();

        while (!"Done".equals (command)) {
            String[] tokens = command.split (" \\| ");
            switch (tokens[0]) {
                case "Add Book":
                    addBook (bookShelf, tokens[1]);
                    break;
                case "Take Book":
                    takeBook (bookShelf, tokens[1]);
                    break;
                case "Swap Books":
                    swapBook (bookShelf, tokens);
                    break;
                case "Insert Book":
                    bookShelf.add (tokens[1]);
                    break;
                case "Check Book":
                    checkBook (bookShelf, tokens[1]);
                    break;
            }

            command = scanner.nextLine ();
        }
        System.out.println (String.join (", ", bookShelf));


    }

    private static
    void checkBook (List<String> bookShelf, String token) {
        int index = Integer.parseInt (token);
        if (index >= 0 && index < bookShelf.size ()) {
            System.out.println (bookShelf.get (index));
        }
    }

    private static
    void swapBook (List<String> bookShelf, String[] tokens) {
        String book1 = tokens[1];
        String book2 = tokens[2];
        if (bookShelf.contains (book1) && bookShelf.contains (book2)) {

            int index1 = bookShelf.indexOf (book1);
            int index2 = bookShelf.indexOf (book2);
            bookShelf.set (index1, book2);
            bookShelf.set (index2, book1);

        }
    }

    private static
    void takeBook (List<String> bookShelf, String token) {
        bookShelf.remove (token);
    }

    private static
    void addBook (List<String> bookShelf, String token) {
        String currantBook = token;
        if (!bookShelf.contains (currantBook)) {
            bookShelf.add (0, currantBook);
        }
    }
}
