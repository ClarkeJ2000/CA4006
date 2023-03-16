
//import java.util.*;
import java.util.Random;

public class Customer implements Runnable
{
    private String section;
    private  Random random;
    private int customerTicker = 10;
    private Shelf shelf;
    private int CurrTime = 0;

    public Customer(Shelf shelf)
    {
        this.random = new Random();
        this.shelf = shelf;
    }


    public void SetTicker(int Tick)
    {
        CurrTime = Tick;
    }

    // public void TakeBook(){
    //     String[] book = shelf.getRandomSection();
    //     System.out.println(book);
    //     //shelf.getBook(book);


    // }

    public void run()
    {
        while(true)
        {
            String tst[] = shelf.getRandomSection();
            System.out.println(tst);
            // if(shel)
            // {
            //     String [] sections = shelf.getRandomSection();
            //     section = sections[random.nextInt(sections.length)];

            //     System.out.println("Customer took book from " + section);
            //     try{
            //         Thread.sleep(100);
            //     }
            //     catch(InterruptedException e){
            //         e.printStackTrace();
            //     }
            // }
            // else
            // {
            //     System.out.println("Customer waiting for book in " + section);
            //     //shelf.isEmpty(section);
            // }
        }
    }
}