
import java.util.*;

public class Shelf extends Thread
{
    private HashMap<String, Integer> BookSection = new HashMap<String, Integer>();
    private Delivery delivery;
    

    public Shelf()
    {
        // this.delivery = delivery;
    }

    public Delivery getDelivery()
    {
            return this.delivery;
    }

    public void addBook(String section)
    {
        int current = BookSection.getOrDefault(section, 0);
        BookSection.put(section, current + 1);
        System.out.println("Book added to " + section + " section");
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

    public static Queue<String> CustomerLine(Queue<String> CustomerLine, String Customer)
    {
        CustomerLine.add(Customer);
        return CustomerLine;
    }
}