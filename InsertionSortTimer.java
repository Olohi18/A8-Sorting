import java.util.Collections;
import java.util.ListIterator;

public class InsertionSortTimer {
    /**
     * sorts the unsorted list using the insertion sort algorithm
     * @param unsorted
     * @return sorted 
     */
    public static CardPile sort(CardPile unsorted) { 
    
        /** creates an empty card pile for storing the sorted section of the cards */
        CardPile sorted = new CardPile();
    
        /** loop to sort elements in unsorted list-- runs while unsorted section is not empty*/
        while (unsorted.size() > 0){
          /** if sorted is empty, add the first element from unsorted section to sorted */
          if (sorted.size() == 0){ 
            sorted.addFirst(unsorted.removeFirst());
          }
          /** if sorted contains a card, appends first card in unsorted to the correct position in the sorted section */
          else{
            Card cardRemoved = unsorted.removeFirst();
            sorted = addToCorrectPosition(sorted, cardRemoved);
          }
        }
        // return the sorted result here
        return sorted;
      }

    /**
     * adds the node passed in to the correct position in the list
     * @param sorted_list and node to be passed in
     */
    public static CardPile addToCorrectPosition(CardPile sorted_list, Card cardToAdd){
        /** initialize an iterator over the sorted list */
        ListIterator<Card> iterate = sorted_list.listIterator();

        /** loops while the iterator has a next */
        while (iterate.hasNext()){
          /** if the cardToAdd is less than next card */ 
          if (cardToAdd.compareTo(iterate.next()) <  0){
              iterate.previous();
              iterate.add(cardToAdd); //insert the element at the right spot
              return sorted_list;
          }
          else if (iterate.hasNext()){iterate.next();} //update iterator to the next   
          }

        //insert element at last position if it's bigger than every element in the sorted list
        iterate.add(cardToAdd);
        return sorted_list;
    }

    public static void main(String args[]) {
    
        if (args.length<1) {
          System.err.println("Please specify how many cards to sort!");
        } else {
          Card[] deck = Card.newDeck(true);
          CardPile cards = new CardPile();
          
          for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
            cards.add(deck[(int)(52*Math.random())]);
          }
    
          InsertionSortTimer.sort(cards);   
        }
      }
}
