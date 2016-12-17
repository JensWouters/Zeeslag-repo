package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

public class BordPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Board bord;
	
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
	
	 public void paintComponent( Graphics g ){
	      super.paintComponent( g ); // call superclass's paintComponent
	      this.setBackground( Color.WHITE );
	      for (Vierkant vierkant: bord.getVierkanten()){
	    	  vierkant.paint(g);
	      }
	  }
	 
	 public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 int x = positie.getX();
		 int y = positie.getY();
		 int nr = -1;
		 for (int i = 0; i < vierkanten.size(); i++) {
			 if (vierkanten.get(i).isAangeklikt(x, y)) {
				 nr = i;
				 if (richting.equals(Richting.HORIZONTAAL)) {
					 for (int j = 0; j < schip.getSize(); j++) {
						 this.setKleur(nr, Color.WHITE);
						 nr += 10;
					 }
				 }
				 else if (richting.equals(Richting.VERTICAAL)) {
					 for (int j = 0; j< schip.getSize(); j++) {
						 this.setKleur(nr, Color.WHITE);
						 nr++;
					 }
				 }
			 }
		 }
	 }

}
