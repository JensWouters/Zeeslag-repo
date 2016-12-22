package State;

import domain.Board;

public class GestartState implements SpelState{

	public void startSpel(Board board) {
		board.setState(this);
	}

	
}
