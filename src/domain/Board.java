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

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		List<Vierkant> vierkanten = this.getVierkanten();
		
		if (richting.equals(Richting.HORIZONTAAL)) {
			for (Vierkant v : vierkanten) {
				if (v.getPositie() == positie) {
					for (int i = 0; i < schip.getSize(); i++) {
						vierkanten.get(i).setBezet();
						vierkanten.get(i).setKleur(Color.GREEN);
					}
				}
			}
		} else if (richting.equals(Richting.VERTICAAL)) {
			for (Vierkant v : vierkanten) {
				if (v.getPositie() == positie) {
					for (int i = 0; i < schip.getSize()*10; i++) {
						vierkanten.get(i).setBezet();
						
						vierkanten.get(i).setKleur(Color.GREEN);
						i+= 10;
					}
				}
			}
		}
	}
}
