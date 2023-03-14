import java.util.HashMap;

public class Assistant implements Runnable{
    private static final int BOOKS_PER_DELIVERY = 10;
    private static final int MAX_BOOKS_PER_ASSISTANT = 10;
    private static final int ASSISTANT_WALK_TIME_PER_BOOK = 1;
    private static final int ASSISTANT_PLACE_BOOK = 1;
    private static final int ASSISTANT_WALK_TIME_TO_DELIVERY = 10;
    private static final int ASSISTANT_WALK_TIME_BETWEEN_SECTIONS = 10;
    private static final int TICKER_TIME = 100;
    private static final HashMap<String, Integer> BooksCarried = new HashMap<String, Integer>();
    private int BookCount = 0;
    private boolean AssistantBusy = true;
    private boolean DeliveryAvailable = false;
    public Shelf shelf;

    public Assistant(Shelf Inputshelf){
        System.out.println("Staring Assistant.....");
        this.shelf = Inputshelf;
    }

    public void TrueDeliveryStatus(boolean status){
        DeliveryAvailable = status;
        //StockShelves(BooksCarried);
    }

    public void FalseDeliveryStatus(boolean status){
        DeliveryAvailable = false;
    }

    public void StockShelves(HashMap<String, Integer> received){
        BooksCarried.clear();
        System.out.println(received);
        if(AssistantBusy == false){
            try {
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
                    Thread.sleep(TICKER_TIME * ASSISTANT_WALK_TIME_BETWEEN_SECTIONS);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AssistantBusy = true;
        }
        else{
            System.out.println("Assistant is busy");
            AssistantBusy = false;
        }


        
    }


    @Override
    public void run(){
        Assistant as1 = new Assistant(shelf);

    }


}
