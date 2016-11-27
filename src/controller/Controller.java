package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.ZeeslagFrame;

public class Controller {
private ZeeslagFrame view;
private String anders;
	
	public Controller(ZeeslagFrame view){
		this.view = view;
		view.getBoard1().addMouseClickListener(new MouseClickHandler());
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
