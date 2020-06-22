package TravelRaceGame.View;
import java.util.Observable;

public interface View
{
	public int GetCardClickedIndex();
	public BoardPanel GetBoard();
	public void Initilize();
	public void EnablePlayButtons(boolean i_Enable);
	public void EnableCardsInHandClick(boolean i_Enable);
	public void EnableDiceButton(boolean i_Enable);
	public void SetCardsInHandAndEnableEvents(String[] i_HandToSet);
}
