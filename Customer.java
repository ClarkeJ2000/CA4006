
//import java.util.*;
import java.util.Random;

public class Customer implements Runnable
{
    private Shelf shelf;
    private int CurrTime = 0;
    private static final int TickInterval = 100;
    private static final String bookCategories[] = {"Fiction", "Horror", "Romance", "Fantasy", "Poetry", "History"};

    public Customer(Shelf shelf)
    {
        this.random = new Random();
        this.shelf = shelf;
    }


    public void SetTicker(int Tick)
    {
        CurrTime = Tick;
    }
    
    public synchronized void run(){
        while(true){
            // get random section to get book from
            Random random = new Random();
            // get random section
            int sectionName = random.nextInt((bookCategories.length + 1) - 1);
            // If book is in section, remove it
            if(shelf.getBook(bookCategories[sectionName])){
                String CustomerBook = bookCategories[sectionName];
                try{
                    shelf.RemoveBook(CustomerBook);
                    System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Customer removed book from section " + bookCategories[sectionName]);
                    // sleep for 10 ticks
                    Thread.sleep(10 * TickInterval);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Still waiting for book");
                }
            }
            else{
                try{
                    // sleep for 2 ticks as a waiting system
                    Thread.sleep(2 * TickInterval);
            }
            catch (InterruptedException e)
            {
                System.out.println("Still waiting for book");
            }
        }
    }
}
}