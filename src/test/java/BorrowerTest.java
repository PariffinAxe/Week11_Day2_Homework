import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

  private Borrower mike;
  private HashMap<String, String> book;

  @Before
  public void before(){
    mike = new Borrower("Mike");
    book = new HashMap<String, String>();
    book.put("title", "Of Mice & Men");
    book.put("author", "John Steinbeck");
    book.put("genre", "Fiction");
  }

  @Test
  public void hasBooks(){
    assertEquals(0, mike.countBooks());
  }

  @Test
  public void canBorrow(){
    mike.borrowsBook(book);
    assertEquals(1, mike.countBooks());
  }

  @Test
  public void canGiveBack(){
    mike.borrowsBook(book);
    mike.givesBookBack(book);
    assertEquals(0, mike.countBooks());
  }
}
