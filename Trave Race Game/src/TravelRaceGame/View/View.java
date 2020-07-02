package TravelRaceGame.View;
import java.util.ArrayList;
import java.util.Observable;

public interface View
{
	public int GetCardClickedIndex();
	public BoardPanel GetBoard();
	public void EndGameUi();
	public void Initilize();
	public void EnablePlayButtons(boolean i_Enable);
	public void EnableCardsInHandClick(boolean i_Enable);
	public void EnableDiceButton(boolean i_Enable);
	public void SetCardsInHandAndEnableEvents(ArrayList<String> i_HandToSet);
	public boolean AskReplayGame(String i_WinnerName);
}
