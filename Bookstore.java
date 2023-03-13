import java.util.*;

public class Bookstore 
{
    private int ticks;
    private Map<String, Integer> sections;
    private Map<String, Integer> deliveryBox;

    public Bookstore()
    {
        this.ticks = 0;
        this.sections = new HashMap<String, Integer>();
        this.deliveryBox = new HashMap<String, Integer>();
    }

    public void addBook(String section, int quantity)
    {
        int current = this.sections.getOrDefault(section, 0);
        this.sections.put(section, current + quantity);
    }

    public void removeBook(String section, int quantity)
    {
        int current = this.sections.getOrDefault(section, 0);
        this.sections.put(section, Math.max(current - quantity, 0));
    }

    public void addtoDelivery(String book, int quantity)
    {
        int current = this.deliveryBox.getOrDefault(book, 0);
        this.deliveryBox.put(book, current + quantity);
    }

    public void removefromDelivery(String book, int quantity)
    {
        int current = this.deliveryBox.getOrDefault(book, 0);
        this.deliveryBox.put(book, Math.max(current -  quantity, 0));
    }

    public void ticks()
    {
        this.ticks++;
    }

    public int getticks()
    {
        return this.ticks;
    }

    public Map<String, Integer> ReturnSections()
    {
        return this.sections;
    }

    public Map<String, Integer> ReturnDeliveryBox()
    {
        return this.deliveryBox;
    }
}
