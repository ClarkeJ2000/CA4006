import java.util.*;
import java.util.Random;


public class Delivery extends Thread{
    private static final int SECTIONS_COUNT = 6;
    private static final HashMap<String, Integer> Sections = new HashMap<String, Integer>();
    private static final String bookCategories[] = {"Fiction", "Horror", "Romance", "Fantasy", "Poetry", "History"};
    //private Ticker ticker = new Ticker();
    private int CurrTime = 0;
    //private Delivery delivery = new Delivery();

    public Delivery(){

    }
        

    public HashMap<String, Integer> getDelivery(){
        return Sections;
    }

    public void SetTicker(int time){
        System.out.println(time);
        CurrTime = time;
        if(CurrTime % 100 == 0){
            acceptDelivery();
        }
    }


    public void acceptDelivery(){
        // add books to shelf
        Random random = new Random();
        // assign to 11 to include 10
        int booksLeft = 11; 
        // loop until all books are delivered
        while (booksLeft > 1){
            // get random number of books to deliver
            int bookAmount = random.nextInt(booksLeft);
            // get random section to deliver to
            int sectionName = random.nextInt(SECTIONS_COUNT);
            Sections.put(bookCategories[sectionName], bookAmount);
            System.out.println(bookAmount + " books were delivered to " + bookCategories[sectionName] + " section");
            booksLeft -= bookAmount;
        }
        System.out.println("Delivery complete");   
    }


    @Override
    public void run(){
        }

    }
