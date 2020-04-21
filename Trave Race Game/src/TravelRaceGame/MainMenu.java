package TravelRaceGame;
import javax.swing.*;
import java.lang.*;
import java.awt.*;


public class MainMenu extends JFrame
{
	
	private JPanel 		mainMenuPanel;
	private JButton 	startGameButton;
	private JButton 	showScoreboardButton;
	private JButton 	quitGameButton;
	private String 		frameTitleName; 
	private JLabel 		backgroundImage;
	private Dimension 	buttonResolution;
	private int 		spaceBetweenButtons;
	
	public MainMenu() 
	{	
		super();
		buildMainMenuFrame();
		buildMainMenuPanel();
		setBackgroundImage();
		this.validate();
	}
	
	// builds the frame components
	private void buildMainMenuFrame()
	{		
		this.setTitle("Travel Race Game");
		this.setSize(800, 600);
		this.setResizable(false);
		this.buttonResolution = new Dimension(141, 25);
		this.setVisible(true);
	}
	
	private void setBackgroundImage()
	{
		this.backgroundImage = new JLabel();
		this.backgroundImage.setIcon(new ImageIcon(getClass().getResource("/Images/MainMenuBackgroundNoButtons.png")));
		this.backgroundImage.setSize(this.getSize());
		this.add(this.backgroundImage);
	}
	
	private void buildMainMenuPanel() 
	{
		this.mainMenuPanel = new JPanel();
		this.spaceBetweenButtons = 30;
		this.mainMenuPanel.setLocation(260, 260);
		this.mainMenuPanel.setVisible(true);
		this.mainMenuPanel.setOpaque(false);
		this.mainMenuPanel.setSize(buttonResolution.width + 5, (buttonResolution.height + spaceBetweenButtons) * 3);
		buildStartGameButton();
		buildScoreboardButton();
		buildQuitGameButton();
		this.mainMenuPanel.setLayout(new BorderLayout());
		this.add(mainMenuPanel);
	}
	
	private void buildStartGameButton()
	{
		this.startGameButton = new JButton();
		this.startGameButton.setIcon(new ImageIcon(getClass().getResource("/Images/MainMenuStartButton.png")));
		this.startGameButton.setSize(buttonResolution);
		this.startGameButton.setLocation(0, 0);
		this.startGameButton.setVisible(true);
		this.startGameButton.setBackground(new Color(235, 189, 52));
		this.mainMenuPanel.add(this.startGameButton);
	}
	
	private void buildScoreboardButton()
	{
		this.showScoreboardButton = new JButton();
		this.showScoreboardButton.setLocation(0, this.startGameButton.getLocation().y + this.spaceBetweenButtons);
		this.showScoreboardButton.setSize(buttonResolution);
		this.showScoreboardButton.setIcon(new ImageIcon(getClass().getResource("/Images/MainMenuScoreBoardButton.png")));
		this.showScoreboardButton.setVisible(true);
		this.showScoreboardButton.setBackground(new Color(235, 189, 52));
		this.mainMenuPanel.add(this.showScoreboardButton);
	}
	
	private void buildQuitGameButton()
	{
		this.quitGameButton = new JButton();
		this.quitGameButton.setIcon(new ImageIcon(getClass().getResource("/Images/MainMenuQuitButton.png")));
		this.quitGameButton.setSize(buttonResolution);
		this.quitGameButton.setVisible(true);
		this.quitGameButton.setLocation(0, this.showScoreboardButton.getLocation().y + this.spaceBetweenButtons);
		this.quitGameButton.setBackground(new Color(235, 189, 52));
		this.mainMenuPanel.add(this.quitGameButton);
	}
	
	
	
}
