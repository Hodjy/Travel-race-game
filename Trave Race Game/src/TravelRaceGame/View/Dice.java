package TravelRaceGame;

import javax.swing.*;
import java.awt.event.*;

public class Dice extends JButton
{
	// Date members:
	private int result;
	private String[] diceImages;
	private Timer diceAnimator;
	private int animationSwitchCount;
	
	public Dice()
	{
		super();
		this.diceImages = new String[6];
		this.setDiceImages();
		this.SetRandomDice();
		//TODO
		// sizes
		
		this.validate();
	}
	
	public int GetResult()
	{
		return this.result;
	}
	
	private void setDiceImages()
	{
		// TODO: Add the image path to each dice side
	}
	
	public void SetRandomDice()
	{
		this.animationSwitchCount = 10; // number of time that the dice image replace
		this.createRandomImageAnimator();
		this.diceAnimator.start();
	}
	
	private void createRandomImageAnimator()
	{		
		this.diceAnimator = new Timer(100, new ActionListener() { // 100 is the animation delay time
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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