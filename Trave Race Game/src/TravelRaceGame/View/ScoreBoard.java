package TravelRaceGame.View;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import TravelRaceGame.Model.*;

public class ScoreBoard 
{
	private final int f_FrameWidth = 800 + 6;
	private final int f_FrameHeight = 600 + 29;
	private JFrame m_ScoreFrame;
	private JPanel m_ScorePanel;
	private BackgroundPanel m_FrameBackground;
	private JButton m_BackButton;
	private JLabel m_HighScores;

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
		m_HighScores = new JLabel();

		m_ScoreFrame.setSize(f_FrameWidth, f_FrameHeight);
		m_ScoreFrame.setTitle("Score Board");
		m_ScoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ScoreFrame.setResizable(false);
		m_ScoreFrame.setLocationRelativeTo(null);

		m_ScorePanel.setSize(640, 440);
		m_ScorePanel.setLocation(80, 80);
		m_ScorePanel.setOpaque(false);
		m_ScorePanel.setVisible(true);
		
		m_BackButton.setIcon(new ImageIcon(this.getClass().getResource("/Images/ScoreBoard/BackButton.png")));
		m_BackButton.setSize(141, 25);
		m_BackButton.setLocation(330, 550);
		m_BackButton.setBackground(new Color(235, 189, 52));
		m_BackButton.setVisible(true);
		
		
		m_HighScores.setFont(new Font("Comic Sans MS", Font.PLAIN, 26));
		m_HighScores.setForeground(Color.RED);
		m_HighScores.setLocation(5, 0);
		m_HighScores.setSize(m_ScorePanel.getSize());
		m_HighScores.setHorizontalAlignment(SwingConstants.CENTER);
		m_HighScores.setVerticalAlignment(SwingConstants.TOP);
		m_HighScores.setVisible(true);

		m_FrameBackground = new BackgroundPanel("/Images/ScoreBoard/ScoreBoardBackground.png");
		
		m_ScorePanel.add(m_HighScores);
		m_ScoreFrame.add(m_ScorePanel);
		m_ScoreFrame.add(m_BackButton);
		m_ScoreFrame.getContentPane().add(m_FrameBackground);

		AttachButtonEvents();

		m_ScoreFrame.setVisible(true);
		m_ScoreFrame.repaint();
		m_ScoreFrame.validate();
		
		getHighScores();
	}


	private void getHighScores()
	{
		StringBuilder highScores = new StringBuilder();
		
		for (int i = 0 ; i < HighScoreHandler.GetAmountOfHighScores() ; i++)
		{
			highScores.append(i + 1 + ". ");
			highScores.append(HighScoreHandler.ReadHighScoreAtPlacement(i));
			highScores.append("<br/>");
		}
		
		m_HighScores.setText("<html>" + highScores.toString() + "</html>");
		//m_HighScores.validate();
		//m_HighScores.repaint();
	}
	
	private void AttachButtonEvents()
	{
		m_BackButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenu newMain = new MainMenu();
				m_ScoreFrame.dispose();				
			}
		});		
	}
	
}
