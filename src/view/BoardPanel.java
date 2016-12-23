package view;
/*
 * @Author Gezamenlijk gemaakt
 */
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;

import domain.Board;
import domain.Vierkant;

public class BoardPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Board board;
	
	public BoardPanel(Board board) {//, KnopController controller){
		this.board = board;
	}
	
	
	public Board getBoard() {
		return this.board;
	}
	
	public int getSchepenOpBoard() {
		return board.getSchepenOpBoard();
	}
	
	public List<Vierkant> getVierkanten(){
		return board.getVierkanten();
	}
	
	 public void paintComponent( Graphics g ){
	      super.paintComponent( g ); // call superclass's paintComponent
	      this.setBackground(UIManager.getColor ( "Panel.background" ));
	      for (Vierkant vierkant: board.getVierkanten()){
	    	  vierkant.paint(g);
	      }
	 }
	
}
