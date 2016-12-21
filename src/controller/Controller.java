package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import domain.Board;
import domain.Position;
import domain.Service;
import domain.ServiceInterface;
import strategy.RandomStrategy;
import strategy.SpelStrategy;
import strategy.aanvalstrategy.AanvalStrategy;
import strategy.aanvalstrategy.RandomAanvalStrategy;
import strategy.aanvalstrategy.RijAanvalStrategy;
import view.BoardPanel;
import view.ZeeslagFrame;

public class Controller {
private ZeeslagFrame view;
private BoardPanel boardPanelPlayer, boardPanelOpponant;
private ServiceInterface service = new Service();
private final static int NEW_GAME = 0;
private final static int START_GAME = 1; 
private final static int PLAYING = 2;
private int state = NEW_GAME;

	public Controller(){
		boardPanelPlayer = new BoardPanel(service.getBoard());
		boardPanelOpponant = new BoardPanel(service.getBoardOpponent());
		view = new ZeeslagFrame(boardPanelPlayer, boardPanelOpponant);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getBoardPlayer().addMouseListener(new PlaatsSchipHandler());
		view.getStartKnop().addMouseListener(new PlaatsSchipOpponentHandler());
		view.getBoardOpponent().addMouseListener(new AttackSchepenHandler());
		view.getBoardOpponent().addMouseListener(new AttackSchepenRandomComputerHandler());
		view.getScoreKnop().addMouseListener(new ScoreHandler());
	}
	
	private class ScoreHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			int scorePlayer = service.getBoard().getScore();
			int scoreOpponant = service.getBoardOpponent().getScore();
			System.out.println("Player: " + scorePlayer + "\nOpponant: " + scoreOpponant);
		}
	}

	private class PlaatsSchipHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			if (state == 0) {
			Position positie = new Position(event.getX(), event.getY());
			service.plaatsSchip(view.getRichting(), view.getSchip(), positie);
			view.getBoardPlayer().repaint();
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
			Board board = service.getBoardOpponent();
			strategy.plaatsSchipOpponent(board);
			view.getBoardOpponent().repaint();
			view.getStartKnop().setEnabled(false);
			state = START_GAME;
			}
		}
	}
	
	private class AttackSchepenHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			if(state == 1 || state == 2){
			int x = event.getX();
			int y = event.getY();
			Position position = new Position(x,y);
			service.getBoardOpponent().attackSchip(position);
			view.getBoardOpponent().repaint();
			state = PLAYING;
			System.out.println(service.getBoard().getScore());
		}
	}
	}
	
	private class AttackSchepenRandomComputerHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			if(state == 1 || state == 2){
				view.getScoreKnop().setEnabled(true);
				if(service.getBoardOpponent().getBeurt()){
					AanvalStrategy strategy = new RandomAanvalStrategy(service.getBoard());
					strategy.attackSchipComputer(service.getBoard());
					view.getBoardPlayer().repaint();
					state = PLAYING;
					System.out.println(strategy.getScore());
				}
			
			}
		}
	}
	
	private class AttackSchepenRijComputerHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			if(state == 1 || state == 2){
				view.getScoreKnop().setEnabled(true);
				if(service.getBoardOpponent().getBeurt()){
					AanvalStrategy strategy = new RijAanvalStrategy(service.getBoard());
					strategy.attackSchipComputer(service.getBoard());
					view.getBoardPlayer().repaint();
					state = PLAYING;
				}
			
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

