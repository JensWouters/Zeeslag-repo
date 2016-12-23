package strategy.aanvalstrategy;
/*
 * @Author Gezamenlijk gemaakt
 */
import java.util.List;

import domain.Board;

public class SmartAanvalStrategy implements AanvalStrategy{
	
	public int score = 19;
	public int deadShips = 0;

	public void attackSchipComputer(Board board) {
		
		
	}

	public void killSchip(List<Integer> coordinaten) {
		// TODO Auto-generated method stub
		
	}

	public boolean isKilled(List<Integer> coordinaten) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Integer> getAangevallenSchip(int nr) {
		// TODO Auto-generated method stub
		return null;
	}

	public void coordinatenPerSchip(List<Integer> coordinaten) {
		// TODO Auto-generated method stub
		
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDeadShips() {
		return deadShips;
	}

}
