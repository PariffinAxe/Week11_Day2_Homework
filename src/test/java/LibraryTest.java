import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

  private Library library;
  private Borrower mike;
  private HashMap<String, String> book1;

  @Before
  public void before(){
    library = new Library("Mitchel St", 3);
    mike = new Borrower("Mike");
    book1 = new HashMap<String, String>();
    book1.put("title", "1984");
    book1.put("author", "George Orwell");
    book1.put("genre", "Fiction");
    library.addBook("Of Mice & Men", "John Steinbeck", "Fiction");
    library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
  }

  @Test
  public void hasBooks(){
    assertEquals(2, library.countBooks());
  }

  @Test
  public void canAddBooks(){
    library.addBook("Of Mice & Men", "John Steinbeck", "Fiction");
    assertEquals(3, library.countBooks());
  }

  @Test
  public void cantAddTooMany(){
    library.addBook("Of Mice & Men", "John Steinbeck", "Fiction");
    library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
    assertEquals(3, library.countBooks());
  }

  @Test
  public void bookIsBorrowed(){
    library.addBook("1984", "George Orwell", "Fiction");
    library.bookBorrowed(mike, "1984");
    assertEquals(2, library.countBooks());
    assertEquals(1, mike.countBooks());
  }

  @Test
  public void bookNotBorrowedIfNotFound(){
    library.bookBorrowed(mike, "1984");
    assertEquals(2, library.countBooks());
    assertEquals(0, mike.countBooks());
  }

  @Test
  public void bookReturned(){
    library.addBook("1984", "George Orwell", "Fiction");
    library.bookBorrowed(mike, "1984");
    library.bookReturned(mike, book1);
    assertEquals(3, library.countBooks());
    assertEquals(0, mike.countBooks());
  }

  @Test
  public void hasGenres(){
    assertEquals(2, library.getGenres("Fiction"));
  }

  @Test
  public void hasGenresAfterBorrow(){
    library.bookBorrowed(mike, "The Great Gatsby");
    assertEquals(1, library.getGenres("Fiction"));
  }

  @Test
  public void doesNotHaveGenre(){
    assertEquals(0, library.getGenres("Non"));
  }
}
