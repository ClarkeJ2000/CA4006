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

    public void StockShelves(HashMap<String, Integer> DelBox){
        DeliveryAvailable = false;
        // check if assistant is busy
        if(AssistantBusy == false){
            try {
                // assistant is busy
                AssistantBusy = true;
                // add books to the carry list

                for (String section : DelBox.keySet()) {
                    int books = DelBox.get(section);
                    int CarryAmount = 0;
                    
                    for (int i = 0; i < books; i++) {
                        while(CarryAmount < 10){
                            BooksCarried.put(section, books);
                            CarryAmount += 1;
                            DelBox.put(section, 0);
                        }
                    }

                }
                System.out.println("Books being Carried: " + BooksCarried);
                // Assistant has collected the books
                System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant1 collected books for " + BooksCarried.keySet() + " sections      " + BooksCarried);
                // walk time to shelves
                int walkingTime = (ASSISTANT_WALK_TIME_PER_BOOK * BOOKS_PER_DELIVERY) + ASSISTANT_WALK_TIME_TO_DELIVERY;
                Thread.sleep(walkingTime * TICKER_TIME);
                // add books to shelves for each section
                int BooksLeft = 0;
                // iterate through each section
                for(String section : BooksCarried.keySet()){
                    int bookCountPerSection = BooksCarried.get(section);
                    for(int i = 0; i < bookCountPerSection; i++){
                        // add book to shelf
                        shelf.addBook(section);
                        BooksLeft += 1;
                        // sleep time needed to place each book
                        Thread.sleep(ASSISTANT_PLACE_BOOK * TICKER_TIME);
                    }
                    // Asssistant has finished adding books to section, walking to next section
                    System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant1 finished adding books to " + section);
                    int CurrentWalkingTime = ASSISTANT_WALK_TIME_PER_BOOK * (10 - BooksLeft);

                    // check if there are more books to add, if so walk to next section
                    if(BooksLeft > 0){
                        Thread.sleep(TICKER_TIME * (ASSISTANT_WALK_TIME_BETWEEN_SECTIONS + CurrentWalkingTime));
                    }
                    else{
                        // no more books to add, walk back to delivery dock
                        Thread.sleep(TICKER_TIME * ASSISTANT_WALK_TIME_TO_DELIVERY);
                    }
                    
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally{
                try{
                    // assistant is done, return to delivery dock
                    Thread.sleep(TICKER_TIME * ASSISTANT_WALK_TIME_TO_DELIVERY);
                    System.out.println("<Tick " + CurrTime + "> <T" + Thread.currentThread().getId() + "> Assistant returned to delivery dock");
                    AssistantBusy = false;
                    BooksCarried.clear();
                    //DeliveryBox.clear();


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
        // Check is delivery is available, then stock shelves
        while(true){
            if(DeliveryAvailable == true){
                StockShelves(DeliveryBox);
            }
            
        }

    }


}
