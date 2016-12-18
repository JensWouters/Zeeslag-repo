package domain;

import java.awt.Color;

public class Service implements ServiceInterface {
	
	private BordPanel bord;
	private BordPanel bordOpponant;
	
	public Service() {
		this.bord = new BordPanel(25,10);
		this.bordOpponant = new BordPanel(25,10);
	}

	public void plaatsSchip(Richting richting, SchipType schip, Positie positie) {
		bord.plaatsSchip(richting, schip, positie);
	}
	
	public void plaatsSchipOpponent(){
		bordOpponant.plaatsSchipOpponent();
	}

	public BordPanel getBord() {
		return bord;
	}
	
	public BordPanel getBordOpponant() {
		return this.bordOpponant;
	}
	
}
