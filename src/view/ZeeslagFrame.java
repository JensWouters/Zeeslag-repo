package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class ZeeslagFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControlPanel boardPanel = new ControlPanel();
	
	public ZeeslagFrame() {
		super("Zeeslag");
		this.setSize(new Dimension(600,300));
		this.setLayout(new GridLayout(2,2));
		this.add(boardPanel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
