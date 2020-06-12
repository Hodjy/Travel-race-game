package TravelRaceGame.View;

import javax.swing.*;
import java.awt.event.*;


public class DiceButton extends JButton
{
	// Date members:
	private int result;
	private String[] diceImages;
	private Timer diceAnimator;
	private int animationSwitchCount;
	
	public DiceButton()
	{
		super();
		this.diceImages = new String[6];
		this.setDiceImages();
		this.SetRandomDice();
		this.setSize(84, 84);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setContentAreaFilled(false);
		this.setIcon(new ImageIcon(getClass().getResource(diceImages[0])));
		this.setVisible(true);
		this.validate();
	}
	
	public int GetResult()
	{
		return this.result;
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
	
	public void SetRandomDice()
	{
		this.animationSwitchCount = 10; // number of time that the dice image replace
		this.createRandomImageAnimator();
	}
	
	private void createRandomImageAnimator()
	{		
		this.diceAnimator = new Timer(100, new ActionListener() { // 100 is the animation delay time
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				diceAnimator.start();
				
				animationSwitchCount--;
				if (animationSwitchCount >= 0)
				{
					result = (int)(Math.random() * 6) + 1;
					setIcon(new ImageIcon(getClass().getResource(diceImages[result - 1])));  //set the dice image
					repaint();
				}
				else
				{
					diceAnimator.stop();
				}
			}
		});
	}
	
}