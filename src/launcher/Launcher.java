package launcher;

import javax.swing.JFrame;

import controller.Controller;
import view.ZeeslagFrame;

public class Launcher {
	private String anders;

	public static void main(String[] args) {
		ZeeslagFrame bord = new ZeeslagFrame();
		bord.setVisible(true);
		bord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Controller controller = new Controller(bord);
	}

}
