package TravelRaceGame.View;

import java.io.IOException;

import javax.swing.*;
import TravelRaceGame.Model.*;

public class ScoreBoard 
{
	private final int f_FrameWitdh = 800;
	private final int f_FrameHeight = 600;
	private JFrame m_ScoreFrame;
	private JPanel m_ScorePanel;
	private BackgroundPanel m_FrameBackground;
	private JButton m_BackButton;
	private JTextField m_HighScores;

	public ScoreBoard()
	{
		try 
		{
			InitializeComponents();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private void InitializeComponents() throws IOException
	{
		m_ScoreFrame = new JFrame();
		m_ScorePanel = new JPanel(null);
		m_BackButton = new JButton();
		m_HighScores = new JTextField();

		m_ScoreFrame.setSize(f_FrameWitdh, f_FrameHeight);
		m_ScoreFrame.setTitle("Score Board");
		m_ScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ScoreFrame.setResizable(false);
		m_ScoreFrame.setLocationRelativeTo(null);

		m_ScorePanel.setSize(640, 440);
		m_ScorePanel.setLocation(80, 80);
		m_ScorePanel.setOpaque(false);
		
		m_BackButton.setText("Back");
		m_BackButton.setSize(141, 25);
		m_BackButton.setLocation(388, 750);
		m_BackButton.setVisible(true);

		m_HighScores.setLocation(300, 80);
		m_HighScores.setVisible(true);

		m_FrameBackground = new BackgroundPanel("/Images/ScoreBoard/ScoreBoardBackground.png");
		
		
		m_ScorePanel.add(m_HighScores);
		m_ScorePanel.add(m_BackButton);
		m_ScoreFrame.add(m_ScorePanel);
		m_ScoreFrame.getContentPane().add(m_FrameBackground);

		getHighScore();

		m_ScoreFrame.setVisible(true);
		m_ScoreFrame.validate();
	}

	private void getHighScore()
	{
		String highScores = new String();
		for (int i = 0 ; i < HighScoreHandler.GetAmountOfHighScores() ; i++)
		{
			highScores.concat(HighScoreHandler.ReadHighScoreAtPlacement(i) + "\n");
		}
		
		m_HighScores.setText(highScores);
	}
}
