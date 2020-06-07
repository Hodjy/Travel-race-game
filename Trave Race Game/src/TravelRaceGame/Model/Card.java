package TravelRaceGame.Model;

public class Card
{
	private final eCardType f_Type;
	
	public Card(eCardType i_Type)
	{
		f_Type = i_Type;
	}
	
	public eCardType GetType()
	{
		return f_Type;
	}
	
	public enum eCardType
	{
		DicePlusOne,
		DicePlusTwo,
		DiceNextTurnPlusThree,
		DiceMultiTwo,
		FreezeOtherPlayer,
		Immune,
		DrawTwoCards,
		DrawAndUseCard,
		DiscardRollDiceTwice,
		DiceRevertOtherPlayer
	}
}
