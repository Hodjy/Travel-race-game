package TravelRaceGame.View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;;

public class ButtonFactory 
{	
	public static JButton CreateButton(String i_ButtonType)
	{
		JButton buttonToReturn = null;
		
		switch(i_ButtonType)
		{
		case "Dice": 
			buttonToReturn = new DiceButton();
			break;
		case "DicePlusOne":
			buttonToReturn = createNewCard("DicePlusOne");
			break;
		case "DicePlusTwo":
			buttonToReturn = createNewCard("DicePlusTwo");
			break;
		case "DiceNextTurnPlusThree":
			buttonToReturn = createNewCard("DiceNextTurnPlusThree");
			break;
		case "DiceNextTurnMultiThree":
			buttonToReturn = createNewCard("DiceNextTurnMultiThree");
			break;
		case "DiceMultiTwo":
			buttonToReturn = createNewCard("DiceMultiTwo");
			break;
		case "FreezeOtherPlayer":
			buttonToReturn = createNewCard("FreezeOtherPlayer");
			break;
		case "Immune":
			buttonToReturn = createNewCard("Immune");
			break;
		case "DiceRevertOtherPlayer":
			buttonToReturn = createNewCard("DiceRevertOtherPlayer");
			break;
		case "DiceZeroOtherPlayer":
			buttonToReturn = createNewCard("DiceZeroOtherPlayer");
			break;
		}
		
		return buttonToReturn;
	}
	
	private static JButton createNewCard(String i_Card)
	{
		JButton cardToReturn = new JButton();
		
		String cardPath = "/Images/Cards/" + i_Card;
		cardToReturn.setSize(163, 203);
		cardToReturn.setBorder(BorderFactory.createEmptyBorder());
		cardToReturn.setContentAreaFilled(false);
		cardToReturn.setIcon(new ImageIcon(ButtonFactory.class.getResource(cardPath)));
		cardToReturn.setVisible(true);
		cardToReturn.validate();
		
		return cardToReturn;
	}
}
