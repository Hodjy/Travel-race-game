package TravelRaceGame.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class CardsInHandPanel extends JPanel
{
	ArrayList<JButton> m_CardsInHand;
	
	public CardsInHandPanel()
	{
		super();
		m_CardsInHand = new ArrayList<JButton>();
		this.setSize(163 * 5 + 25, 203);  // TODO: CHANGE NUMBERS TO FINALS
		this.setBackground(new Color(0, 0, 0, 0));
		this.setLayout(new BorderLayout());
	}
	
	public void SetCardsInHand(String[] i_StartingHand)
	{
		m_CardsInHand.clear();
		
		for (String cardType : i_StartingHand)
		{
			m_CardsInHand.add(ButtonFactory.CreateButton(cardType));
		}
		for (JButton cardButton : m_CardsInHand)
		{
			this.add(cardButton);
		}
	}
	
	
	
}
