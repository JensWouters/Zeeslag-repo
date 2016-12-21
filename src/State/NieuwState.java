package State;

import domain.Board;

public class NieuwState implements SpelState{

	public void startSpel(Board board) {
		board.setState(this);
	}

	public void plaatsSchepen(Board board) {
		// TODO Auto-generated method stub
		
	}
}
