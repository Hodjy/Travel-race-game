package TravelRaceGame.Model;

import java.util.*;


public class Player 
{
	private final int f_MaxCardsInHand = 5;
	private String m_Name;
	private int	m_Score;
	private int m_CurrentLocationOnBoard;
	private int m_CurrentRound;
	private ArrayList<Card> m_CardsInHand;
	private ArrayList<Card> m_CurrentBuffs;
	private ArrayList<Card> m_QueuedBuffs;
	private ePlayerState m_CurrentState; //  TODO :need the proper way to change state in the end of the turn
	 
	
	public Player(String i_Name) 
	{
		m_Name = i_Name;
		m_CardsInHand = new ArrayList<Card>();
		m_CurrentBuffs = new ArrayList<Card>();
		m_QueuedBuffs = new ArrayList<Card>();
	}

	public void Initialize()
	{
		m_Score = 0;
		m_CurrentLocationOnBoard = 0;
		m_CurrentRound = 0;
		m_CurrentState = ePlayerState.Normal;
		m_CardsInHand.clear();
		m_CurrentBuffs.clear();
		m_QueuedBuffs.clear();
	}
	
	// Getters/setters:
	public String GetName()
	{
		return m_Name;
	}
	
	public int GetScore()
	{
		return m_Score;
	}
	
	public int GetMaxCardInHand()
	{
		return f_MaxCardsInHand;
	}
	
	public ArrayList<Card> GetHand()
	{
		return m_CardsInHand;
	}
	
	public int GetCurrentLocation()
	{
		return m_CurrentLocationOnBoard;
	}
	
	public void SetCurrentLocation(int i_NewLocation)
	{
		m_CurrentLocationOnBoard = i_NewLocation;
	}
	
	public int GetCurrentRound()
	{
		return m_CurrentRound;
	}
	
	public ArrayList<Card> GetCurrentBuffs()
	{
		return m_CurrentBuffs;
	}
	
	public void IncrementRound()
	{
		m_CurrentRound++;
	}
	
	public void DecrementRound()
	{
		m_CurrentRound--;
	}
	
	public Card PopCurrentBuff()
	{
		Card CardToReturn = null;
		
		if (!m_CurrentBuffs.isEmpty())
		{
			CardToReturn = m_CurrentBuffs.remove(m_CurrentBuffs.size() - 1);
		}
		
		return CardToReturn;
	}
	
	public void TransferBuffs()
	{
		m_CurrentBuffs.addAll(m_QueuedBuffs);
		m_QueuedBuffs.clear();
	}
	
	public void AddCurrentBuff(Card i_Buff)
	{
		m_CurrentBuffs.add(i_Buff);
	}
	
	public void AddQueuedBuff(Card i_Buff)
	{
		m_QueuedBuffs.add(i_Buff);
	}
	
	public void AddScore(int i_Score)
	{
		m_Score += i_Score;
	}

	public void AddCard(Card i_CardToAdd)
	{
		if (m_CardsInHand.size() < f_MaxCardsInHand)
		{
			m_CardsInHand.add(i_CardToAdd);
		}
	}
	
	public Card RemoveAndReturnCard(int i_CardIndex)
	{
		Card cardToReturn = null;
		
		if (!m_CardsInHand.isEmpty())
		{
			cardToReturn = m_CardsInHand.remove(i_CardIndex);
		}
		
		return cardToReturn;
	}
	
	public ePlayerState GetCurrentPlayerState()
	{
		return m_CurrentState;
	}
	
	public void ChangePlayerState(ePlayerState i_newState)
	{
		m_CurrentState = i_newState;
	}
	
	public enum ePlayerState
	{
		Normal,
		Frozen,
		Revert,
		ZeroDice
	}
		
}
