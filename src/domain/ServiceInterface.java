package domain;

public interface ServiceInterface {

	public void plaatsSchip(Richting richting, SchipType schip, Position positie);
	
	public Board getBoard();
	
	public Board getBoardOpponant();
	
}
