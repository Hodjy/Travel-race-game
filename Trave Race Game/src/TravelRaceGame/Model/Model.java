package TravelRaceGame.Model;

public interface Model
{
	public int GetDiceScore();
	public Player GetCurrentPlayer();
	public Player GetPlayerOne();
	public Player GetPlayerTwo();
	public void InitilaizeGame();
	public boolean CheckIfPlayerWon();
	public void UseCard(int i_CardInHandIndex);
	public void RollDice();
	public void PlayTurn();
	public void EndTurn();
	
}
