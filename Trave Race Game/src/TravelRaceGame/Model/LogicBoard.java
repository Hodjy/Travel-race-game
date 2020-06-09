package TravelRaceGame.Model;
import java.util.Observable;


public class LogicBoard  extends Observable implements Model
{
	private final int f_TilesNumber = 28;
	private final int f_FirstPlayerHandSize = 3;
	private final int f_MaxRoundsToWin = 3;
	private int m_DiceScore;
	private final boolean f_IsSpecialTile = true;
	private Player m_PlayerOne;
	private Player m_PlayerTwo;
	private Player m_CurrentPlayer;
	private boolean[] m_Tiles;
	private CardDeck m_Deck;
	
	
	public LogicBoard(String i_PlayerOneName, String i_PlayerTwoName)
	{
		m_PlayerOne = new Player(i_PlayerOneName);
		m_PlayerTwo = new Player(i_PlayerTwoName);	
		m_Tiles = new boolean[f_TilesNumber];
		m_Deck = new CardDeck();
		m_CurrentPlayer = m_PlayerOne;
		setSpecialTiles();
	}
	
	
	// Getters/Setters:
	public int GetDiceScore()
	{
		return m_DiceScore;
	}
	
	public Player GetCurrentPlayer()
	{
		return m_CurrentPlayer;
	}
	
	
	
	public void InitilaizeGame()
	{
		m_Deck.CreateAndShuffleDeck();
		initilizePlayer(m_PlayerOne);
		initilizePlayer(m_PlayerTwo);
	}
	
	public void UseCard(int i_CardInHandIndex)
	{
		Card cardToUse = m_CurrentPlayer.RemoveAndReturnCard(i_CardInHandIndex);
		// TODO: ADD METHODS TO CARD BUFFS
	}
	
	private void initilizePlayer(Player i_PlayerToInitilize)
	{
		i_PlayerToInitilize.Initilize();
		
		for (int i = 0; i <= f_FirstPlayerHandSize; i++)
		{
			i_PlayerToInitilize.AddCard(m_Deck.Draw());
		}
	}
	
	private void setSpecialTiles()
	{
		for (int i = 5; i < f_TilesNumber - 1; i += 7)
		{
			m_Tiles[i] = f_IsSpecialTile;
		}
	}
	
	

}
