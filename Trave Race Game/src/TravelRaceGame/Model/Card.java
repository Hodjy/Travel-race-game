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
		DicePlusOne(eCardCategory.CurrentBuff),
		DicePlusTwo(eCardCategory.CurrentBuff),
		DicePlusThree(eCardCategory.CurrentBuff),
		DiceNextTurnPlusThree(eCardCategory.QuededBuff),
		DiceNextTurnMultiThree(eCardCategory.QuededBuff),
		DiceMultiTwo(eCardCategory.CurrentBuff),
		FreezeOtherPlayer(eCardCategory.OtherPlayerState),
		Immune(eCardCategory.QuededBuff),
		DiceRevertOtherPlayer(eCardCategory.OtherPlayerState),
		DiceZeroOtherPlayer(eCardCategory.OtherPlayerState);
		
		
		private final eCardCategory m_Category;
		
		eCardType(eCardCategory i_Category)
		{
			m_Category = i_Category;
		}
		
		public eCardCategory GetCategory()
		{
			return m_Category;
		}
	}
	
	public enum eCardCategory
	{
		CurrentBuff,
		QuededBuff,
		OtherPlayerState
	}
	
}
