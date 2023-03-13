import java.util.Random;
import java.util.*;

public class Customer 
{
    private final Bookstore bookstore;
    private final Random random;

    public Customer(Bookstore bookstore)
    {
        this.bookstore = bookstore;
        this.random = new Random();
    }


    public void run()
    {
        while(true)
        {
            /* Picks a random section to check for a book */
            Section section = Section.values()[random.nextInt(Section.values().length)];
            Book book = bookstore.buyBook(section);
        }
    }
}