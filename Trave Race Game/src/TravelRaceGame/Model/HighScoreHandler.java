package TravelRaceGame.Model;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class HighScoreHandler
{	
	private static final String sf_FileName = "HighScore.txt";
	private static final String sf_FilePath = "Trave Race Game/src/TravelRaceGame/Database";
	private static File s_HighScoreFile = new File(sf_FilePath, sf_FileName);
	private static final int sf_MaxHighScores = 10;

	public static int GetAmountOfHighScores()
	{
		List<String> allHighScores = new ArrayList<String>();
		
		try 
		{
			allHighScores = Files.readAllLines(getHighScoreFile().toPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return allHighScores.size();
	}
	
	public static String ReadHighScoreAtPlacement(int i_Placement)
	{
		String highScoreToReturn = null;
		
		try {
			List<String> allHighScores = Files.readAllLines(getHighScoreFile().toPath());
			highScoreToReturn = allHighScores.get(i_Placement);
		}
		catch(IOException ex){
			ex.printStackTrace();
		}

		return highScoreToReturn;
	}

	private static int readScoreAtPlacement(int i_Placement) throws IOException
	{
		int scoreToReturn = 0;
		
		List<String> allHighScores = Files.readAllLines(getHighScoreFile().toPath());
		String highScoreAtLocation = allHighScores.get(i_Placement);
		highScoreAtLocation = highScoreAtLocation.substring(highScoreAtLocation.lastIndexOf("-") + 2);
		scoreToReturn = Integer.parseInt(highScoreAtLocation);
		
		return scoreToReturn;
	}

	public static void WriteHighScore(String i_Name, int i_Score)
	{			
		int i = 0;	
		
		try
		{
			getHighScoreFile().setWritable(true);
			
			for (i = 0; i < GetAmountOfHighScores(); i++)
			{
				if (i_Score > readScoreAtPlacement(i))
				{
					break;
				}
			}
			
			List<String> allHighScores = Files.readAllLines(getHighScoreFile().toPath());
			allHighScores.add(i, i_Name + " - " + String.valueOf(i_Score));
			
			if (allHighScores.size() >= sf_MaxHighScores)
			{
				allHighScores.remove(allHighScores.size() - 1);
			}
			
			Files.write(getHighScoreFile().toPath(), allHighScores);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	private static File getHighScoreFile()
	{
		try {
			s_HighScoreFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s_HighScoreFile;
	}
}
