import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import TravelRaceGame.Model.*;


public class PlayerTest
{
	private Player m_PlayerToTest;
	
	@Before
	public void SetUpMethod()
	{
		m_PlayerToTest = new Player("TestPlayer");
	}
	
	@After
	public void tearDownMethod() {}
	
	//tests:
	@Test
	public void AddCardTest()
	{
		CardDeck deck = new CardDeck();
		deck.CreateAndShuffleDeck();
		
		for (int i = 0; i < m_PlayerToTest.GetMaxCardInHand(); i++) // fill the max size
		{
			m_PlayerToTest.AddCard(deck.Draw());
		}
		
		m_PlayerToTest.AddCard(deck.Draw()); // try to add above the max size
		
		assertEquals(m_PlayerToTest.GetHand().size(),  m_PlayerToTest.GetMaxCardInHand());
	}
	
	@Test
	public void RemoveAndReturnCardTest()
	{	
		// the card in hand to be empty:
		assertNull(m_PlayerToTest.RemoveAndReturnCard(0));
	}
	
	@Test
	public void  PopCurrentBuffTest()
	{
		CardDeck deck = new CardDeck();
		deck.CreateAndShuffleDeck();
		
		// check if the insert card is the pop card
		Card cardToTest = deck.Draw();
		m_PlayerToTest.AddCurrentBuff(cardToTest);
		assertEquals(cardToTest, m_PlayerToTest.PopCurrentBuff());
		
		// empty pop
		assertNull(m_PlayerToTest.PopCurrentBuff());
	}
	
	@Test
	public void TransferBuffsTest()
	{
		CardDeck deck = new CardDeck();
		deck.CreateAndShuffleDeck();
		
		ArrayList<Card> cardsToTests = new ArrayList<Card>();
		for (int i = 0; i < 3; i++)
		{
			cardsToTests.add(deck.Draw());
		}

		for (int i = 0; i < 3; i++)
		{
			m_PlayerToTest.AddQuededBuff(cardsToTests.get(i));
		}
		
		m_PlayerToTest.TransferBuffs();
		assertEquals(cardsToTests, m_PlayerToTest.GetCurrentBuffs());
	}
}
