package domain;


public interface ServiceInterface {

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie);
	
	public Board getBord();
}
