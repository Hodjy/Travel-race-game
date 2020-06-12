package TravelRaceGame;

import TravelRaceGame.View.BoardPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.*;
import TravelRaceGame.View.MainMenu;
import TravelRaceGame.View.MainWindowFrame;

public class main {

	public static void main(String[] args) {
		//MainMenu main = new MainMenu();
		
        try {
        	MainWindowFrame ff = new MainWindowFrame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
