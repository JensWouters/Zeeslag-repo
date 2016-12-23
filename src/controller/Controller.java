package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import State.GestartState;
import State.NieuwState;
import State.SpelState;
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
private SpelState NieuwState = new NieuwState();
private SpelState GestartState = new GestartState();

	public Controller(){
		boardPanelPlayer = new BoardPanel(service.getBoard());
		boardPanelOpponant = new BoardPanel(service.getBoardOpponent());
		view = new ZeeslagFrame(boardPanelPlayer, boardPanelOpponant);
		service.getSpel().registerObserver(view);
		service.getSpel().setState(NieuwState);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getBoardPlayer().addMouseListener(new PlaatsSchipHandler());
		view.getStartKnop().addMouseListener(new PlaatsSchipOpponentHandler());
		view.getBoardOpponent().addMouseListener(new AttackSchepenHandler());
		view.getBoardOpponent().addMouseListener(new AttackSchepenRandomComputerHandler());
		view.getBoardOpponent().addMouseListener(new ScoreHandler());
		view.getBoardPlayer().addMouseListener(new ScoreHandler());
	}
	
	public String getEndText() {
		String winnaar;
		if (service.getBoard().getScore() > service.getBoardOpponent().getScore()) {
			winnaar = view.getNamePlayer() + " heeft het spel gewonnen met een score van: " + service.getBoard().getScore(); 
		} else {
			winnaar = view.getNameOpponent() + " heeft het spel gewonnen met een score van: " + service.getBoardOpponent().getScore(); 
		}
		return "Game Over! Alle schepen zijn gezonken! \n" + winnaar;
	}
	
	public void endGame() {
		int rematch = JOptionPane.showOptionDialog(null, getEndText(), "GAME OVER", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Restart", "Leave"}, null);
		if (rematch == JOptionPane.OK_OPTION) {
			view.dispose();
			service.getSpel().setState(NieuwState);
			new Controller();
		} else {
			System.exit(0);
		}
	}
	
	private class ScoreHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			service.getSpel().notifyObservers();
			view.repaint();
		}
	}

	private class PlaatsSchipHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			if (service.getSpel().getState() == NieuwState ) {
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
			if (service.getSpel().getState() == NieuwState) {
			SpelStrategy strategy = new RandomStrategy();
			Board board = service.getBoardOpponent();
			strategy.plaatsSchipOpponent(board);
			view.getBoardOpponent().repaint();
			view.getStartKnop().setEnabled(false);
			service.getSpel().setState(GestartState);
			}
		}
	}
	
	private class AttackSchepenHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
				if(service.getSpel().getState() == GestartState){
				int x = event.getX();
				int y = event.getY();
				Position position = new Position(x,y);
				service.getBoardOpponent().attackSchip(position, service.getBoardOpponent());
				view.getBoardOpponent().repaint();
				}
				if (service.getBoardOpponent().getDeadShips() == 5) {
					endGame();
				} 
				
		}
	}
	
	private class AttackSchepenRandomComputerHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			
				if(service.getSpel().getState() == GestartState){
					if(service.getBoardOpponent().getBeurt()){
						AanvalStrategy strategy = new RandomAanvalStrategy(service.getBoard());
						strategy.attackSchipComputer(service.getBoard());
						view.getBoardPlayer().repaint();
				}
					
			}
				if (service.getBoard().getDeadShips() == 5) {
					endGame();
				} 
				
		}
	}
}

