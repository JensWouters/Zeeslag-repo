package domain;

public interface ServiceInterface {

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie);
	
	public BordPanel getBord();
	
	public BordPanel getBordOpponant();
	
	public void plaatsSchipOpponent();
		
	
}
