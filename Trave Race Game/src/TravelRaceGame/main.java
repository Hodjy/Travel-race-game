package TravelRaceGame;

import java.io.IOException;

import TravelRaceGame.View.*;

public class main {

	public static void main(String[] args) {
		//MainMenu main = new MainMenu();
		
        try {
        	GameBoardUi ff = new GameBoardUi();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
