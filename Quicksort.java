import java.util.Collections;
import java.util.ListIterator;

public class Quicksort {
  
  /**
   * sorts an unsorted pile of cards using quicksort algorithm
   * @param unsorted
   * @param record
   * @return sorted result
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {

    /** Stop conditions--- when the unsorted has a size of 1 or 0 **/
    if (unsorted.size() == 0 || unsorted.size() == 1){
      return unsorted;
    }
    
    /** Two partitions to store elements based on their relative size to the pivot **/
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile(); 
    /** iterate through the unsorted list and divide them into the partitions */
    ListIterator<Card> quickIterator = unsorted.listIterator();
    Card pivot = quickIterator.next(); //initializes the pivot point to the head of the unsorted card pile
    while (quickIterator.hasNext()){ 
      Card card = quickIterator.next();
      if (card.compareTo(pivot) >= 0){
        bigger.addLast(card);
      }
      else{
        smaller.addLast(card);
      }
    }
    
    /** register the partitions with the recorder */
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    CardPile result = new CardPile(); //holds the assembled result
    CardPile smallResult = sort(smaller, record); //holds the result of the pile with elements less than pivot
    CardPile bigResult = sort(bigger, record); //holds the result of the pile with elements more than pivot
    
    /** adds the smallResult, pivot, and bigResult in order to the result pile */
    ListIterator<Card> generalIterator = smallResult.listIterator();
    while (generalIterator.hasNext()){
      result.addLast(generalIterator.next());
    }
    result.addLast(pivot);
    generalIterator = bigResult.listIterator();
    while (generalIterator.hasNext()){
      result.addLast(generalIterator.next());
    }

    /** records the sorted result */
    record.add(result);
    record.next();
    
    /** return the sorted result here */
    return result;
  }

  public static void main(String[] args) {
    SortRecorder recorder = new SortRecorder();

    /** set up the deck of cards */
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    //cards = cards.split(cards.get(39));

    /** mix up the cards */
    Collections.shuffle(cards);

    // // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = Quicksort.sort(cards, recorder); //--makes an alias

    // make window appear showing the record
    recorder.display("Card Sort Demo: QuickSort");
  }
}
