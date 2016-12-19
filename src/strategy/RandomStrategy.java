package strategy;

import java.awt.Color;

import domain.Board;
import domain.Positie;
import domain.Richting;
import domain.SchipType;
import domain.Vierkant;

public class RandomStrategy implements SpelStrategy {
	private int schepenOpBoard = 0;
	private Board bord;
	
	public void plaatsSchipOpponent() {
		while(schepenOpBoard < 5){
	
		int x = (int)(Math.random() *100);
	 	Vierkant vierkant = bord.getVierkanten().get(x);
	 	Positie positie = vierkant.getPositie();
		Richting richting = Richting.getRandomRichting();
		SchipType schip = SchipType.getRandomSchip();
		
		try{
		bord.plaatsSchipOpponent(richting, schip, positie);
		schepenOpBoard++; 
		}
		catch(Exception e){
			
		}
		}
	
	}

}
