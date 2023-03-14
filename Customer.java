import java.util.*;
import java.util.random.*;

public class Customer implements Runnable
{
    private String section;
    private  Random random;
    private int customerTicker = 10;
    private Shelf shelf;

    public Customer(Shelf shelf)
    {
        this.random = new Random();
        this.shelf = shelf;
    }


    public int getCustomerTick()
    {
        return customerTicker;
    }

    public void run()
    {
        while(true)
        {
            String [] sections = shelf.getSection();
            section = sections[random.nextInt(sections.length)];

            if(shelf.getBook(section))
            {
                System.out.println("Customer took book from " + section);
                Thread.sleep(random.nextInt(100));
            }
            else
            {
                System.out.println("Customer waiting for book in " + section);
                shelf.isEmpty(section);
            }
        }
    }
}
