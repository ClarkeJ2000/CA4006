import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Executors;


public class Main extends Thread{

    // constants for simulation params
    private static final int TICKS_PER_DAY = 1000;
    private static final int DELIVERY_TICK_INTERVAL = 100;
    private static final int BOOKS_PER_DELIVERY = 10;
    private static final int SECTIONS_COUNT = 6;
    private static final int CUSTOMER_TICK_INTERVAL = 10;
    private static final int MAX_BOOKS_PER_ASSISTANT = 10;
    private static final int ASSISTANT_WALK_TIME_PER_BOOK = 1;
    private static final int ASSISTANT_WALK_TIME_TO_DELIVERY = 10;
    private static final int ASSISTANT_WALK_TIME_BETWEEN_SECTIONS = 10;
    public int CURRENTTICK = 0;


   
    private Delivery delivery = new Delivery();
    private Ticker ticker = new Ticker(delivery);
    

    public void run(){
        delivery.start();
        ticker.start();
    }

    public static void main(String [] args)
    {
        Main main = new Main();
        main.start();


    }
}