import java.util.Arrays;

public
class Article {
    private String title;
    private String content;
    private String author;

    public
    Article(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;

    }
    //metodi
    public  void edit(String newContent){
        this.content=newContent;
    }
    public void changeAuthor(String newAuthor){
        this.author=newAuthor;
    }
    public void rename(String newTitle){
        this.title=newTitle;
    }
//formatirame
    @Override
    public
    String toString () {
        return String.format ("%s - %s: %s", this.title,this.content,this.author);
    }
    //izlishno v tozi variant no vaji za ZIPa

    public String getTitle(){return this.title;}
    public String getContent(){return this.content;}
    public String getAuthor(){return this.author;}

    public
    void setTitle (String title) {
        this.title = title;
    }

    public
    void setContent (String content) {
        this.content = content;
    }

    public
    void setAuthor (String author) {
        this.author = author;
    }
}
