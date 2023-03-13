// import java.util.HashMap;
// import java.util.Random;
// import java.util.concurrent.TimeUnit;

// public class Bookstore {
//     // constants for simulation params
//     private static final int TICKS_PER_DAY = 1000;
//     private static final int DELIVERY_TICK_INTERVAL = 100;
//     private static final int BOOKS_PER_DELIVERY = 10;
//     private static final int SECTIONS_COUNT = 6;
//     private static final int CUSTOMER_TICK_INTERVAL = 10;
//     private static final int MAX_BOOKS_PER_ASSISTANT = 10;
//     private static final int ASSISTANT_WALK_TIME_PER_BOOK = 1;
//     private static final int ASSISTANT_WALK_TIME_TO_DELIVERY = 10;
//     private static final int ASSISTANT_WALK_TIME_BETWEEN_SECTIONS = 10;



//     // sections contains a list of book count in bookstore Fiction, Horror, Romance, Fantasy, Poetry, History
//     private static final HashMap<String, Integer> Sections = new HashMap<String, Integer>();
//     private static final String bookCategories[] = {"Fiction", "Horror", "Romance", "Fantasy", "Poetry", "History"};
//     private int currentTick = 0;


//     public void simtime(){
//         currentTick++;

//         if (currentTick % 100 == 0){
//             bookDelivery();
//         }

//     }


    

//     public static void main(String[] args) {
//         Bookstore bookstore = new Bookstore();
//         bookstore.bookDelivery();

//     }


// }
