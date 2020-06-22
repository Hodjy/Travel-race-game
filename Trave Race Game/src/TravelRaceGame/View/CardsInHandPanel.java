package TravelRaceGame.View;

import java.util.ArrayList;
import javax.swing.*;

import TravelRaceGame.Model.Card;


public class CardsInHandPanel extends JPanel
{
	private final int f_Witdh = 1000;
	private final int f_Height = 270;
	private ArrayList<JButton> m_CardsInHand;
	
	
	public CardsInHandPanel()
	{
		super(null);
		m_CardsInHand = new ArrayList<JButton>();
		this.setSize(f_Witdh, f_Height);
		this.setOpaque(false);
	}
	
	public ArrayList<JButton> GetCardsInHandButtons()
	{
		return m_CardsInHand;
	}
	
	public void SetCardsInHand(ArrayList<String> i_StartingHand) // TODO: CHECK IF BUTTONS ARE REMOVED PROPER
	{
		this.removeAll();
		m_CardsInHand.clear();
		this.repaint();
		int offsetX = 0;
		int yLocation = this.getHeight() - 204;
		
		for (String cardType : i_StartingHand)
		{
			m_CardsInHand.add(ButtonFactory.CreateButton(cardType));
		}
		for (JButton cardButton : m_CardsInHand)
		{
			cardButton.setLocation(offsetX, yLocation);
			this.add(cardButton);
			offsetX += cardButton.getWidth();
		}
		
	}
	
}
