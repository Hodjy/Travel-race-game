package TravelRaceGame.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;

import javax.swing.*;

import TravelRaceGame.Model.Model;


public class GameBoardUi extends Observable implements View
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
	
	
	// Getters/Setters:
	@Override
	public int GetCardClickedIndex()
	{
		return m_CardClickedIndex;
	}
	
	@Override
	public BoardPanel GetBoard()
	{
		return m_Board;
	}
	
	@Override
	public void Initilize()
	{
		m_Board.InitializeBoardPanel();
	}
	
	@Override
	public void EnablePlayButtons(boolean i_Enable)
	{
		EnableCardsInHandClick(i_Enable);
		EnableDiceButton(i_Enable);
	}
	
	@Override
	public void EnableCardsInHandClick(boolean i_Enable)
	{
		for (JButton cardButton : m_CurrentPlayerCardsInHand.GetCardsInHandButtons())
		{
			cardButton.setEnabled(i_Enable);
		}
	}
	
	@Override
	public void EnableDiceButton(boolean i_Enable)
	{
		m_Board.GetDiceButton().setEnabled(i_Enable);
	}
	
	
	private void diceEvent()
	{
		m_Board.GetDiceButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EnablePlayButtons(false);
				setChanged();
				notifyObservers(eNotificationType.DiceClicked);
			}
		});
		
	}
	
	@Override
	public void SetCardsInHandAndEnableEvents(String[] i_HandToSet)
	{
		m_CurrentPlayerCardsInHand.SetCardsInHand(i_HandToSet);
		setCardsInHandEvents();
	}
	
	private void setCardsInHandEvents()
	{	
		for (JButton cardButton : m_CurrentPlayerCardsInHand.GetCardsInHandButtons())
		{
			cardButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					EnableCardsInHandClick(false);
					m_CardClickedIndex = m_CurrentPlayerCardsInHand.GetCardsInHandButtons().indexOf(e.getSource());
					setChanged();
					notifyObservers(eNotificationType.CardClicked);
				}
			});
		}
	}
	
	public enum eNotificationType
	{
		CardClicked,
		DiceClicked,
		ReplayGame,	
	}
}
