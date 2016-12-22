package domain;



public class Service implements ServiceInterface {
	

	private Spel spel;
	
	public Service() {
		spel = new Spel();
	}

	public void plaatsSchip(Richting richting, SchipType schip, Position positie) {
		spel.plaatsSchip(richting, schip, positie);
	}


	public Board getBoard() {
		return spel.getBoard();
	}
	
	public Spel getSpel(){
		return spel;
	}
	
	public Board getBoardOpponent() {
		return spel.getBoardOpponent();
	}
	
	public void attackSchip(Position position){
		spel.getBoardOpponent().attackSchip(position, spel.getBoardOpponent());
	}
	
	
}
