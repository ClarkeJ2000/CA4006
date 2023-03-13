import java.util.Random;
import java.util.*;

public class Book
{
    String Category;


    public void Category()
    {
        System.out.println("The category of this book is " + Category);
    }

    public void setCategory()
    {
        Category = findCategory();
    }

    public static String findCategory()
    {
        List<String> categories = new ArrayList<String>();
        categories.add("Horror");
        categories.add("Poetry");
        categories.add("History");
        categories.add("Fiction");

        Random random = new Random();
        int x = categories.size();
        int i = random.nextInt(x);

        String BookCategory = categories.get(i);
        return BookCategory;
    }


    public static void main(String[] args)
    {
        Book book = new Book();
        book.setCategory();
    }
}