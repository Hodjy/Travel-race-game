package TravelRaceGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindowFrame extends JFrame
{
	// Data Members:
	private GameBoard board;
	private Dice gameDice;
	private JLabel player1Label;
	private JLabel player2Label;
	private JLabel player1Avatar;
	private JLabel player2Avatar;
	private GameInstance currentGameInstance;
	// private players cards
	
	public MainWindowFrame()
	{
		super();
		currentGameInstance = new GameInstance();
		board = new GameBoard();
		gameDice = new Dice();
		avatarCreate(player1Avatar, new Color(255, 0, 0));
		avatarCreate(player2Avatar, new Color(0, 0, 255));
		playerLabelInput(player1Label, 1);
		playerLabelInput(player2Label, 2);
		setInitialLocations();
		
		setEvents();
	}
	
	private void avatarCreate(JLabel m_Player, Color i_PlayerColor)
	{
		m_Player = new JLabel();
		m_Player.setBackground(i_PlayerColor);
		m_Player.setSize(10, 10);
	}
	
	private void playerLabelInput(JLabel m_PlayerLabel, int i_PlayerNum)
	{
		m_PlayerLabel = new JLabel(currentGameInstance.GetPlayerName(i_PlayerNum));
	}
	// TODO
	private void setInitialLocations()
	{
		
	}
	
	private void setEvents()
	{
		
	}
	
}
