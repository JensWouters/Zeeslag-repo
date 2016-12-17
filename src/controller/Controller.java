package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import domain.Positie;
import domain.Service;
import domain.ServiceInterface;
import view.ZeeslagFrame;

public class Controller {
private ZeeslagFrame view;
private ServiceInterface service = new Service();
	
	public Controller(ZeeslagFrame view){
		this.view = view;
		view.getBoard1().addMouseClickListener(new PlaatsSchipHandler());
		view.getBoard1().addMouseClickListener(new MouseClickHandler());
	}
	
	private class PlaatsSchipHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent event) {
			int x = event.getX();
			int y = event.getY();
			
			Positie positie = new Positie(x, y);
			
			service.plaatsSchip(view.getRichting(), view.getSchip(), positie);
		}
	}
	
	private class MouseClickHandler extends MouseAdapter{
		 public void mouseClicked(MouseEvent event){
			 int x = event.getX();
			 int y = event.getY();
			 int nr = -1;
			 for (int i = 0; i < view.getBoard1().getVierkanten().size(); i++){
					if (view.getBoard1().getVierkanten().get(i).isAangeklikt(x, y)){
						nr = i;
						if (!view.getBoard1().getVierkanten().get(i).getBezet()){
							view.getBoard1().setKleur(nr, Color.LIGHT_GRAY);
						}
						else{
							view.getBoard1().setKleur(nr, Color.YELLOW);
						}
						view.getBoard2().setKleur(nr, Color.RED);
						break;						
					}	
			 }
		 }
	 }
}
