public class Book {


    private final String title;
    private final String author;
    private final int amountPages;
    private final int numberIsbn;


    public Book(String title, String author, int amountPages, int numberIsbn) {
        this.title = title;
        this.author = author;
        this.amountPages = amountPages;
        this.numberIsbn = numberIsbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public int getNumberIsbn() {
        return numberIsbn;
    }
}
