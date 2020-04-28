package TravelRaceGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
public class Dice extends JButton
{
	// Date members:
	private int result;
	private String[] diceImages;
	
	public Dice()
	{
		super();
		diceImages = new String[6];
		SetRandomDice();
		//TODO
		// sizes
		
		this.validate();
	}
	
	public void SetRandomDice()
	{
		this.result = (int)(Math.random() * ((6 - 1) + 1)) + 1;
		animateRandomImages();
		this.setIcon(new ImageIcon(getClass().getResource(this.diceImages[result]))); // set random dice image
	}
	
	private void animateRandomImages()
	{
		Timer delay = new Timer();
		delay.schedule(arg0, arg1);
		for (int i = 0, randNumber; i < 6; i++)
		{
			randNumber = (int)(Math.random() * ((6 - 1) + 1)) + 1;
			this.setIcon(new ImageIcon(getClass().getResource(this.diceImages[randNumber])));
			this.validate();
		}
	}
}
