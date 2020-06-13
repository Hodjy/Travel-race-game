package TravelRaceGame.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindowFrame extends JFrame
{
	
	public MainWindowFrame() throws IOException
	{	
		super();
		this.setSize(1024 + 18, 720 + 47);

		BoardPanel panel = new BoardPanel();
		CardsInHandPanel cardPanel = new CardsInHandPanel();
		BackgroundPanel bj = new BackgroundPanel("/Images/GameBoard/FinalBoard.png");
		String[] cards = {"DicePlusTwo","DiceNextTurnPlusFour","DicePlusTwo","DiceNextTurnPlusFour","DicePlusTwo"};
		cardPanel.SetCardsInHand(cards);
		
		panel.setLocation(68, 64);
		
		
		//this.setContentPane(panel);
		cardPanel.setLocation(100, 450);
		//this.setContentPane(new BackgroundPanel("/Images/GameBoard/FinalBoard(1024x720).png"));
		//this.getContentPane().add(panel);
		this.add(cardPanel);
		this.add(panel);
		//this.getContentPane().add(cardPanel);
		this.getContentPane().add(bj);
		
		
		setVisible(true);
	}
}