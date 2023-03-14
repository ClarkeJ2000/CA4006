public class Main extends Thread{

    // constants for simulation params
    private static final int TICKS_PER_DAY = 1000;
    private static final int DELIVERY_TICK_INTERVAL = 100;
    private static final int BOOKS_PER_DELIVERY = 10;
    private static final int SECTIONS_COUNT = 6;
    private static final int CUSTOMER_TICK_INTERVAL = 10;
   
    public int CURRENTTICK = 0;


    public static void main(String [] args)
    {
        Shelf shelf = new Shelf();
        Assistant assistant = new Assistant(shelf);
        Delivery delivery = new Delivery(assistant);
        Ticker ticker = new Ticker(delivery);
        
        delivery.run();
        ticker.run();
        
    }

    public void run(){
        System.out.println("Starting Main");}
}