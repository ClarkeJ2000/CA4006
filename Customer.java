import java.util.*;
import java.util.random.*;

public class Customer extends Thread
{
    private String section;
    private  Random random;
    private int customerTicker = 10;
    private Shelf shelf;
    private int sleeptime;
    
    public Customer(Shelf shelf, int sleeptime)
    {
        this.random = new Random();
        this.shelf = shelf;
        this.sleeptime = sleeptime;
    }

    public class waitforbook
    {
        private String SectionName;
        
        public waitforbook(String SectionName)
        {
            this.SectionName = SectionName;
        }
    }


    public int getCustomerTick()
    {
        return customerTicker;
    }

   

    public void run()
    {
        //String SectionName = sections[0];
        //section = sections[random.nextInt(sections.length)];
        while(true){
            String section = shelf.getRandomSection();
            while(shelf.getNumBooks(section) == 0)
            {
                try{
                    System.out.println("Waiting for a book");
                    Thread.sleep(sleeptime);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Still waiting for book");
                }

            }
            


            if(shelf.getBook(section))
            {
                System.out.println("Customer took book from " + section);
                try{
                Thread.sleep(random.nextInt(100));
                }catch (InterruptedException e)
                {
                    System.out.println("Interupted while reading the book");
                }
            }
            else
            {
                System.out.println("Customer waiting for book in " + section);
                // shelf.isEmpty(section);
            }
        }
    }

}