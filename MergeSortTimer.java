import java.util.ArrayDeque;
import java.util.ListIterator;

public class MergeSortTimer {
        /**
     * takes in an unsorted pile of cards and sorts it using merge sort
     * @param unsorted
     * @return sorted 
     */
    public static CardPile sort(CardPile unsorted) {
        /** creates a new queue to store the sorted portions */   
        ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>(); 
        ListIterator<Card> queueIterator = unsorted.listIterator();

        /** adds the elements as separate card piles to the queue */
        while (queueIterator.hasNext()){
            Card card = queueIterator.next();
            CardPile newCardPile = new CardPile();
            newCardPile.add(card);
            queue.addLast(newCardPile);
        }
        queueIterator.set(null);

        /** loops through items in queue while queue is not a singleton */
        while (queue.size() > 1){
            CardPile firstCardPile = queue.removeFirst(); //pops out first element
            CardPile secondCardPile = queue.removeFirst(); //pops out last element
            CardPile m = merge(firstCardPile, secondCardPile); //merges them into one
            queue.addLast(m); //adds the merged portion to the queue
        }

        /** return the sorted result here */
        return queue.remove();
    }

    /**
   * merges two sorted cardpiles into a sorted cardpile
   * @param first
   * @param last
   * @return mergedCardPile
   */
    public static CardPile merge(CardPile first, CardPile last){
        /** creates a new card pile to merge the passed in cardpiles into */
        CardPile mergedCardPile = new CardPile(); 

        /** loops through both cardpiles as long as both contain an element */
        while (first.size() > 0 && last.size() > 0){
            if (first.getFirst().compareTo(last.getFirst()) >= 0){
                mergedCardPile.addLast(last.removeFirst());
            }
            else if (first.getFirst().compareTo(last.getFirst()) < 0){
                mergedCardPile.addLast(first.removeFirst());
            }
        }

        /** loops through and adds the remaining elements in first to mergedCardPile */
        while (first.size() > 0){
            mergedCardPile.addLast(first.removeFirst());
        }

        /** loops through and adds the remaining elements in last to mergedCardPile */
        while (last.size() > 0){
            mergedCardPile.addLast(last.removeFirst());
        }

        /** returns the merged card pile */
        return mergedCardPile; 
    }
     
  /** Starts the program running */
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]); 
      }

      MergeSortTimer.sort(cards);    
    }
  }
}
