package TravelRaceGame.Controller;
import java.util.Observable;
import TravelRaceGame.Model.*;
import TravelRaceGame.View.*;


public class GameInstance implements IApplicationController
{
	private Model m_Model;
	private View m_View;
	
	public GameInstance(Model i_Model, View i_View)
	{
		m_Model = i_Model;
		m_View = i_View;
	}
	
	@Override
	public void update(Observable i_UpdateSender, Object arg)
	{
		if (i_UpdateSender instanceof View)
		{
			
		}
		else if (i_UpdateSender instanceof Model)
		{
			
		}
	}
	
		
}
