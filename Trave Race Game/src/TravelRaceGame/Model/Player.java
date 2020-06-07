package TravelRaceGame.Model;

import java.util.*;
import TravelRaceGame.Model.Card.eCardType;


public class Player 
{
	private String m_Name;
	private int	m_Score = 0;
	private int m_CurrentLocationOnBoard;
	private ArrayList<eCardType> m_CardsInHand;
	private final int f_MaxCardsInHand = 5;
	private ePlayerState m_CurrentState;
	
	
	public Player(String i_Name) 
	{
		m_Name = i_Name;
		m_CardsInHand = new ArrayList<eCardType>();
		m_CurrentState = ePlayerState.Normal;
	}
	
	public String GetName()
	{
		return m_Name;
	}
	
	public int GetScore()
	{
		return m_Score;
	}
	
	public int GetCurrentLocation()
	{
		return m_CurrentLocationOnBoard;
	}
	
	public void SetCurrentLocation(int i_NewLocation)
	{
		m_CurrentLocationOnBoard = i_NewLocation;
	}
	
	public void AddScore(int i_Score)
	{
		m_Score += i_Score;
	}

	public void AddCard(eCardType i_CardToAdd)
	{
		if (m_CardsInHand.size() < f_MaxCardsInHand)
		{
			m_CardsInHand.add(i_CardToAdd);
		}
	}
	
	public eCardType RemoveAndReturnCard(int i_CardIndex)
	{
		return m_CardsInHand.remove(i_CardIndex);
	}
	
	public ePlayerState getCurrentPlayerState()
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
		Immune		
	}
		
}
