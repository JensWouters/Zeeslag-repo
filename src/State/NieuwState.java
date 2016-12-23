package State;
/*
 * @Author Gezamenlijk gemaakt
 */
import domain.Board;

public class NieuwState implements SpelState{

	public void startSpel(Board board) {
		board.setState(this);
	}

	
}
