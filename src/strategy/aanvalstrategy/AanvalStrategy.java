package strategy.aanvalstrategy;

import java.util.List;

import domain.Board;


public interface AanvalStrategy {
	
	public void attackSchipComputer(Board board);
	public void killSchip(List<Integer> coordinaten);
	public boolean isKilled(List<Integer> coordinaten);
	public List<Integer> getAangevallenSchip(int nr);
	public void coordinatenPerSchip(List<Integer> coordinaten);
	public int getScore();

}
