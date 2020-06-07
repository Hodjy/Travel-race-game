package TravelRaceGame.Model;


public class Dice
{
	// Date members:
	private static int s_Result;

	public static int GetResult()
	{
		rollDice();
		return s_Result;
	}
	
	private static void rollDice()
	{	
		s_Result = (int)(Math.random() * 6) + 1;
	}
	
}