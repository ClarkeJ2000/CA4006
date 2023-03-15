public class main extends Thread{

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
        Assistant assistant1 = new Assistant(shelf);
        //Customer customer = new Customer(shelf);
        Delivery delivery = new Delivery(assistant, assistant1);
        Ticker ticker = new Ticker(delivery, assistant, assistant1, shelf);


        Thread t1 = new Thread(ticker);
        Thread t2 = new Thread(delivery);
        Thread t3 = new Thread(assistant);
        Thread t4 = new Thread(assistant1);
        Thread t5 = new Thread(shelf);

        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }

    public void run(){
        System.out.println("Starting Main");}
}