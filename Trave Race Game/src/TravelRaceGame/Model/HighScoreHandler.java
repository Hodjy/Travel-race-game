package TravelRaceGame.Model;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class HighScoreHandler
{	
	private static final String sf_FileName = "/TravelRaceGame/Database/HighScore.txt";
	private static File s_HighScoreFile = new File(sf_FileName);
	private static int s_AmountOfHighScores = 0;
	private static final int sf_MaxHighScores = 10;


	public static int GetAmountOfHighScores()
	{
		return s_AmountOfHighScores;
	}
	
	public static String ReadHighScoreAtPlacement(int i_Placement)
	{
		String highScoreToReturn = null;
		
		try {
			List<String> allHighScores = Files.readAllLines(Paths.get(sf_FileName));
			highScoreToReturn = allHighScores.get(i_Placement - 1);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

		return highScoreToReturn;
	}

	private static int ReadScoreAtPlacement(int i_Placement) throws IOException
	{
		int scoreToReturn = 0;
		List<String> allHighScores = Files.readAllLines(Paths.get(sf_FileName));
		String highScoreAtLocation = allHighScores.get(i_Placement - 1);
		highScoreAtLocation = highScoreAtLocation.substring(highScoreAtLocation.lastIndexOf(" - ") + 2);

		scoreToReturn = Integer.parseInt(highScoreAtLocation);

		return scoreToReturn;
	}

	public static void WriteHighScore(String i_Name, int i_Score)
	{			
		int i = 0;
		
		try
		{
			s_HighScoreFile.createNewFile();
			
			for (i = 0; i < s_AmountOfHighScores; i++)
			{
				if (i_Score > ReadScoreAtPlacement(i + 1))
				{
					break;
				}
			}
			
			List<String> allHighScores = Files.readAllLines(s_HighScoreFile.toPath());
			allHighScores.add(i, i_Name + " - " + String.valueOf(i_Score));
			
			if (s_AmountOfHighScores < sf_MaxHighScores)
			{
				s_AmountOfHighScores++;
			}
			else
			{
				allHighScores.remove(allHighScores.size() - 1);
				
			}
			
			Files.write(s_HighScoreFile.toPath(), allHighScores);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
