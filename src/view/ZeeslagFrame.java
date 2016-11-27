package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ZeeslagFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControlPanel board1, board2 = new ControlPanel(40,10);
	private JLabel name, computer;

	public ZeeslagFrame(){
		super();
		this.setSize( 900, 500 );
		this.setResizable(false);
		this.setLayout(null);
		board1 = new ControlPanel(40,10);
		board1.setBackground(Color.GRAY);
		board1.setSize(new Dimension(400, 400));
		board1.setLocation(25,50);
		board1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(board1);
		name = new JLabel("Jens");
		name.setLocation(25, 10);
		this.add(name);
		
		
		board2 = new ControlPanel(40,10);
		board2.setBackground(Color.GRAY);
		board2.setSize(new Dimension(400, 400));
		board2.setLocation(475,50);
		board2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(board2);
		computer = new JLabel("Computer");
		computer.setLocation(475, 10);
		this.add(computer);
	}
	
	 public ControlPanel getBoard1(){
		 return board1;
	 }
	 
	 public ControlPanel getBoard2(){
		 return board2;
	 }
}
