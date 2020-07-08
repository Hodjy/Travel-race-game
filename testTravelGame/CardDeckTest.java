import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import TravelRaceGame.Model.*;


public class CardDeckTest
{
	private CardDeck m_CardDeckToTest;
	
	@Before
	public void SetUpMethod()
	{
		m_CardDeckToTest = new CardDeck();
	}
	
	@After
	public void TearDownMethod() {}
	
	// Tests:
	@Test
	public void DrawTest()
	{
		//empty deck:
		assertNull(m_CardDeckToTest.Draw());
		
		//full deck after draw all of the cards:
		m_CardDeckToTest.CreateAndShuffleDeck();
		Card drawCard;
		
		for (int i = 0; i < m_CardDeckToTest.GetDeckSize(); i++)
		{
			drawCard = m_CardDeckToTest.Draw();
		}
		
		assertNull(m_CardDeckToTest.Draw());
		
		
	}
}
