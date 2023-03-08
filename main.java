import java.util.*;

public class Book
{
    String Category;


    public void Category()
    {
        System.out.println("The category of this book is " + Category);
    }

    public static String setCategory()
    {
        List<String> categories = new ArrayList<String>();
        categories.add("Horror");
        categories.add("Poetry");
        categories.add("History");
        categories.add("Fiction");
    }
}

public class Main{
    public static void main(String [] args)
    {

    }
}