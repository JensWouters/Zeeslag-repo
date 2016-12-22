package domain;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;
import Observer.Subject;
import State.SpelState;

public class Spel implements Subject {
	private Board board;
	private Board boardOpponent;
	private SpelState state;
	private List<Observer> observers = new ArrayList<Observer>();
	
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
		boardOpponent.attackSchip(position, boardOpponent);
	}
	
	public int getScorePlayer() {
		return this.board.getScore();
	}
	
	public int getScoreOpponent() {
		return this.boardOpponent.getScore();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void notifyObservers() {
		int scorePlayer = this.getScorePlayer();
		int scoreOpponent = this.getScoreOpponent();
		for (Observer o : observers) {
			o.update(scorePlayer, scoreOpponent);
		}
	}
}