package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Vierkant> vierkanten = new ArrayList<Vierkant>();

	public Board(int zijde, int aantal) {
		int y = 0;
		int x = 0;
		
		for (int i = 0; i < aantal;i++){
			for (int j = 0; j < aantal; j++){
				vierkanten.add(new Vierkant(x+zijde*i,y+zijde*j,zijde,Color.LIGHT_GRAY));
			}	
		}
	}
	
	public List<Vierkant> getVierkanten() {
		return vierkanten;
	}

}
