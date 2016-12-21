package State;

import domain.Board;

public class GestartState implements SpelState{

	public void startSpel(Board board) {
		board.setState(this);
	}

	public void plaatsSchepen(Board board) {
		
	}

	public void plaatsSchepen() {
		// TODO Auto-generated method stub
		
	}

}
