package domain;

import java.awt.Color;

public class Service implements ServiceInterface {
	
	private BordPanel bord;
	private BordPanel bordOpponent;
	
	public Service() {
		this.bord = new BordPanel(25,10);
		this.bordOpponent = new BordPanel(25,10);
	}

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		bord.plaatsSchip(richting, schip, positie);
	}
	
	public void plaatsSchipOpponent(){
		bordOpponent.plaatsSchipOpponent();
	}

	public BordPanel getBord() {
		return bord;
	}
	
	public BordPanel getBordOpponant() {
		return this.bordOpponent;
	}
	
}
