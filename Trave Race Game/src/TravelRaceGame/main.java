package TravelRaceGame;

import TravelRaceGame.View.BoardPanel;
import TravelRaceGame.View.GameBoard;
import javax.swing.*;
import TravelRaceGame.View.MainMenu;

public class main {

	public static void main(String[] args) {
		//MainMenu main = new MainMenu();
		
		JFrame ff = new JFrame();
		BoardPanel fe = new BoardPanel();
		
		ff.setSize(1024, 720);
		ff.add(fe);
	}

}
