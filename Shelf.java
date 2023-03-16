
import java.util.*;

public class Shelf implements Runnable
{
    private HashMap<String, Integer> BookSection = new HashMap<String, Integer>();
    private Delivery delivery;
    private int CurrTime = 0;
    

    public Shelf()
    {
        // this.delivery = delivery;
    }

    public Delivery getDelivery()
    {
            return this.delivery;
    }

    public void SetTicker(int time){
        CurrTime = time;
    }

    public void addBook(String section)
    {
        // if the section is not in the hashmap, add it
        int current = BookSection.getOrDefault(section, 0);
        BookSection.put(section, current + 1);
        System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant added book to " + section);
    }


    public Boolean getBook(String section)
    {
        if(BookSection.containsKey(section)){
            return true;
        }
        else{
            return false;
        }
    }

    public void RemoveBook(String section){
        // get the amount of books in the section
        int BookSectionAmount = BookSection.get(section);
        // remove one book from the section
        BookSection.put(section, BookSectionAmount - 1);

    }

     public void run(){
        
     }
}