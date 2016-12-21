package domain;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class Vierkant {
	private int x,y,zijde;
	private Color kleur;
	private boolean bezet;
	private boolean bezetSchip;
	private boolean isHit;
	
	
	public Vierkant(int x, int y, int zijde, Color kleur) {
		super();
		this.x = x;
		this.y = y;
		this.zijde = zijde-1;
		this.kleur = kleur;
		bezet = false;
	}
	public Color getKleur() {
		return kleur;
	}
	public void setKleur(Color kleur) {
		this.kleur = kleur;
	}
	
	public boolean getBezetSchip(){
		return bezetSchip;
	}
	public boolean getBezet(){
		return bezet;
	}
	
	public void paint(Graphics g) {
		g.setColor( kleur );
		g.fillRect( x, y, zijde, zijde );
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
	    g.setColor(Color.BLACK);
	    g.drawRect( x, y, zijde, zijde );
	}
	
	public boolean isAangeklikt(int x,int y){
		boolean aangeklikt = this.x <= x && this.x+zijde >= x &&
			    this.y <= y && this.y+ zijde >= y;	
		if (aangeklikt){
			bezet = !bezet;
		}	   
		return aangeklikt;		
	}
	
	public void setBezetSchip(){
		this.bezetSchip = true;
	}
	
	public void setBezet() {
		this.bezet = true;
	}
	
	public void setVrij(){
		this.bezet = false;
	}
	
	public Position getPositie() {
		return new Position(x, y);
	}
	
	public int getX() { 
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getHit() {
		return this.isHit;
	}
	
	public void setHit() {
		this.isHit = true;
	}
}
