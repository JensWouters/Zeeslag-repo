package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;



public class Board {
	
	private List<Vierkant> vierkanten = new ArrayList<Vierkant>();
	private List<String> schepen = new ArrayList<String>(Arrays.asList("vliegdekschip", "slagschip", "slagschip", "onderzeeer", "onderzeeer", "onderzeeer",
            "torpedobootjager", "torpedobootjager", "torpedobootjager", "patrouilleschip", "patrouilleschip", "patrouilleschip", "patrouilleschip"));
	private int schepenOpBoard = 0;
	
	
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

	public void setKleur(int nr, Color kleur){
		this.getVierkanten().get(nr).setKleur(kleur);
	}
	
	public int getNummer(Position positie) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 int nr = 0;
		 for (int i = 0; i < vierkanten.size(); i++) {
			 if (this.getVierkanten().get(i).isAangeklikt(positie.getX(), positie.getY())) {
				nr = i;
			 }
		 } 
		 return nr;
	 }
	
	public void setBezet(int nr) {
		this.getVierkanten().get(nr).setBezet();
	}
	
	 public boolean isAvailable(SchipType schip) {
		 if (schepen.contains(schip.toString())) {
			 makeUnavailable(schip);
			 return true;
		 }
		 return false;
	 }
	 
	 public void makeUnavailable(SchipType schip) {
		for (int i = 0; i < schepen.size(); i++) {
			if (schepen.get(i).equals(schip.toString())) {
			schepen.remove(i);
			break;
			}
		}
	 }
	 public void makeAvailable(SchipType schip) {
		 schepen.add(schip.toString());
	 }
	 
	 public boolean fitsBoardVertical(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (richting.equals(Richting.VERTICAAL)) {
			 if ((nr+1 % 10) == 0) {
				 return false;
			 }
			 
			 for (int j = 1; j < schip.getSize(); j++) {
				 nr++;
				 if ((nr % 10) == 0) {
					 return false;
				 }
			 }
		 }
		 
		 return true;
	 }
	 
	 public boolean fitsBoardHorizontal(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (richting.equals(Richting.HORIZONTAAL)) {
			 for (int j = 0; j < schip.getSize(); j++) {
				 if (nr >= 100) {
					 return false;
				 }
				 nr += 10;
			 }
		 }
		
		 return true;
	 }
	 
	 public boolean overlapsShip(Richting richting, SchipType schip, Position positie) {
		List<Vierkant> vierkanten = this.getVierkanten();
		int nr = getNummer(positie);
		if (richting.equals(Richting.HORIZONTAAL)) {
			 for (int j = 0; j < schip.getSize(); j++) {
				 if (vierkanten.get(nr).getBezet()) {
					 return true;
				 }
				 nr += 10;
			 }
		} else if (richting.equals(Richting.VERTICAAL)) {
			 for (int j = 0; j< schip.getSize(); j++) {
				 if (vierkanten.get(nr).getBezet()) {
					 return true;
				 }
				 nr++;
			 }
		}
			
		return false;
	 }
	 
	 public void setOmliggendeBezet(int nr) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 vierkanten.get(nr).setBezet();
	 	 try {
		 vierkanten.get(nr-10).setBezet();
	 	 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr+10).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr-1).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr+1).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr-9).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr+9).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr-11).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
		 try {
		 vierkanten.get(nr+11).setBezet();
		 } catch (IndexOutOfBoundsException e) {}
	 }
	 
	 // Einde controle functies
	 
	 public void plaatsSchip(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (schepenOpBoard < 5) {
			 if (fitsBoardVertical(richting, schip, positie) && fitsBoardHorizontal(richting, schip, positie)) {
				 if (!overlapsShip(richting, schip, positie)) {
					 if (isAvailable(schip)) {	
						 if (richting.equals(Richting.HORIZONTAAL)) {
							 for (int j = 0; j < schip.getSize(); j++) {
								 this.setKleur(nr, Color.WHITE);
								 setOmliggendeBezet(nr);
								 nr += 10;
							 }
						 }
						 else if (richting.equals(Richting.VERTICAAL)) {
							 for (int j = 0; j< schip.getSize(); j++) {
								 this.setKleur(nr, Color.WHITE);
								 setOmliggendeBezet(nr);
								 nr++;
							 }
						 }
						 schepenOpBoard++;
					 } else { JOptionPane.showMessageDialog(null, "Dit schip is niet meer beschikbaar."); }
				 } else { JOptionPane.showMessageDialog(null, "Je schepen overlappen!"); }
			 } else { JOptionPane.showMessageDialog(null, "Dit pas niet op het bord!"); }
		 } else { JOptionPane.showMessageDialog(null, "Je mag maar 5 schepen plaatsen!"); } 
	 }
	 
	 public void attackSchip(Position position){
		 int nr = getNummer(position);
		 this.setKleur(nr, Color.RED);
		 
	 }
	 

	public int getSchepenOpBoard() {
		return schepenOpBoard;
	}



}
