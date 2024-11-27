import java.util.ListIterator;

public class QuickSortTimer {

    /**
   * sorts an unsorted pile of cards using quicksort algorithm
   * @param unsorted
   * @return sorted result
   */
  public static CardPile sort(CardPile unsorted) {

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

    CardPile result = new CardPile(); //holds the assembled result
    CardPile smallResult = sort(smaller); //holds the result of the pile with elements less than pivot
    CardPile bigResult = sort(bigger); //holds the result of the pile with elements more than pivot
    
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
    
    /** return the sorted result here */
    return result;
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

      QuickSortTimer.sort(cards);    
    }
  }
}
