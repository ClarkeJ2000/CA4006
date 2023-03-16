import java.util.*;

public class Shelf extends Thread
{
    private HashMap<String, Integer> BookSection = new HashMap<String, Integer>();
    private Delivery delivery;
    private HashMap<String, Integer> Bookcount;
    private HashMap<String, Integer> sections;
    private List <Book> books;
    

    public Shelf(Delivery delivery)
    {
        this.delivery = delivery;
    }

    public Delivery getDelivery()
    {
            return this.delivery;
    }

    public int getNumBooks(String section) 
    {
        if (!sections.containsKey(section))
        {
            return 0;
        }
        return sections.get(section);
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

    public String getRandomSection()
    {
        if(sections.isEmpty())
            {
                return null;
            }
        //convert to array to get random element
        String[] SectionName = sections.keySet().toArray(new String[0]);
        
        //generate a random index
        Random random = new Random();
        int index = random.nextInt(SectionName.length);

        //return a random section name
        return SectionName[index];
    }

    public static Queue<String> CustomerLine(Queue<String> CustomerLine, String Customer)
    {
        CustomerLine.add(Customer);
        return CustomerLine;
    }
}