package TravelRaceGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dice extends JButton
{
	// Date members:
	private int result;
	private String[] diceImages;
	private Timer diceAnimation;
	private int animationTime;
	
	public Dice()
	{
		super();
		diceImages = new String[6];
		animationTime = 12;
		SetRandomDice();
		//TODO
		// sizes
		
		this.validate();
	}
	
	public void SetRandomDice()
	{
		animateRandomImages();
		diceAnimation.start();
		this.setIcon(new ImageIcon(getClass().getResource(this.diceImages[result - 1]))); // set random dice image
	}
	
	private void animateRandomImages()
	{		
		diceAnimation = new Timer(250, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				animationTime--;
				if (animationTime >= 0)
				{
					result = (int)(Math.random() * 6) + 1;
					setIcon(new ImageIcon(getClass().getResource(diceImages[result - 1])));
					repaint();
				}
				else
				{
					diceAnimation.stop();
				}
			}
		});
	}
}