import java.util.ArrayList;
import java.util.HashMap;

public class Borrower {

  private String name;
  private ArrayList<HashMap<String, String>> books;

  public Borrower(String name){
    this.name = name;
    books = new ArrayList<HashMap<String, String>>();
  }

  public void borrowsBook(HashMap<String, String> book){
    books.add(book);
  }

  public void givesBookBack(HashMap<String, String> book){
    books.remove(book);
  }

  public int countBooks(){
    return books.size();
  }
}
