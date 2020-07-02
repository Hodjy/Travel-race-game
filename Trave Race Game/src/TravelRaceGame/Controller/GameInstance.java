package TravelRaceGame.Controller;
import java.util.ArrayList;
import java.util.Observable;
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
		startCurrentPlayerTurn();
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
	
	private void startCurrentPlayerTurn()
	{
		m_View.SetCardsInHandAndEnableEvents(cardsInHandEnumToString(m_Model.GetCurrentPlayer().GetHand()));
		m_View.GetBoard().SetInstuctionText("Its " + m_Model.GetCurrentPlayer().GetName() + " turn");
		m_View.EnablePlayButtons(true);
	}
	
	private void onCardClicked()
	{
		m_Model.UseCard(m_View.GetCardClickedIndex()); // update model
		m_View.SetCardsInHandAndEnableEvents(cardsInHandEnumToString(m_Model.GetCurrentPlayer().GetHand())); // update view
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
		 // TODO : CHECK SPECIAL TILE
		
		if (!checkIfGameEnded())
		{
			m_Model.EndTurn();
			startCurrentPlayerTurn();
		}	
	}
	
	private boolean checkIfGameEnded()
	{
		boolean isEnded = false;
		
		if (m_Model.CheckIfPlayerWon())
		{
			if (m_View.AskReplayGame(m_Model.GetCurrentPlayer().GetName()))
			{
				HighScoreHandler.WriteHighScore(m_Model.GetPlayerOne().GetName(), m_Model.GetCurrentPlayer().GetScore());
				HighScoreHandler.WriteHighScore(m_Model.GetPlayerTwo().GetName(), m_Model.GetCurrentPlayer().GetScore());
				InitilaizeGame();
			}
			else
			{
				m_View.EndGameUi();
			}
			
			isEnded = true;
		}
		
		return isEnded;
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
