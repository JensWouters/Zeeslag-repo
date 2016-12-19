package strategy;

import domain.Board;
import domain.Positie;
import domain.Richting;
import domain.SchipType;
import domain.Vierkant;

public class FixedStrategy1 implements SpelStrategy{
	private Board bord;
	public void plaatsSchipOpponent() {
		
		int x = 50;
	 	Vierkant vierkant = bord.getVierkanten().get(x);
	 	Positie positie = vierkant.getPositie();
		Richting richting = Richting.HORIZONTAAL;
		SchipType schip = SchipType.Slagschip;
		
		
		
		
	}

}
