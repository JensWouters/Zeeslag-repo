package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import domain.Board;
import domain.Positie;
import domain.Richting;
import domain.SchipType;
import domain.Vierkant;

public class BordPanel extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Board bord;
	
	public BordPanel(int zijde, int aantal) {//, KnopController controller){
		bord = new Board(zijde, aantal);
	}
	
	public void addMouseClickListener(MouseListener listener){
		this.addMouseListener(listener);
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
	 
	 
}
