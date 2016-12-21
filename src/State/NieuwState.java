package State;

import domain.Board;

public class NieuwState implements SpelState{

	public void startSpel(Board board) {
		System.out.println("Player is in start state");
		board.setState(this);
	}

	public void plaatsSchepen() {
		// TODO Auto-generated method stub
		
	}
}
