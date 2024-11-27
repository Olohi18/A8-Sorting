import java.util.Collections;
import java.util.ListIterator;

public class InsertionSort {
  /**
   * sorts the unsorted list using insertion sort algorithm
   * @param unsorted
   * @param record
   * @return sorted
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) { 
    // register the starting configuration with the recorder
    record.add(unsorted);

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
      // register the new state with the recorder
      record.next();
      record.add(sorted); 
      record.add(unsorted);
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
      if (cardToAdd.compareTo(iterate.next()) <=  0){
        iterate.previous();
        iterate.add(cardToAdd); //insert the element at the right spot
        return sorted_list;
      }   
    }
    //insert element at last position if it's bigger than every element in the sorted list
    iterate.add(cardToAdd);
    return sorted_list;
  }

  public static void main(String[] args) {
    // InsertionSort insertion = new InsertionSort();
    // CardPile unsorted = new CardPile();
     // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder); //--makes an alias

    // We can print out the sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: InsertionSort");
}
}
