import java.util.*;

public class Shelf extends Thread
{
    private HashMap<String, Integer> BookSection = new HashMap<String, Integer>();
    private Delivery delivery;
    private HashMap<String, Integer> Bookcount;
    private HashMap<String, Integer> sections;
    

    public Shelf(Delivery delivery)
    {
        this.delivery = delivery;
    }

    public Delivery getDelivery()
    {
            return this.delivery;
    }

    public void addBook(String section)
    {
        int current = BookSection.getOrDefault(section, 0);
        BookSection.put(section, current + 1);
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
}