package strategy.aanvalstrategy;
/*
 * @Author Gezamenlijk gemaakt
 */
import java.awt.Color;
import java.util.List;

import domain.Board;
import domain.Vierkant;

public class RijAanvalStrategy implements AanvalStrategy{
	Board board;
	
	private List<Integer> schip1;
	private List<Integer> schip2;
	private List<Integer> schip3;
	private List<Integer> schip4;
	private List<Integer> schip5;
	
	private int nr = 0;
	
	public RijAanvalStrategy(Board board) {
		setBoard(board);
	}

	private void setBoard(Board board) {
		this.board = board;
	}
	public void attackSchipComputer(Board board) {
		Vierkant vierkant = board.getVierkanten().get(nr);
		 if(vierkant.getKleur().equals(Color.LIGHT_GRAY) || vierkant.getKleur().equals(Color.WHITE)){
		 	if(board.getVierkanten().get(nr).getBezetSchip() == true){
	 			board.setKleur(nr, Color.GREEN);
	 			List<Integer> coordinaten = getAangevallenSchip(nr);
				board.getVierkanten().get(nr).setHit();
				if (isKilled(coordinaten)) {
					killSchip(coordinaten);
					board.shipDied();
				}
		 			
 			}else {
 				board.setKleur(nr, Color.BLUE);
 			}
		 } else {
			 nr++;
			this.attackSchipComputer(board);
		 }
		 nr++;
	}
	
	 public void killSchip(List<Integer> coordinaten) {
		 for (Integer i : coordinaten) {
			 board.setKleur(i, Color.RED);
		 }
	 }

	public boolean isKilled(List<Integer> coordinaten) {
		for (Integer i : coordinaten) {
			if (!board.getVierkanten().get(i).getHit()) {
				return false;
			}
		}
		return true;
	}
	
	public List<Integer> getAangevallenSchip(int nr) {
		coordinatenPerSchip(board.getCoordinatenVanSchepen());
		if (schip1.contains(nr)) {
			return schip1;
		} else if (schip2.contains(nr)) {
			return schip2;
		} else if (schip3.contains(nr)) {
			return schip3;
		} else if (schip4.contains(nr)) {
			return schip4;
		} else if (schip5.contains(nr)) {
			return schip5;
		}
		return null;
	}
	
	public void coordinatenPerSchip(List<Integer> coordinaten) {
		List<Integer> sizeVanSchepen = board.getSizeVanSchepen();
		int sizeSchip1 = sizeVanSchepen.get(0);
		int sizeSchip2 = sizeVanSchepen.get(1);
		int sizeSchip3 = sizeVanSchepen.get(2);
		int sizeSchip4 = sizeVanSchepen.get(3);
		
		schip1 = coordinaten.subList(0, sizeSchip1);
		schip2 = coordinaten.subList(sizeSchip1, sizeSchip1+sizeSchip2);
		schip3 = coordinaten.subList(sizeSchip1+sizeSchip2, sizeSchip1+sizeSchip2+sizeSchip3);
		schip4 = coordinaten.subList(sizeSchip1+sizeSchip2+sizeSchip3, sizeSchip1+sizeSchip2+sizeSchip3+sizeSchip4);
		schip5 = coordinaten.subList(sizeSchip1+sizeSchip2+sizeSchip3+sizeSchip4, board.getCoordinatenVanSchepen().size());
	}
}
