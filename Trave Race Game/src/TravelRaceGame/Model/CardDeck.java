package TravelRaceGame.Model;

import java.util.ArrayList;
import TravelRaceGame.Model.Card.eCardType;


public class CardDeck 
{
	private ArrayList<Card> m_Deck;
	private final int f_DeckSize = 40;
	
	public CardDeck() 
	{
		m_Deck = new ArrayList<Card>(f_DeckSize);
	}
	
	public void CreateAndShuffleDeck() 
	{
		for (eCardType cardType : eCardType.values()) {
			for (int i = 0; i < 4; i++)
			{
				m_Deck.add(new Card(cardType));
			}
		}
		
		shuffle();
	}
	
	public Card Draw()
	{
		return m_Deck.remove(0);
	}
	
	private void shuffle()
	{
		Card tempCard;
		int randIndex;
		
		for (int i = 0; i < f_DeckSize; i++)
		{
			randIndex = (int)(Math.random() * (f_DeckSize - 1)) + 1;
			tempCard = m_Deck.get(i);
			m_Deck.set(i, m_Deck.get(randIndex));
			m_Deck.set(randIndex, tempCard);
		}
	}
	
}
