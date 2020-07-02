package TravelRaceGame.Controller;
import java.util.ArrayList;
import java.util.Observable;

import com.sun.org.apache.xalan.internal.xslt.Process;

import TravelRaceGame.Model.*;
import TravelRaceGame.View.*;


public class GameInstance implements IApplicationController
{
	private Model m_Model;
	private View m_View;
	
	public GameInstance(Model i_Model, View i_View)
	{
		m_Model = i_Model;
		m_View = i_View;
		
		InitilaizeGame();
	}
	
	private void InitilaizeGame()
	{
		m_Model.InitilaizeGame();
		m_View.Initilize();
		m_View.SetCardsInHandAndEnableEvents(cardsInHandEnumToString(m_Model.GetCurrentPlayer().GetHand()));
		m_View.GetBoard().SetInstuctionText(m_Model.GetCurrentPlayer().GetName() + " turn");
		m_View.EnablePlayButtons(true);
	}
	
	@Override
	public void update(Observable i_UpdateSender, Object arg)
	{
		if (arg instanceof GameBoardUi.eNotificationType)
		{
			switch((GameBoardUi.eNotificationType)arg)
			{
			case CardClicked:
				onCardClicked();
				break;
			case DiceClicked:
				onDiceClicked();
				break;
			}
		}
	}
	
	private void onCardClicked()
	{
		m_Model.UseCard(m_View.GetCardClickedIndex()); // update model
		m_View.SetCardsInHandAndEnableEvents(cardsInHandEnumToString(m_Model.GetCurrentPlayer().GetHand())); // update view
		m_View.EnableCardsInHandClick(false);
	}
	
	private void onDiceClicked()
	{
		m_Model.RollDice();
		m_View.GetBoard().GetDiceButton().RollDice(m_Model.GetDiceScore());
		currentPlayerTurn();
	}
	
	private void currentPlayerTurn()
	{
		m_Model.PlayTurn();
		m_View.GetBoard().SetPlayersLocation(m_Model.GetPlayerOne().GetCurrentLocation(), m_Model.GetPlayerTwo().GetCurrentLocation());
	}
	
	private ArrayList<String> cardsInHandEnumToString(ArrayList<Card> i_CardsInHands)
	{
		ArrayList<String> cardsInHandStr = new ArrayList<String>();
		
		for (Card currentCard : i_CardsInHands)
		{
			cardsInHandStr.add(currentCard.GetType().name());
		}
		
		return cardsInHandStr;
	}
}
