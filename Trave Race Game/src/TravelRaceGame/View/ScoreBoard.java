package TravelRaceGame.View;

import javax.swing.*;
import TravelRaceGame.Model.*;

public class ScoreBoard 
{
	private JFrame m_ScoreFrame;
	private JPanel m_ScorePanel;
	private JButton m_BackButton;
	private JTextField m_HighScores;

	public ScoreBoard()
	{
		InitializeComponents();
	}

	private void InitializeComponents()
	{
		m_ScoreFrame = new JFrame();
		m_ScorePanel = new JPanel();
		m_BackButton = new JButton();
		m_HighScores = new JTextField();

		m_ScoreFrame.setSize(1024, 720);
		m_ScoreFrame.setTitle("Score Board");
		m_ScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ScoreFrame.setResizable(false);
		m_ScoreFrame.setLocationRelativeTo(null);

		m_BackButton.setText("Back");
		m_BackButton.setLocation(954, 670);
		m_BackButton.setVisible(true);

		m_HighScores.setLocation(250, 50);
		m_HighScores.setVisible(true);

		m_ScorePanel.add(m_BackButton);
		m_ScorePanel.add(m_HighScores);
		m_ScoreFrame.add(m_ScorePanel);


		getHighScore();


		m_ScoreFrame.setVisible(true);
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
