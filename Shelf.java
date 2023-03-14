
import java.util.*;

public class Shelf extends Thread
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
        int current = BookSection.getOrDefault(section, 0);
        BookSection.put(section, current + 1);
        System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant added book to " + section);
    }

    public boolean getBook(String section)
    {
        int current = BookSection.getOrDefault(section, 0);
        if (current > 0)
        {
            BookSection.put(section, current - 1);
            return true;            
        }
        return false;
    }

    // public String[] getSection()
    // {
    //     Set<String> sections = Bookcount.keySet();
    //     String result = new String[sections.size()];
    //     sections.toArray(result);
    //     return result;
    // }

    public static Queue<String> CustomerLine(Queue<String> CustomerLine, String Customer)
    {
        CustomerLine.add(Customer);
        return CustomerLine;
    }
}