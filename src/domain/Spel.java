package domain;

import java.util.List;

import Observer.Observer;
import Observer.Subject;
import State.SpelState;

public class Spel implements Subject {
	private Board board;
	private Board boardOpponent;
	private SpelState state;
	
	public Spel() {
		this.board = new Board(25,10);
		this.boardOpponent = new Board(25,10);
	}

	public void plaatsSchip(Richting richting, SchipType schip, Position positie) {
		board.plaatsSchip(richting, schip, positie);
	}
	
	public SpelState getState(){
		return state;
	}
	
	public void setState(SpelState state){
		this.state = state;
	}

	public Board getBoard() {
		return board;
	}
	
	public Board getBoardOpponent() {
		return this.boardOpponent;
	}
	
	public void attackSchip(Position position){
		boardOpponent.attackSchip(position);
	}

	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObserver(List<Observer> observers) {
		// TODO Auto-generated method stub
		
	}
}