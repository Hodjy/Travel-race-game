package TravelRaceGame.View;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class BackgroundPanel extends JPanel
{
    private Image backgroundImg;

    public BackgroundPanel(String i_ImagePath) throws IOException
    {
    	super();
        backgroundImg = ImageIO.read(getClass().getResource(i_ImagePath));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImg, 0, 0, this);
    }
}


