package domain;

public class Service implements ServiceInterface {
	
	private Board bord;

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		bord.plaatsSchip(richting, schip, positie);
	}

	public Board getBord() {
		return bord;
	}
	
}
