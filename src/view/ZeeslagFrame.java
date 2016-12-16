package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import domain.Richting;
import domain.SchipType;

public class ZeeslagFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private BordPanel board1, board2 = new BordPanel(40,10);
	private JLabel player1, player2;
	private JPanel mainPanel = new JPanel();
	private JComboBox schepen = new JComboBox(SchipType.values());
	private JRadioButton horizontaal = new JRadioButton("Horizontaal");
	private JRadioButton verticaal = new JRadioButton("Verticaal");

	public ZeeslagFrame(){
		super();
		this.setSize( 800, 300 );
		this.setResizable(false);
		this.setContentPane(mainPanel);
		
		mainPanel.setLayout(new GridLayout(1,3));
		addControlPanel();
		addPlayerBoards();
	}
	
	public void addControlPanel() {
		JPanel controlPanel = new JPanel();
		
		JLabel beschikbaar = new JLabel("Beschikbare schepen");
		beschikbaar.setLocation(10, 10);
		controlPanel.add(beschikbaar);

		schepen.setSelectedIndex(0);
		controlPanel.add(schepen);
		
		JLabel richting = new JLabel("Richting");
		controlPanel.add(richting);
		controlPanel.add(horizontaal);
		controlPanel.add(verticaal);
		mainPanel.add(controlPanel);
	}
	
	public void addPlayerBoards() {
		board1 = new BordPanel(25,10);
		board1.setBackground(Color.GRAY);
		board1.setSize(new Dimension(400,400));
		board1.setLocation(25,50);
		board1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(board1);
				
		board2 = new BordPanel(25,10);
		board2.setBackground(Color.GRAY);
		board2.setSize(new Dimension(400,400));
		board2.setLocation(475,50);
		board2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(board2);
	}
	 public BordPanel getBoard1(){
		 return board1;
	 }
	 
	 public BordPanel getBoard2(){
		 return board2;
	 }
	 
	 public SchipType getSchip() {
		 return (SchipType) schepen.getSelectedItem();
	 }
	 
	 public Richting getRichting() {
		 if (horizontaal.isSelected()) {
			 return Richting.HORIZONTAAL;
		 }
		 else return Richting.VERTICAAL;
	 }
}
