package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

import domain.Board;
import domain.Vierkant;

public class BoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Board board;
	
	public BoardPanel(Board board) {//, KnopController controller){
		this.board = board;
	}
	
	public void addMouseClickListener(MouseListener listener){
		this.addMouseListener(listener);
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public List<Vierkant> getVierkanten(){
		return board.getVierkanten();
	}
	
	 public void paintComponent( Graphics g ){
	      super.paintComponent( g ); // call superclass's paintComponent
	      this.setBackground( Color.WHITE );
	      for (Vierkant vierkant: board.getVierkanten()){
	    	  vierkant.paint(g);
	      }
	 }
	
}
