import static org.junit.Assert.assertTrue;

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
		String tempName1 = "nobody1";
		String tempName2= "nobody2";
		m_LogicBoardToTest = new LogicBoard(tempName1, tempName2);
		m_LogicBoardToTest.InitilaizeGame();
	}
	
	@After
	public void teadDownMethod()
	{

	}
	
	@Test
	public void RollDiceTest()
	{
		m_LogicBoardToTest.RollDice();
		assertTrue("The dice was not rolled in the correct way", (m_LogicBoardToTest.GetDiceScore() >= 0 && m_LogicBoardToTest.GetDiceScore() <= 6));
	}
	
	
	
}
