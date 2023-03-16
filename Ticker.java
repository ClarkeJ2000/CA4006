public class Ticker implements Runnable{

    // Change the ticks per day here
    private static final int TICKS_PER_DAY = 1000;
    // Change the tick interval here (100 = 0.1 seconds, 1000 = 1 second etc)
    private static final int DELIVERY_TICK_INTERVAL = 100;
    public int CURRENTTICK = 0;

    private Delivery delivery;
    private Assistant assistant;
    private Assistant assistant1;
    private Shelf shelf;
    private Customer customer;

    public Ticker(Delivery Currdelivery, Assistant currAssistant, Assistant curAssistant1, Shelf currShelf, Customer currCustomer){
        this.delivery = Currdelivery;
        this.assistant = currAssistant;
        this.assistant1 = curAssistant1;
        this.shelf = currShelf;
        this.customer = currCustomer;

    }


    public int getCurrentTick() {
        if (CURRENTTICK > 0){
            System.out.println("Current tick " + CURRENTTICK);
            return CURRENTTICK;
        }
        else{
            return 1;
        }
    }

    // Share the current tick to all classes
    private void ShareTick(){
        this.delivery.SetTicker(CURRENTTICK);
        this.assistant.SetTicker(CURRENTTICK);
        this.assistant1.SetTicker(CURRENTTICK);
        this.shelf.SetTicker(CURRENTTICK);
        this.customer.SetTicker(CURRENTTICK);

    }

    @Override
    public void run() {
        for (int i = 0; i < TICKS_PER_DAY; i++) {
            try {

                // sleep for the tick interval
                Thread.sleep(DELIVERY_TICK_INTERVAL);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CURRENTTICK++;
            ShareTick();
            System.out.println("<Tick " + CURRENTTICK + "> " +  "<T" + Thread.currentThread().getId() + ">");
        }
        
    }
    // // main function for testing class individually
    // public static void main(String[] args) {
    //     Ticker ticker = new Ticker();
    //     ticker.start();
    // }    
}
