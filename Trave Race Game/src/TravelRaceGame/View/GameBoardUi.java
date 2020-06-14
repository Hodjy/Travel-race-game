package TravelRaceGame.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class GameBoardUi extends View
{
	private final int f_FrameWitdh = 1024 + 5;
	private final int f_FrameHeight = 720 + 35;
	private final int f_BoardX = 68;
	private final int f_BoardY = 64;
	private final int f_CardsX = 100;
	private final int f_CardsY = 450;
	
	private JFrame m_MainGameFrame;
	private BoardPanel m_Board;
	private CardsInHandPanel m_CurrentPlayerCardsInHand;
	private BackgroundPanel m_FrameBackground;
	private int m_CardClickedIndex;
	private String m_PlayerOneName;
	private String m_PlayerTwoName;
	
	
	public GameBoardUi() throws IOException
	{
		m_MainGameFrame = new JFrame();
		m_MainGameFrame.setSize(f_FrameWitdh, f_FrameHeight);
		m_MainGameFrame.setResizable(false);
		m_MainGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m_Board = new BoardPanel();
		m_CurrentPlayerCardsInHand = new CardsInHandPanel();
		m_FrameBackground = new BackgroundPanel("/Images/GameBoard/FinalBoard.png");

		m_Board.setLocation(f_BoardX, f_BoardY);
		m_CurrentPlayerCardsInHand.setLocation(f_CardsX, f_CardsY);
		m_MainGameFrame.add(m_Board);
		m_MainGameFrame.add(m_CurrentPlayerCardsInHand);
		m_MainGameFrame.getContentPane().add(m_FrameBackground);
		
		diceEvent();
		
		m_MainGameFrame.setEnabled(true);
		m_MainGameFrame.setVisible(true);
		
		
	}
	
	public void Initilize()
	{
		m_Board.InitializeBoardPanel();
	}
	
	private void diceEvent()
	{
		m_Board.GetDiceButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				m_Board.GetDiceButton().setEnabled(false);
				setChanged();
				notifyObservers(eNotificationType.DiceClicked);
			}
		});
		
	}
	
	
	public enum eNotificationType
	{
		NamesInput,
		CardClicked,
		DiceClicked,
		ReplayGame,	
	}
}
