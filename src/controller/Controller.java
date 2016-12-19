package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domain.Position;
import domain.Service;
import domain.ServiceInterface;
import view.BoardPanel;
import view.ZeeslagFrame;

public class Controller {
private ZeeslagFrame view;
private BoardPanel boardPanelPlayer, boardPanelOpponant;
private ServiceInterface service = new Service();
	
	public Controller(){
		service.getBoardOpponant().plaatsSchipOpponent();
		boardPanelPlayer = new BoardPanel(service.getBoard());
		boardPanelOpponant = new BoardPanel(service.getBoardOpponant());
		view = new ZeeslagFrame(boardPanelPlayer, boardPanelOpponant);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getBoardPlayer().addMouseClickListener(new PlaatsSchipHandler());
	}
	
	private class PlaatsSchipHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			Position positie = new Position(event.getX(), event.getY());
			service.plaatsSchip(view.getRichting(), view.getSchip(), positie);
			view.getBoardPlayer().repaint();
			view.getBoardOpponant().repaint();
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
