package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BordPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Board bord;
	private int schepenOpBord = 0;
	private List<String> schepen = new ArrayList<String>(Arrays.asList("vliegdekschip", "slagschip", "slagschip", "onderzeeer", "onderzeeer", "onderzeeer",
            "torpedobootjager", "torpedobootjager", "torpedobootjager", "patrouilleschip", "patrouilleschip", "patrouilleschip", "patrouilleschip"));
	
	public BordPanel(int zijde, int aantal) {//, KnopController controller){
		bord = new Board(zijde, aantal);
	}
	
	public void addMouseClickListener(MouseListener listener){
		this.addMouseListener(listener);
	}
	
	public Board getBoard() {
		return this.bord;
	}
	
	public List<Vierkant> getVierkanten(){
		return bord.getVierkanten();
	}
	
	public void setKleur(int nr, Color kleur){
		bord.getVierkanten().get(nr).setKleur(kleur);
		this.repaint();
	}
	
	public void setBezet(int nr) {
		bord.getVierkanten().get(nr).setBezet();
	}
	
	 public void paintComponent( Graphics g ){
	      super.paintComponent( g ); // call superclass's paintComponent
	      this.setBackground( Color.WHITE );
	      for (Vierkant vierkant: bord.getVierkanten()){
	    	  vierkant.paint(g);
	      }
	  }
	 
	 public int getNummer(Positie positie) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 int nr = 0;
		 for (int i = 0; i < vierkanten.size(); i++) {
			 if (vierkanten.get(i).isAangeklikt(positie.getX(), positie.getY())) {
				nr = i;
			 }
		 } 
		 return nr;
	 }
	 
	 //Extra Controle Functies
	 
	 public boolean isAvailable(SchipType schip) {
		 /*System.out.println("newline");
		 for (String s : schepen) {
			 System.out.println(s);
		 }*/
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
	 
	 public boolean fitsBoardVertical(Richting richting, SchipType schip, Positie positie) {
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
	 
	 public boolean fitsBoardHorizontal(Richting richting, SchipType schip, Positie positie) {
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
	 
	 public boolean overlapsShip(Richting richting, SchipType schip, Positie positie) {
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
	 
	 public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		 int nr = getNummer(positie);
		 if (schepenOpBord < 5) {
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
						 schepenOpBord++;
					 } else { JOptionPane.showMessageDialog(null, "Dit schip is niet meer beschikbaar."); }
				 } else { JOptionPane.showMessageDialog(null, "Je schepen overlappen!"); }
			 } else { JOptionPane.showMessageDialog(null, "Dit pas niet op het bord!"); }
		 } else { JOptionPane.showMessageDialog(null, "Je mag maar 5 schepen plaatsen!"); } 
	 }
	 

	 public void plaatsSchipOpponent() {
		while(schepenOpBord < 5) {
			 	int x = (int)(Math.random() *100);
			 	Vierkant vierkant = bord.getVierkanten().get(x);
			 	Positie positie = vierkant.getPositie();
				Richting richting = Richting.getRandomRichting();
				SchipType schip = SchipType.getRandomSchip();
				int nr = getNummer(positie);
				System.out.println(richting.toString());
				System.out.println(positie.toString());
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
						 schepenOpBord++;
						 
					 } 
				 } 
			 } 
		
	 }

	 }
}
