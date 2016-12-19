package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import strategy.RandomStrategy;
import strategy.SpelStrategy;
import view.BoardPanel;
import view.ZeeslagFrame;
import domain.Board;
import domain.Position;
import domain.Service;
import domain.ServiceInterface;

public class Controller {
private ZeeslagFrame view;
private BoardPanel boardPanelPlayer, boardPanelOpponant;
private ServiceInterface service = new Service();

private final static int NEW_GAME = 0;
private final static int START_GAME = 1; 
private int state = NEW_GAME;

	public Controller(){
		boardPanelPlayer = new BoardPanel(service.getBoard());
		boardPanelOpponant = new BoardPanel(service.getBoardOpponant());
		view = new ZeeslagFrame(boardPanelPlayer, boardPanelOpponant);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		view.getBoardPlayer().addMouseClickListener(new PlaatsSchipHandler());
		view.getStartKnop().addMouseListener(new PlaatsSchipOpponentHandler());
		
		
	}
	
	private class PlaatsSchipHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			if (state == 0) {
			Position positie = new Position(event.getX(), event.getY());
			service.plaatsSchip(view.getRichting(), view.getSchip(), positie);
			view.getBoardPlayer().repaint();
			System.out.println(boardPanelPlayer.getSchepenOpBoard());
			if (boardPanelPlayer.getSchepenOpBoard() == 5){
				view.getStartKnop().setEnabled(true);
			}
			}
			
		}
	}
	
	private class PlaatsSchipOpponentHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			if (state == 0) {
			SpelStrategy strategy = new RandomStrategy();
			Board board = service.getBoardOpponant();
			strategy.plaatsSchipOpponent(board);
			view.getBoardOpponant().repaint();
			view.getStartKnop().setEnabled(false);
			state = START_GAME;
			}
		}
	}
	
	
	
//	private class MouseClickHandler extends MouseAdapter{
//		 public void mouseClicked(MouseEvent event){
//			 int x = event.getX();
//			 int y = event.getY();
//			 int nr = -1;
//			 for (int i = 0; i < view.getBoardPlayer().getVierkanten().size(); i++){
//					if (view.getBoardPlayer().getVierkanten().get(i).isAangeklikt(x, y)){
//						nr = i;
//						if (!view.getBoardPlayer().getVierkanten().get(i).getBezet()){
//							view.getBoardPlayer().setKleur(nr, Color.LIGHT_GRAY);
//						}
//						else{
//							view.getBoardPlayer().setKleur(nr, Color.YELLOW);
//						}
//						view.getBoardOpponant().setKleur(nr, Color.RED);
//						break;						
//					}	
//			 }
//		 }
//	 }
}
