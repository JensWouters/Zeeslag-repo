package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import domain.Schip;

public class ZeeslagFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ControlPanel board1, board2 = new ControlPanel(40,10);
	private JLabel player1, player2;

	public ZeeslagFrame(){
		super();
		this.setSize( 900, 500 );
		this.setResizable(false);
		this.setLayout(new GridLayout());
		player1 = new JLabel(JOptionPane.showInputDialog("Player1 geef je username op:"));
		this.add(player1);
		board1 = new ControlPanel(40,10);
		board1.setBackground(Color.GRAY);
		board1.setSize(getPreferredSize());
		board1.setLocation(25,50);
		board1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(board1);
				
		board2 = new ControlPanel(40,10);
		board2.setBackground(Color.GRAY);
		board2.setSize(getPreferredSize());
		board2.setLocation(475,50);
		board2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(board2);
		
		JComboBox schepen = new JComboBox(Schip.values());
		schepen.setSelectedIndex(0);
		this.add(schepen);
		
		this.setVisible(true);
	}
	
	 public ControlPanel getBoard1(){
		 return board1;
	 }
	 
	 public ControlPanel getBoard2(){
		 return board2;
	 }
}
