public class Main implements Runnable{

    public int CURRENTTICK = 0;


    public static void main(String [] args)
    {
        Shelf shelf = new Shelf();
        Assistant assistant = new Assistant(shelf);
        Assistant assistant1 = new Assistant(shelf);
        Customer customer = new Customer(shelf);
        Delivery delivery = new Delivery(assistant, assistant1);
        Ticker ticker = new Ticker(delivery, assistant, assistant1, shelf, customer);


        Thread t1 = new Thread(ticker);
        Thread t2 = new Thread(delivery);
        Thread t3 = new Thread(assistant);
        Thread t4 = new Thread(assistant1);
        Thread t5 = new Thread(shelf);
        Thread t6 = new Thread(customer);

        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        
    }

    public void run(){
        System.out.println("Starting Main");}
}