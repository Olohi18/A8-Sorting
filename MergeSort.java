import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ListIterator;

public class MergeSort {
  
  /**
   * takes in an unsorted pile of cards and sorts it using merge sort
   * @param unsorted
   * @param record
   * @return sorted 
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
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
  
    /** loops through items in queue while queue is not empty */
    while (queue.size() > 1){
      CardPile firstCardPile = queue.removeFirst(); //pops out first element
      CardPile secondCardPile = queue.removeFirst(); //pops out last element
      CardPile m = merge(firstCardPile, secondCardPile); //merges them into one
      record.next(); // tell the recorder this is a new step
      for (CardPile pile: queue) { // add all piles
        record.add(pile);
      }  
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
      if (first.getFirst().compareTo(last.getFirst()) > 0){
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

  /**
   * Main method: runs merge sort algorithm
   * @param args
   */
  public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    //cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    //if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);
 
    //in your program, this would be a call to a real sorting algorithm
    cards = MergeSort.sort(cards, recorder); //--makes an alias

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}
