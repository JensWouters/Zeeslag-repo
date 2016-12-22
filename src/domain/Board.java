package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import State.SpelState;

public class Board {
	
	private List<Vierkant> vierkanten = new ArrayList<Vierkant>();
	private List<String> schepen = new ArrayList<String>(Arrays.asList("vliegdekschip", "slagschip", "slagschip", "onderzeeer", "onderzeeer", "onderzeeer",
            "torpedobootjager", "torpedobootjager", "torpedobootjager", "patrouilleschip", "patrouilleschip", "patrouilleschip", "patrouilleschip"));
	private int schepenOpBoard = 0;
	private SpelState state;
	private boolean beurt;
	private int deadShips = 0;
	private int score = 19;
	
	private List<Integer> coordinatenVanSchepenOpponent = new ArrayList<Integer>();
	private List<Integer> sizeVanSchepenOpponent = new ArrayList<Integer>();
	private List<Integer> schip1Opponent;
	private List<Integer> schip2Opponent;
	private List<Integer> schip3Opponent;
	private List<Integer> schip4Opponent;
	private List<Integer> schip5Opponent;
	
	private List<Integer> coordinatenVanSchepen = new ArrayList<Integer>();
	private List<Integer> sizeVanSchepen = new ArrayList<Integer>();
	
	public Board(int zijde, int aantal) {
		int y = 0;
		int x = 0;
		
		for (int i = 0; i < aantal;i++){
			for (int j = 0; j < aantal; j++){
				vierkanten.add(new Vierkant(x+zijde*i,y+zijde*j,zijde,Color.LIGHT_GRAY));
			}	
		}
	}
	
	public List<Vierkant> getVierkanten() {
		return vierkanten;
	}
	

	
	public int getSchepenOpBoard() {
		return schepenOpBoard;
	}
	
	public List<Integer> getCoordinatenVanSchepenOpponent() {
		return this.coordinatenVanSchepenOpponent;
	}
	
	public List<Integer> getSizeVanSchepenOpponent() {
		return this.sizeVanSchepenOpponent;
	}
	
	public List<Integer> getCoordinatenVanSchepen() {
		return this.coordinatenVanSchepen;
	}
	
	public List<Integer> getSizeVanSchepen() {
		return this.sizeVanSchepen;
	}
	
	public boolean getBeurt(){
		return beurt;
	}
	
	public void setBeurt(boolean beurt){
		this.beurt = beurt;
	}

	public void setKleur(int nr, Color kleur){
		this.getVierkanten().get(nr).setKleur(kleur);
	}
	
	public int getNummer(Position positie) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 int nr = 0;
		 for (int i = 0; i < vierkanten.size(); i++) {
			 if (this.getVierkanten().get(i).isAangeklikt(positie.getX(), positie.getY())) {
				nr = i;
			 }
		 } 
		 return nr;
	 }
	
	public SpelState getState(){
		return state;
	}
	
	public void setState(SpelState state){
		this.state = state;
	}
	
	public int getScore(){
		return score;
	}
	
	public void lowerScore() {
		score--;
	}
	
	public void shipDied() {
		deadShips++;
	}
	
	public void setBezet(int nr) {
		this.getVierkanten().get(nr).setBezet();
	}
	public boolean getBezet(int nr){
		 return this.getVierkanten().get(nr).getBezet();
	}
	
	public int getDeadShips() {
		return deadShips;
	}
	
	 public boolean isAvailable(SchipType schip) {
		 if (schepen.contains(schip.toString())) {
			 makeUnavailable(schip);
			 return true;
		 }
		 return false;
	 }
	 
	 public void makeUnavailable(SchipType schip) {
		for (int i = 0; i < schepen.size(); i++) {
			if (schepen.get(i).equals(schip.toString())) {
			schepen.remove(i);
			break;
			}
		}
	 }
	 public void makeAvailable(SchipType schip) {
		 schepen.add(schip.toString());
	 }
	 
	 public boolean fitsBoardVertical(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (richting.equals(Richting.VERTICAAL)) {
			 if ((nr+1 % 10) == 0) {
				 return false;
			 }
			 for (int j = 1; j < schip.getSize(); j++) {
				 nr++;
				 if ((nr % 10) == 0) {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 public boolean fitsBoardHorizontal(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (richting.equals(Richting.HORIZONTAAL)) {
			 for (int j = 0; j < schip.getSize(); j++) {
				 if (nr >= 100) {
					 return false;
				 }
				 nr += 10;
			 }
		 }
		 return true;
	 }
	 
	 public boolean overlapsShip(Richting richting, SchipType schip, Position positie) {
		List<Vierkant> vierkanten = this.getVierkanten();
		int nr = getNummer(positie);
		if (richting.equals(Richting.HORIZONTAAL)) {
			 for (int j = 0; j < schip.getSize(); j++) {
				 if (vierkanten.get(nr).getBezet()) {
					 return true;
				 }
				 nr += 10;
			 }
		} else if (richting.equals(Richting.VERTICAAL)) {
			 for (int j = 0; j< schip.getSize(); j++) {
				 if (vierkanten.get(nr).getBezet()) {
					 return true;
				 }
				 nr++;
			 }
		}
			
		return false;
	 }
	 
	 public void setOmliggendeBezet(int nr) {
		 List<Vierkant> vierkanten = this.getVierkanten();
		 if (nr % 10 == 0) {
			 vierkanten.get(nr+1).setBezet();
			 vierkanten.get(nr-10).setBezet();
			 vierkanten.get(nr-9).setBezet();
			 vierkanten.get(nr+10).setBezet();
			 vierkanten.get(nr+11).setBezet();
		 } else if (nr % 10 == 9) {
			 vierkanten.get(nr-10).setBezet();
			 vierkanten.get(nr+10).setBezet();
			 vierkanten.get(nr-1).setBezet();
			 vierkanten.get(nr-9).setBezet();
			 vierkanten.get(nr+9).setBezet();
		 } else {
		 	 try {
			 vierkanten.get(nr-10).setBezet();
		 	 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr+10).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr-1).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr+1).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr-9).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr+9).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr-11).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
			 try {
			 vierkanten.get(nr+11).setBezet();
			 } catch (IndexOutOfBoundsException e) {}
		 }
	 }
	 
	 // Einde controle functies
	 
	 public void plaatsSchip(Richting richting, SchipType schip, Position positie) {
		 int nr = getNummer(positie);
		 if (schepenOpBoard < 5) {
			 if (fitsBoardVertical(richting, schip, positie) && fitsBoardHorizontal(richting, schip, positie)) {
				 if (!overlapsShip(richting, schip, positie)) {
					 if (isAvailable(schip)) {	
							 getSizeVanSchepen().add(schip.getSize());
						 if (richting.equals(Richting.HORIZONTAAL)) {
							 for (int j = 0; j < schip.getSize(); j++) {
								 this.setKleur(nr, Color.WHITE);
								 setOmliggendeBezet(nr);
								 this.getVierkanten().get(nr).setBezetSchip();
								 vierkanten.get(nr).setBezetSchip();
								 getCoordinatenVanSchepen().add(nr);
								 nr += 10;
							 }
						 }
						 else if (richting.equals(Richting.VERTICAAL)) {
							 for (int j = 0; j< schip.getSize(); j++) {
								 this.setKleur(nr, Color.WHITE);
								 setOmliggendeBezet(nr);
								 this.getVierkanten().get(nr).setBezetSchip();
								 vierkanten.get(nr).setBezetSchip();
								 getCoordinatenVanSchepen().add(nr);
								 nr++;
							 }
						 }
						 schepenOpBoard++;
					 } else { JOptionPane.showMessageDialog(null, "Dit schip is niet meer beschikbaar."); }
				 } else { JOptionPane.showMessageDialog(null, "Je schepen overlappen!"); }
			 } else { JOptionPane.showMessageDialog(null, "Dit pas niet op het bord!"); }
		 } else { JOptionPane.showMessageDialog(null, "Je mag maar 5 schepen plaatsen!"); } 
	 }
	 
	 public void attackSchip(Position position, Board board){
		 int nr = getNummer(position);
		 Vierkant vierkant = this.getVierkanten().get(nr);
		 if(vierkant.getKleur() == Color.LIGHT_GRAY || vierkant.getKleur() == Color.WHITE ){
			 if(this.getVierkanten().get(nr).getBezetSchip() == true){
				 this.setKleur(nr, Color.GREEN);
				 List<Integer> coordinaten = getAangevallenSchipOpponent(nr);
				 vierkanten.get(nr).setHit();
				 if (isKilled(coordinaten)) {
					 killSchip(coordinaten);
					 deadShips++;
				 }
				 this.setBeurt(true);
				 board.lowerScore();
			 }else{
				 this.setKleur(nr, Color.BLUE);
				 this.setBeurt(true);
			 }
		  		}	else if(vierkant.getKleur() == Color.GREEN || vierkant.getKleur() == Color.BLUE ||
		  				vierkant.getKleur() == Color.RED){
			 this.setBeurt(false);
	 }
	 }
	 
	 
	 public void killSchip(List<Integer> coordinaten) {
		 for (Integer i : coordinaten) {
			 this.setKleur(i, Color.RED);
		 }
		 
	 }

	public boolean isKilled(List<Integer> coordinaten) {
		for (Integer i : coordinaten) {
			if (!vierkanten.get(i).getHit()) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> getAangevallenSchipOpponent(int nr) {
		coordinatenPerSchipOpponent(coordinatenVanSchepenOpponent);
		if (schip1Opponent.contains(nr)) {
			return schip1Opponent;
		} else if (schip2Opponent.contains(nr)) {
			return schip2Opponent;
		} else if (schip3Opponent.contains(nr)) {
			return schip3Opponent;
		} else if (schip4Opponent.contains(nr)) {
			return schip4Opponent;
		} else if (schip5Opponent.contains(nr)) {
			return schip5Opponent;
		}
		return null;
	}
	
	public void coordinatenPerSchipOpponent(List<Integer> coordinaten) {
		int sizeSchip1 = sizeVanSchepenOpponent.get(0);
		int sizeSchip2 = sizeVanSchepenOpponent.get(1);
		int sizeSchip3 = sizeVanSchepenOpponent.get(2);
		int sizeSchip4 = sizeVanSchepenOpponent.get(3);
		
		schip1Opponent = coordinaten.subList(0, sizeSchip1);
		schip2Opponent = coordinaten.subList(sizeSchip1, sizeSchip1+sizeSchip2);
		schip3Opponent = coordinaten.subList(sizeSchip1+sizeSchip2, sizeSchip1+sizeSchip2+sizeSchip3);
		schip4Opponent = coordinaten.subList(sizeSchip1+sizeSchip2+sizeSchip3, sizeSchip1+sizeSchip2+sizeSchip3+sizeSchip4);
		schip5Opponent = coordinaten.subList(sizeSchip1+sizeSchip2+sizeSchip3+sizeSchip4, coordinatenVanSchepenOpponent.size());
	}
	

	
	//einde attack functies
}
