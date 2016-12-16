package domain;

import view.BordPanel;

public interface ServiceInterface {

	public void plaatsSchip(Richting richting, Schip schip, Positie positie);
	
	public BordPanel getBord();
}
