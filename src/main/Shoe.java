package main;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents the primary container for game cards.
 */
public class Shoe {
    public ArrayList<Card> cards = new ArrayList<>();

    public Shoe(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            cards.addAll(getDeck());
            Collections.shuffle(cards);
        }
    }

    public static ArrayList<Card> getDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for (Suits suit : Suits.values()) {
            cards.addAll(Arrays.stream(CardIndexes.values())
                    .map(index -> new Card(index, suit))
                    .collect(Collectors.toList()));
        }
        return cards;
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getSize() {
        return cards.size();
    }

}
