package TravelRaceGame.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
		this.setSize(1024, 720);
		BoardPanel panel = new BoardPanel();
		
		panel.setLayout(new BorderLayout());
		panel.setLocation(80, 40);
		
		this.getContentPane().add(panel, BorderLayout.WEST);
		this.getContentPane().add(new BackgroundPanel("/Images/GameBoard/FinalBoard(1024x720).png"));
		
		setVisible(true);
	}
}