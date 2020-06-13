package TravelRaceGame.View;

import java.awt.*;
import javax.swing.*;

public class BoardPanel extends JPanel 
{
	private final int f_TilesNumber = 28;
	private final int f_BoardWidth = 1000;
	private final int f_BoardHeight = 400;
	private final int f_BoardX = 68;
	private final int f_BoardY = 64;
	private final int f_DiceX = 650;
	private final int f_DiceY = 160;
	
	private DiceButton m_DiceButton;
	private Point[] m_PlayerOneTilesLocation;
	private Point[] m_PlayerTwoTilesLocation;
	private JLabel m_PlayerOneAvatar;
	private JLabel m_PlayerTwoAvatar;
	private JLabel m_InstructionToShow;
	
	
	public BoardPanel()
	{
		super(null);
		this.setSize(f_BoardWidth, f_BoardHeight);
		this.setBackground(new Color(0, 0, 0, 0));
		
		m_InstructionToShow = new JLabel();
		m_InstructionToShow.setBounds(340, 90, 240, 180);
		m_InstructionToShow.setForeground(Color.BLACK);
		m_InstructionToShow.setFont(new Font("David", Font.ITALIC, 30));
		this.add(m_InstructionToShow);
		SetInstuctionText("Welcome to Travel Race Game!");
		
		m_DiceButton = (DiceButton)ButtonFactory.CreateButton("Dice");
		m_DiceButton.setLocation(f_DiceX, f_DiceY);
		this.add(m_DiceButton);
		
		m_PlayerOneTilesLocation = new Point[f_TilesNumber];
		m_PlayerTwoTilesLocation = new Point[f_TilesNumber];
		m_PlayerOneAvatar = new JLabel();
		m_PlayerTwoAvatar = new JLabel();
		initializePlayerAvatars(m_PlayerTwoAvatar);
		initializePlayerAvatars(m_PlayerOneAvatar);
		m_PlayerOneAvatar.setIcon(new ImageIcon(getClass().getResource("/Images/GameBoard/PlayerOneAvatar.png")));
		m_PlayerTwoAvatar.setIcon(new ImageIcon(getClass().getResource("/Images/GameBoard/PlayerTwoAvatar.png")));
		this.add(m_PlayerOneAvatar);
		this.add(m_PlayerTwoAvatar);
		
		initializeTiles();
		InitializeBoardPanel();
	}
	
	 
	
	private void InitializeBoardPanel()
	{
		SetInstuctionText("Welcome to Travel Race Game!" );
		m_PlayerOneAvatar.setLocation(m_PlayerOneTilesLocation[0]);
		m_PlayerTwoAvatar.setLocation(m_PlayerTwoTilesLocation[0]);
		this.setEnabled(true);
		this.setVisible(true);
		this.validate();
	}
	
	private void initializePlayerAvatars(JLabel i_PlayerAvatar)
	{
		i_PlayerAvatar.setSize(28, 28);
		i_PlayerAvatar.setBorder(BorderFactory.createEmptyBorder());
		i_PlayerAvatar.setVisible(true);
		i_PlayerAvatar.setEnabled(true);
	}
	
	private void initializeTiles()
	{
		int xCoord = 830, yCoord = 350; 
		int avatarOffset = 20;
		int coordinateOffset = 80;
		
		// player on lower board side
		for (int i = 0; i < 10; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord, yCoord - avatarOffset);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord, yCoord + avatarOffset);
			xCoord -= coordinateOffset;
		}
		
		// player on left board side		
		for (int i = 10; i <= 13; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord + avatarOffset, yCoord);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord - avatarOffset, yCoord);
			yCoord -= coordinateOffset;
		}
		
		// player on top board side
		for (int i = 14; i < 24; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord, yCoord + avatarOffset);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord, yCoord - avatarOffset);
			xCoord += coordinateOffset;
		}
		
		// player on right board side		
		for (int i = 24; i <= 27; i++)
		{
			m_PlayerOneTilesLocation[i] = new Point(xCoord - avatarOffset, yCoord);
			m_PlayerTwoTilesLocation[i] = new Point(xCoord + avatarOffset, yCoord);
			yCoord += coordinateOffset;
		}
	}

	public void SetPlayersLocation(int i_PlayerOneLocation, int i_PlayerTwoLocation)
	{
		m_PlayerOneAvatar.setLocation(m_PlayerOneTilesLocation[i_PlayerOneLocation]);
		m_PlayerTwoAvatar.setLocation(m_PlayerTwoTilesLocation[i_PlayerTwoLocation]);
	}
	
	public void SetInstuctionText(String i_InstrucionStr)
	{
		m_InstructionToShow.setText("<html>" + i_InstrucionStr + "</html>");
	}
}
