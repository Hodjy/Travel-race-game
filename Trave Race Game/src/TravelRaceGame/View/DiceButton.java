package TravelRaceGame.View;

import javax.swing.*;
import java.awt.event.*;

public class DiceButton extends JButton
{
	// Date members:
	private String[] diceImages;
	private Timer diceAnimator;
	private int animationSwitchCount;
	
	public DiceButton()
	{
		super();
		this.diceImages = new String[6];
		this.setDiceImages();
		this.setSize(84, 84);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setIcon(new ImageIcon(getClass().getResource(diceImages[0])));
		this.setDisabledIcon(this.getIcon());
		this.setVisible(true);
		this.validate();
	}
	
	public Timer GetDiceAnimator()
	{
		return diceAnimator;
	}
	
	private void setDiceImages()
	{
		diceImages[0] = "/Images/Dice/FinalDice1.png";
		diceImages[1] = "/Images/Dice/FinalDice2.png";
		diceImages[2] = "/Images/Dice/FinalDice3.png";
		diceImages[3] = "/Images/Dice/FinalDice4.png";
		diceImages[4] = "/Images/Dice/FinalDice5.png";
		diceImages[5] = "/Images/Dice/FinalDice6.png";	
	}
	
	public void RollDice(int i_DiceImageIndex)
	{	
		animationSwitchCount = 10;
		ActionListener action = new ActionListener() {
		int imageIndex;
		
			@Override
			public void actionPerformed(ActionEvent e) {
				animationSwitchCount--;
				
				if (animationSwitchCount >= 0)
				{
					imageIndex = (int)(Math.random() * 6) + 1;
					setIcon(new ImageIcon(getClass().getResource(diceImages[imageIndex - 1])));  //set the dice image
					setDisabledIcon(getIcon());
					repaint();
				}
				else
				{
					diceAnimator.stop();
					setIcon(new ImageIcon(getClass().getResource(diceImages[i_DiceImageIndex - 1])));
				}
			}
		};
		
		this.diceAnimator = new Timer(100, action);
		this.diceAnimator.start();
	}
	
}