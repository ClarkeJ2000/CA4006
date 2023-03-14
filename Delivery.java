import java.util.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Attributes.Name;


public class Delivery extends Thread{
    private static final int SECTIONS_COUNT = 6;
    private static final HashMap<String, Integer> Sections = new HashMap<String, Integer>();
    private static final String bookCategories[] = {"Fiction", "Horror", "Romance", "Fantasy", "Poetry", "History"};
    //private Ticker ticker = new Ticker();
    private int CurrTime = 1;
    private Assistant assistant;

    public Delivery(Assistant assistant1){
        this.assistant = assistant1;
        System.out.println("Starting Delivery.....");

    }

    public void SetTicker(int time){
        CurrTime = time;
        if(CurrTime % 100 == 0){
            acceptDelivery();
            // DeliveryAvailable = value.set(1);
        }
    }


    public void ShareDelivery(){
        this.assistant.TrueDeliveryStatus(true);
        this.assistant.StockShelves(Sections);
    }
    // public void DeliveryCollected(){
    //     DeliveryAvailable = false;
    // }


    public void acceptDelivery(){
        Sections.clear();
        // add books to shelf
        Random random = new Random();
        // assign to 11 to include 10
        int booksLeft = 11; 
        // loop until all books are delivered
        while (booksLeft > 1){
            // get random number of books to deliver
            int bookAmount = random.nextInt(booksLeft);
            if(bookAmount != 0){
                // get random section to deliver to
                int sectionName = random.nextInt(SECTIONS_COUNT);
                String Name = bookCategories[sectionName];
                if(Sections.containsKey(Name)){
                    Sections.put(Name, bookAmount + 1);
                }
                else{
                    Sections.put(Name, bookAmount);
                    }
                }
                //System.out.println(bookAmount + " books were delivered to " + bookCategories[sectionName] + " section");
                booksLeft -= bookAmount;
            }

        ShareDelivery();
        System.out.println("Delivery complete");   
    }



    public void run(){
        
    } 
        

    }
