package TravelRaceGame;

import java.util.*;

import javax.swing.JFrame;

public class Player 
{
	
	
	private String name;
	private ArrayList<Integer> cardsInHandID;
	private final int maxCardsInHand = 5;
	private playerState currentState;
	
	
	
	public Player(String name) 
	{
		this.name = name;
		this.cardsInHandID = new ArrayList<Integer>(maxCardsInHand);
		this.currentState = playerState.NORMAL;
		
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public void SetStartingHand()
	{
		final int startingCardsAmount = 3; 
		for (int i=0; i < startingCardsAmount; i++)
		{
			cardsInHandID.add((int)(Math.random() * Card.GetCardsAmount()) + 1);
		}
	}
	
	public void addCard(int i_CardId)
	{
		if (cardsInHandID.size() < maxCardsInHand)
		{
			cardsInHandID.add(i_CardId);
		}
	}
	
	public void removeCard(int i_CardId)
	{
		for (int i = 0; i < cardsInHandID.size(); i++)
		{
			if (cardsInHandID.get(i).compareTo(i_CardId) == 0)
			{
				cardsInHandID.remove(i);
				break;
			}
		}
	}

	public int GetCardFromHand(int i_IndexOfCard)
	{
		return cardsInHandID.get(i_IndexOfCard);
	}
	
	public playerState getCurrentPlayerState()
	{
		return currentState;
	}
	
	public void ChangePlayerState(playerState i_newState)
	{
		
	}
	/*
	gameInstance{
		JFrame.....
		
		while(currentPlayer)
		{
			startTurn();
			waitEvent();
			
			
			
			
		}
		
		
		JFrame EventPress
		{
			result = Dice.rollDice();
			
		}
	}
	
	*/
	
	
	private enum playerState {NORMAL, FROZEN, IMMUNE };
}
