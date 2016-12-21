package strategy;


import java.awt.Color;

import domain.Board;
import domain.Position;
import domain.Richting;
import domain.SchipType;
import domain.Vierkant;


public class RandomStrategy implements SpelStrategy {
	private int schepenOpBoard = 0;
	
	
	public void plaatsSchipOpponent(Board board) {
		while(schepenOpBoard < 5) {
			int x = (int)(Math.random() *100);
			 		 	Vierkant vierkant = board.getVierkanten().get(x);
			 		 	Position positie = vierkant.getPositie();
			 			Richting richting = Richting.getRandomRichting();
			 			SchipType schip = SchipType.getRandomSchip();
			 			int nr = board.getNummer(positie);
			 				 if (board.fitsBoardVertical(richting, schip, positie) && board.fitsBoardHorizontal(richting, schip, positie)) {
			 					 if (!board.overlapsShip(richting, schip, positie)) {
			 						 if (board.isAvailable(schip)) {
			 							 board.getSizeVanSchepenOpponent().add(schip.getSize());
			 							 if (richting.equals(Richting.HORIZONTAAL)) {
			 								 for (int j = 0; j < schip.getSize(); j++) {
			 									board.setKleur(nr, Color.LIGHT_GRAY);
			 									board.getVierkanten().get(nr).setBezetSchip();
			 									board.setOmliggendeBezet(nr);
			 									board.getCoordinatenVanSchepenOpponent().add(nr);
			 									 nr += 10;
			 									 
			 								 }
						 }
			 							 else if (richting.equals(Richting.VERTICAAL)) {
			 								 for (int j = 0; j< schip.getSize(); j++) {
			 									board.setKleur(nr, Color.LIGHT_GRAY);
			 									board.getVierkanten().get(nr).setBezetSchip();
			 									board.setOmliggendeBezet(nr);
			 									board.getCoordinatenVanSchepenOpponent().add(nr);
			 									 nr++;
			 									
			 								 }
							 }
							 schepenOpBoard++;
						 } 
					 } 
				 }
	 }

	
	}

}
