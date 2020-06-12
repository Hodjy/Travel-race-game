package TravelRaceGame.View;

import java.awt.*;
import javax.swing.*;

public class BoardPanel extends JPanel 
{
	private final int f_TilesNumber = 28;
	private final int f_BoardWidth = 890;
	private final int f_BoardHeight = 400;
	private DiceButton m_DiceButton;
	private Point[] m_PlayerOneTilesLocation;
	private Point[] m_PlayerTwoTilesLocation;
	private JLabel m_PlayerOneAvatar;
	private JLabel m_PlayerTwoAvatar;
	
	
	public BoardPanel()
	{
		super();
		this.setSize(f_BoardWidth, f_BoardHeight);
		this.setBackground(new Color(0, 0, 0, 0));
		
		m_DiceButton = (DiceButton)ButtonFactory.CreateButton("Dice");
		m_DiceButton.setLocation(650, 240);
		
		m_PlayerOneTilesLocation = new Point[f_TilesNumber];
		m_PlayerTwoTilesLocation = new Point[f_TilesNumber];
		m_PlayerOneAvatar = new JLabel();
		m_PlayerTwoAvatar = new JLabel();
		initializePlayerAvatars(m_PlayerTwoAvatar);
		initializePlayerAvatars(m_PlayerOneAvatar);
		m_PlayerOneAvatar.setIcon(new ImageIcon(getClass().getResource("/Images/Players/PlayerOneAvatar.png")));
		m_PlayerTwoAvatar.setIcon(new ImageIcon(getClass().getResource("/Images/Players/PlayerTwoAvatar.png")));
		
		initializeTiles();
		InitializeBoardPanel();
	}
	
	private void InitializeBoardPanel()
	{
		// TODO: set location on panel for dice and players

		m_PlayerOneAvatar.setLocation(m_PlayerOneTilesLocation[0]);
		m_PlayerTwoAvatar.setLocation(m_PlayerTwoTilesLocation[0]);
		this.add(m_PlayerOneAvatar);
		this.add(m_PlayerTwoAvatar);
		this.setEnabled(true);
		this.setVisible(true);
		this.validate();
	}
	
	private void initializePlayerAvatars(JLabel i_PlayerAvatar)
	{
		i_PlayerAvatar.setSize(15, 15);
		i_PlayerAvatar.setBorder(BorderFactory.createEmptyBorder());
		i_PlayerAvatar.setVisible(true);
		i_PlayerAvatar.setEnabled(true);
	}
	
	private void initializeTiles()
	{
		int xCoord = 850, yCoord = 460; 
		
		// player on lower board side
		for (int i = 0; i <= 10; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord, yCoord - 20);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord, yCoord + 20);
			xCoord -= 80;
		}
		
		// player on left board side		
		for (int i = 11; i <= 13; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord + 20, yCoord);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord - 20, yCoord);
			yCoord -= 80;
		}
		
		// player on top board side
		for (int i = 14; i <= 24; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord, yCoord + 20);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord, yCoord - 20);
			xCoord += 80;
		}
		
		// player on right board side		
		for (int i = 25; i <= 27; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord - 20, yCoord);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord + 20, yCoord);
			yCoord += 80;
		}
	}

	public void setPlayersLocation(int i_PlayerOneLocation, int i_PlayerTwoLocation)
	{
		m_PlayerOneAvatar.setLocation(m_PlayerOneTilesLocation[i_PlayerOneLocation]);
		m_PlayerTwoAvatar.setLocation(m_PlayerTwoTilesLocation[i_PlayerTwoLocation]);
	}
}
