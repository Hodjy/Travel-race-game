import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import TravelRaceGame.Model.*;


public class LogicBoardTest
{
	private LogicBoard m_LogicBoardToTest;
	
	@Before
	public void SetUpMethod()
	{
		String tempName1 = "playerOne";
		String tempName2= "playerTwo";
		m_LogicBoardToTest = new LogicBoard(tempName1, tempName2);
		m_LogicBoardToTest.InitializeGame();
	}
	
	@After
	public void tearDownMethod() {}
	
	@Test
	public void RollDiceTest()
	{
		m_LogicBoardToTest.RollDice();
		assertTrue("The dice was not rolled in the correct way", (m_LogicBoardToTest.GetDiceScore() >= 0 && m_LogicBoardToTest.GetDiceScore() <= 6));
	}
	
	@Test
	public void CheckIfPlayerWonTest()
	{
		for (int i = 0; i < m_LogicBoardToTest.GetMaxRoundSize(); i++)
		{
			m_LogicBoardToTest.GetCurrentPlayer().SetCurrentLocation(27); // set to the end of the board
			m_LogicBoardToTest.RollDice();
			m_LogicBoardToTest.PlayTurn();
		}
		
		assertTrue(m_LogicBoardToTest.CheckIfPlayerWon());
	}

	@Test
	public void UseCardTest()
	{
		int initialLocation;
		// Freeze other player:
		m_LogicBoardToTest.GetCurrentPlayer().AddCard(new Card(Card.eCardType.FreezeOtherPlayer));
		m_LogicBoardToTest.UseCard(m_LogicBoardToTest.GetCurrentPlayer().GetHand().size() - 1);
		m_LogicBoardToTest.EndTurn(); // switch to other player
		initialLocation = m_LogicBoardToTest.GetCurrentPlayer().GetCurrentLocation();
		m_LogicBoardToTest.RollDice();
		m_LogicBoardToTest.PlayTurn();
		assertEquals(initialLocation, m_LogicBoardToTest.GetCurrentPlayer().GetCurrentLocation());
		m_LogicBoardToTest.EndTurn();
		
		// immune:
		m_LogicBoardToTest.GetCurrentPlayer().AddCard(new Card(Card.eCardType.Immune));
		m_LogicBoardToTest.UseCard(m_LogicBoardToTest.GetCurrentPlayer().GetHand().size() - 1);
		m_LogicBoardToTest.RollDice();
		m_LogicBoardToTest.PlayTurn();
		m_LogicBoardToTest.EndTurn();// switch to other player
		m_LogicBoardToTest.GetCurrentPlayer().AddCard(new Card(Card.eCardType.FreezeOtherPlayer));
		m_LogicBoardToTest.UseCard(m_LogicBoardToTest.GetCurrentPlayer().GetHand().size() - 1);
		m_LogicBoardToTest.EndTurn(); // switch to other player
		initialLocation = m_LogicBoardToTest.GetCurrentPlayer().GetCurrentLocation();
		m_LogicBoardToTest.RollDice();
		m_LogicBoardToTest.PlayTurn();
		assertNotEquals(initialLocation, m_LogicBoardToTest.GetCurrentPlayer().GetCurrentLocation());
	}
}
