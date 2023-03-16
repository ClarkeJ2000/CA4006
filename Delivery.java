import java.util.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Attributes.Name;


public class Delivery implements Runnable{
    // change the amount of sections here
    private static final int SECTIONS_COUNT = 6;
    private static final HashMap<String, Integer> Sections = new HashMap<String, Integer>();
    // You can add in more sections here
    private static final String bookCategories[] = {"Fiction", "Horror", "Romance", "Fantasy", "Poetry", "History"};
    //private Ticker ticker = new Ticker();
    private int CurrTime = 1;
    private Assistant assistant;
    private Assistant assistant1;
    // Set this to change the amount of books per delivery
    private int BOOKS_PER_DELIVERY = 10;
    // Set this to change the delivery probability
    private int DELIVERY_INTERVAL = 100;

    public Delivery(Assistant assistant1, Assistant assistant2){
        this.assistant = assistant1;
        this.assistant1 = assistant2;


    }

    public void SetTicker(int time){
        CurrTime = time;
        Random rand = new Random();
        // get random number for delivery probability
        int n = rand.nextInt(DELIVERY_INTERVAL + 1);
        if(n == 1){
            acceptDelivery();
        }
    }


    // sets the delivery status to true for the assistant
    public void ShareDelivery(){
        this.assistant.TrueDeliveryStatus(true, Sections);
    }

    public void acceptDelivery(){
        Sections.clear();
        int TotalValue = 0;
        // add books to shelf
        
        // assign to 11 to include 10
        int booksLeft = BOOKS_PER_DELIVERY + 1; 
        // loop until all books are delivered
        while (TotalValue < 10){
            // get random number of books to deliver
            Random random = new Random();
            int bookAmount = random.nextInt(booksLeft);
            if(bookAmount != 0){
                // get random section to deliver to
                int sectionName = random.nextInt(SECTIONS_COUNT);
                String Name = bookCategories[sectionName];
                if(Sections.containsKey(Name)){
                    Sections.put(Name, bookAmount);
                    TotalValue += bookAmount;
                }
                else{
                    Sections.put(Name, bookAmount);
                    TotalValue += bookAmount;
                    }
                }

                booksLeft -= bookAmount;
            }

        ShareDelivery();
        System.out.println("<Tick " + CurrTime + "> T<" + Thread.currentThread().getId() + "> Deposited a box of books");   
    }



    public void run(){
        
    } 
        

    }