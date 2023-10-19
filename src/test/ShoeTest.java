package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.Card;
import main.Shoe;

public class ShoeTest {

    private Shoe shoe;

    @Before
    public void setUp() {
        shoe = new Shoe(1);
    }

    @Test
    public void testShoeInstantiation() {
        assertNotNull(shoe);
    }

    @Test
    public void testShoeSizeWithOneDeck() {
        assertEquals(52, shoe.cards.size());
    }

    @Test
    public void testShoeSizeWithThreeDecks() {
        shoe = new Shoe(3);
        assertEquals(156, shoe.getSize());
    }

    @Test
    public void testDeckSizeWithMultipleDecks() {
        Shoe multipleDecksShoe = new Shoe(3);
        assertEquals(52 * 3, multipleDecksShoe.cards.size());
    }

    @Test
    public void testGetDeck() {
        assertNotNull(Shoe.getDeck());
        assertTrue(Shoe.getDeck().size() > 0);
    }

    @Test
    public void testDrawCardReturnsCard() {
        Card card = shoe.drawCard();
        assertTrue(card instanceof Card);
    }

    @Test
    public void testDrawCardRemovesCardFromShoe() {
        int beforeSize = shoe.cards.size();
        shoe.drawCard();
        int afterSize = shoe.cards.size();
        assertEquals(beforeSize - 1, afterSize);
    }
}
