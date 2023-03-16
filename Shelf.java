
import java.util.*;

public class Shelf implements Runnable
{
    private HashMap<String, Integer> BookSection = new HashMap<String, Integer>();
    private HashMap<String, Integer> Bookcount;
    private HashMap<String, Integer> sections;
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

    public String[] getRandomSection()
    {
        Set<String> sectionKey = sections.keySet();
        String[] result = sectionKey.toArray(new String[sectionKey.size()]);
        Random random = new Random();
        int index = random.nextInt(result.length);
        return new String[] {result[index]};
    }

    public static Queue<String> CustomerLine(Queue<String> CustomerLine, String Customer)
    {
        CustomerLine.add(Customer);
        return CustomerLine;
    }

    public void run(){
        
    }
}