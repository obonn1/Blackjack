package main;
/**
 * This class represents a playing card, 
 * holding value, suit, and functionality.
 */
public class Card {
    private CardIndexes index;
    private Suits suit;

    public Card(CardIndexes index, Suits suit) {
        this.index = index;
        this.suit = suit;
    }

    public CardIndexes getIndex() {
        return index;
    }

    public Suits getSuit() {
        return suit;
    }

    public int getValue() {
        if (index.getValue() < 11) {
            return index.getValue();
        } else if (index.getValue() > 10 && index.getValue() < 14) {
            return 10;
        } else
            return 11;
    }

    @Override
    public String toString() {
        return index.toString() + " of " + suit.toString();
    }
}
