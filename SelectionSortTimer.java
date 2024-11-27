import java.util.ListIterator;

public class SelectionSortTimer { 
    /**
   * sorts a card pile using selection sort
   * @param unsorted cardpile
   * @return the sorted cardpile 
   */
    public static CardPile sort(CardPile unsorted) {
        // Here is the result list you will be creating
        CardPile sorted = new CardPile(); 

        /** loop through unsorted pile */
        while (unsorted.size() > 0){
        Card minimum = getMin(unsorted); //get the card with the smallest value
        unsorted.removeFirstOccurrence(minimum); //remove the card from unsorted
        sorted.addLast(minimum); //add it as head to sorted
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

        SelectionSortTimer.sort(cards);
        
        }
    }
        
}
