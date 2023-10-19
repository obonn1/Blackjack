package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Card;
import main.CardIndexes;
import main.Player;
import main.Suits;

public class PlayerTest {

    private Player player;
    
    @Before
    public void SetUp() {
        player = new Player(100);
    }

    @Test
    public void testPlayerInitialization() {
        assertNotNull(player);
    }

    @Test
    public void testPlayerStartingMoney() {
        player = new Player(100);
        assertEquals(100, player.getMoney());
    }

    @Test
    public void testPlayerHandStartsEmpty() {
        assertTrue(player.getHand().isEmpty());
    }

    @Test
    public void testGiveCardGivesCardToHand() {
        Card card = new Card(CardIndexes.KING, Suits.SPADES);
        player.giveCard(card);
        assertEquals(card, player.getHand().get(0));
    }

    @Test
    public void testGiveSecondCard() {
        Card card1 = new Card(CardIndexes.KING, Suits.SPADES);
        Card card2 = new Card(CardIndexes.TWO, Suits.HEARTS);
        player.giveCard(card1);
        player.giveCard(card2);
        assertEquals(card2, player.getHand().get(1));
    }

    @Test
    public void testDeductMoneyReducesMoney() {
        player.deductMoney(20);
        assertEquals(80, player.getMoney());
    }

    @Test
    public void testDeductMoneyDoesNotReduceIfMoneyIsTooLow() {
        player.deductMoney(110);
        assertEquals(100, player.getMoney());
    }

    @Test
    public void testGetHandValueCalculations() {

    }    
    
    @Test
    public void testGetHandValueWithoutAces() {
        Player player = new Player();
        player.giveCard(new Card(CardIndexes.TEN, Suits.CLUBS));
        player.giveCard(new Card(CardIndexes.SEVEN, Suits.CLUBS));

        assertEquals(17, player.getHandValue());
    }

    @Test
    public void testGetHandValueWithAces() {
        Player player = new Player();
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS));
        player.giveCard(new Card(CardIndexes.SEVEN, Suits.CLUBS));

        assertEquals(18, player.getHandValue());
    }

    @Test
    public void testGetHandValueWithMultipleAces() {
        Player player = new Player();
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS)); 
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS)); 
        player.giveCard(new Card(CardIndexes.NINE, Suits.CLUBS)); 

        assertEquals(21, player.getHandValue());
    }

    @Test
    public void testGetHandValueWithBustedAces() {
        Player player = new Player();
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS));
        player.giveCard(new Card(CardIndexes.TEN, Suits.CLUBS));
        player.giveCard(new Card(CardIndexes.TEN, Suits.CLUBS));

        assertEquals(21, player.getHandValue());
    }

    @Test
    public void testGetHandValueWithMultipleAcesAndOtherCards() {
        Player player = new Player();
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS)); 
        player.giveCard(new Card(CardIndexes.ACE, Suits.CLUBS)); 
        player.giveCard(new Card(CardIndexes.NINE, Suits.CLUBS));
        player.giveCard(new Card(CardIndexes.SIX, Suits.CLUBS));

        assertEquals(17, player.getHandValue());
    }
}
