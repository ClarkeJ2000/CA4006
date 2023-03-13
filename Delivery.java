import java.util.*;
import java.util.Random;
import java.util.List;


public class Delivery
{
    private final DeliveryBox deliveryBox;
    private final List<Section> sections;
    private final Random random; 

    public Delivery(DeliveryBox DeliveryBox, List<Section> sections)
    {
        this.DeliveryBox = DeliveryBox;
        this.sections = sections;
        this.random = new Random();
    }

    public void run()
    {
        while(true)
        {
            for(Section section : sections)
            {
                int numBooks = random.nextInt(10) + 1;
                List<Books> books = section.getBooks(numBooks);
                deliveryBox.putBooks(section.getName(), books);
            }

            int sleeptime = random.nextInt(5) +1;
            try{
                Thread.sleep(sleeptime * 1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}