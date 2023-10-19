package main;

import java.util.ArrayList;

/**
 * This class represents a player or dealer.
 */
public class Player {
    private int money = 0;
    ArrayList<Card> hand = new ArrayList<>();

    public Player(int startingMoney) {
        money = startingMoney;
    }

    public Player() {
    }

    public int getMoney() {
        return money;
    }

    public void deductMoney(int deduction) {
        if (deduction <= money) {
            money -= deduction;
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void giveCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand = new ArrayList<>();
    }

    public int getHandValue() {
        int aceCount = 0;
        int value = 0;
        for (Card card : hand) {
            int cardValue = card.getValue();
            if (cardValue == 11) {
                aceCount++;
            }
            value += cardValue;
        }
        for (int i = 0; i < aceCount; i++) {
            if (value > 21) {
                value -= 10;
            }
        }
        return value;
    }
}