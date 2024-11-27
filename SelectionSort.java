import java.util.Collections;
import java.util.ListIterator;

public class SelectionSort {
  /**
   * sorts a card pile using selection sort
   * @param unsorted cardpile
   * @param record
   * @return the sorted cardpile 
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    // Here is the result list you will be creating
    CardPile sorted = new CardPile(); 

    /** loop through unsorted pile */
    while (unsorted.size() > 0){
      Card minimum = getMin(unsorted); //get the card with the smallest value
      unsorted.removeFirstOccurrence(minimum); //remove the card from unsorted
      sorted.addLast(minimum); //add it as head to sorted

      //updates record
      record.next();
      record.add(sorted);
      record.add(unsorted);
    }

    /** return the sorted result here */
    return sorted;
  }

  /**
   * gets the card with the minimum value in a list of cards
   * @param cards
   * @return mimimum value
   */
  public static Card getMin(CardPile cards){
    ListIterator<Card> minIterator = cards.listIterator();
    Card min = null; //initializes the minimum value to null
    if (minIterator.hasNext()){ min = minIterator.next();} //updates min to head of list

    /** loops through the card pile and updates the minimum value as needed */
    while (minIterator.hasNext()){
      Card current = minIterator.next(); //stores the element being traversed
      if (min.compareTo(current) > 0){
        min = current;}
    }
    
    //return the minimum value
    return min; 
  }

  public static void main(String[] args) {
     // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    //cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = SelectionSort.sort(cards, recorder); //--makes an alias

    // We can print out the sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: SelectionSort");
}
}

