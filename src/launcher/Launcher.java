package launcher;

import javax.swing.JFrame;

import controller.Controller;
import view.ZeeslagFrame;

public class Launcher {


	public static void main(String[] args) {
		ZeeslagFrame bord = new ZeeslagFrame();
		bord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Controller controller = new Controller(bord);
	}

}
