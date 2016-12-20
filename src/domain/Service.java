package domain;



public class Service implements ServiceInterface {
	
	private Board board;
	private Board boardOpponent;
	
	public Service() {
		this.board = new Board(25,10);
		this.boardOpponent = new Board(25,10);
	}

	public void plaatsSchip(Richting richting, SchipType schip, Position positie) {
		board.plaatsSchip(richting, schip, positie);
	}
	
	

	public Board getBoard() {
		return board;
	}
	
	public Board getBoardOpponant() {
		return this.boardOpponent;
	}
	
}
