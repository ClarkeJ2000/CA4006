public class Ticker extends Thread{

    private static final int TICKS_PER_DAY = 1000;
    // Change the tick interval here
    private static final int DELIVERY_TICK_INTERVAL = 100;
    public int CURRENTTICK = 0;

    private Delivery delivery;

    public Ticker(Delivery Currdelivery){
        this.delivery = Currdelivery;
        System.out.println("Staring Ticker.....");
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

    private void ShareTick(){
        this.delivery.SetTicker(CURRENTTICK);

    }

    @Override
    public void run() {
        for (int i = 0; i < TICKS_PER_DAY; i++) {
            try {

                Thread.sleep(DELIVERY_TICK_INTERVAL);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CURRENTTICK++;
            ShareTick();
            System.out.println("Tick " + CURRENTTICK + " Thread " + Thread.currentThread().getId());
        }
        
    }
    // // main function for testing class individually
    // public static void main(String[] args) {
    //     Ticker ticker = new Ticker();
    //     ticker.start();
    // }    
}
