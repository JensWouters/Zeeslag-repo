package strategy.aanvalstrategy;

import java.awt.Color;

import domain.Board;
import domain.Position;
import domain.Vierkant;

public class RandomAanvalStrategy implements AanvalStrategy{
	Board board;

	public void attackSchipComputer(Board board) {
		 	int a = (int)(Math.random() *100);
			Vierkant vierkant = board.getVierkanten().get(a);
			Position position = vierkant.getPositie();
			int nr = board.getNummer(position);
				 if(vierkant.getKleur().equals(Color.LIGHT_GRAY) || vierkant.getKleur().equals(Color.WHITE)){
					 	if(board.getVierkanten().get(nr).getBezetSchip() == true){
					 			board.setKleur(nr, Color.GREEN);
					 			
				 }
					 	else{
					 board.setKleur(nr, Color.BLUE);
				 }
			 
		 }
				 else{
					 this.attackSchipComputer(board);
			 }
		 }
	}

