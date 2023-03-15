import java.util.HashMap;

public class Assistant implements Runnable{
    private static final int BOOKS_PER_DELIVERY = 10;
    private static final int MAX_BOOKS_PER_ASSISTANT = 10;
    private static final int ASSISTANT_WALK_TIME_PER_BOOK = 1;
    private static final int ASSISTANT_PLACE_BOOK = 1;
    private static final int ASSISTANT_WALK_TIME_TO_DELIVERY = 10;
    private static final int ASSISTANT_WALK_TIME_BETWEEN_SECTIONS = 10;
    private static final int TICKER_TIME = 100;
    private static HashMap<String, Integer> DeliveryBox = new HashMap<String, Integer>();
    private static final HashMap<String, Integer> BooksCarried = new HashMap<String, Integer>();
    private int CurrTime = 0;
    private boolean AssistantBusy = false;
    private volatile boolean DeliveryAvailable = false;
    public Shelf shelf;

    public Assistant(Shelf Inputshelf){
        this.shelf = Inputshelf;
    }

    public void SetTicker(int time){
        CurrTime = time;
    }

    public void TrueDeliveryStatus(boolean status, HashMap<String, Integer> received){
        DeliveryAvailable = status;
        DeliveryBox.putAll(received);
    }

    public void StockShelves(HashMap<String, Integer> received){
        BooksCarried.clear();
        if(AssistantBusy == false){
            try {
                AssistantBusy = true;
                System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant1 collected " + DeliveryBox.values().size() + " books: " + DeliveryBox);
                Thread.sleep(ASSISTANT_WALK_TIME_TO_DELIVERY * TICKER_TIME);
                for (String section : received.keySet()) {
                    int books = received.get(section);
                    for (int i = 0; i < books; i++) {
                        BooksCarried.put(section, books);
                    }
                }

                int walkingTime = ASSISTANT_WALK_TIME_PER_BOOK * BOOKS_PER_DELIVERY;
                Thread.sleep(ASSISTANT_WALK_TIME_TO_DELIVERY + walkingTime);
                for(String section : BooksCarried.keySet()){
                    int bookCountPerSection = BooksCarried.get(section);
                    for(int i = 0; i < bookCountPerSection; i++){
                        shelf.addBook(section);
                        Thread.sleep(ASSISTANT_PLACE_BOOK * TICKER_TIME);
                    }
                    System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant1 finished adding books to " + section);
                    Thread.sleep(TICKER_TIME * ASSISTANT_WALK_TIME_BETWEEN_SECTIONS);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally{
                try{
                    Thread.sleep(TICKER_TIME * ASSISTANT_WALK_TIME_TO_DELIVERY);
                    System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant returned to delivery dock");
                    AssistantBusy = false;

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            
        }
        else{
            System.out.println("Assistant is busy");
            
        }
        
    }


    @Override
    public void run(){
        while(true){
            if(DeliveryAvailable == true){
                StockShelves(DeliveryBox);
            }
            
        }

    }


}