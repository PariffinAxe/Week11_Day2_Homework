import java.util.ArrayList;
import java.util.HashMap;

public class Library {

  private String name;
  private int capacity;
  private ArrayList<HashMap<String, String>> books;
  private HashMap<String, Integer> genres;

  public Library(String name, int capacity){
    this.name = name;
    this.capacity = capacity;
    books = new ArrayList<HashMap<String, String>>();
    genres = new HashMap<String, Integer>();
  }

  public int countBooks(){
    return books.size();
  }

  public void addBook(String title, String author, String genre){
    if (countBooks() < capacity) {
      HashMap<String, String> book = new HashMap<String, String>();
      book.put("title", title);
      book.put("author", author);
      book.put("genre", genre);
      books.add(book);
      int number = 1;
      if (genres.containsKey(genre)){
        number = genres.get(genre) + 1;
      }
      genres.put(genre, number);
    }
  }

  public void bookBorrowed(Borrower person, String bookTitle){
    HashMap<String, String> borrowedBook = null;
    for (HashMap<String, String> book : books){
      if (book.get("title").toString() == bookTitle){
        borrowedBook = book;
        break;
      }
    }
    if (borrowedBook != null){
      person.borrowsBook(borrowedBook);
      books.remove(borrowedBook);
      String genre = borrowedBook.get("genre");
      genres.put(genre, genres.get(genre)-1);
    }
  }

  public void bookReturned(Borrower person, HashMap<String, String> book){
    if (countBooks() < capacity){
      books.add(book);
      person.givesBookBack(book);
    }
  }

  public int getGenres(String genre) {
    if (genres.containsKey(genre)){
      return genres.get(genre);
    }
    return 0;
  }
}
