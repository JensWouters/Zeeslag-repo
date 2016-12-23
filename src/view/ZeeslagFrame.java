package view;
/*
 * @Author Gezamenlijk gemaakt
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Observer.Observer;
import domain.Richting;
import domain.SchipType;

public class ZeeslagFrame extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	private BoardPanel boardPlayer, boardOpponent;
	private JPanel controlPanel;
	private JLabel player1, player2;
	private String namePlayer = (String) JOptionPane.showInputDialog(null, "Please enter username", "Please enter username", JOptionPane.QUESTION_MESSAGE,null,null,"player1");
	private String nameOpponent = (String) JOptionPane.showInputDialog(null, "Please enter username", "Please enter username", JOptionPane.QUESTION_MESSAGE,null,null,"player2");
	private JPanel mainPanel = new JPanel();
	private JComboBox<SchipType> schepen = new JComboBox<SchipType>(SchipType.values());
	private JRadioButton horizontaal = new JRadioButton("Horizontaal");
	private JRadioButton verticaal = new JRadioButton("Verticaal");
	private JButton start = new JButton("Start spel");
	
	public ZeeslagFrame(BoardPanel board, BoardPanel boardOpponant){
		super();
		this.setSize( 800, 300 );
		this.setResizable(false);
		this.setContentPane(mainPanel);
		mainPanel.setLayout(new GridLayout(1,3));
		addControlPanel();
		addPlayerBoards(board, boardOpponant);
	}
	
	public void addControlPanel() {
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(8,1));
		
		JLabel beschikbaar = new JLabel("Beschikbare schepen");
		beschikbaar.setLocation(10, 10);
		controlPanel.add(beschikbaar);

		schepen.setSelectedIndex(0);
		controlPanel.add(schepen);
		
		JLabel richting = new JLabel("Richting");
		controlPanel.add(richting);
		controlPanel.add(horizontaal);
		controlPanel.add(verticaal);
		verticaal.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(horizontaal);
		group.add(verticaal);
		
		start.setEnabled(false);
		controlPanel.add(start);

		player1 = new JLabel(namePlayer);
		player2 = new JLabel(nameOpponent);
		controlPanel.add(player1);
		controlPanel.add(player2);
		
		mainPanel.add(controlPanel);
	}
	
	public void addPlayerBoards(BoardPanel bord, BoardPanel bordOpponent) {
		 
		boardPlayer = bord;
		boardPlayer.setBackground(Color.GRAY);
		boardPlayer.setSize(new Dimension(400,400));
		boardPlayer.setLocation(25,50);
		boardPlayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(boardPlayer);
		
		boardOpponent = bordOpponent;
		boardOpponent.setBackground(Color.GRAY);
		boardOpponent.setSize(new Dimension(400,400));
		boardOpponent.setLocation(475,50);
		boardOpponent.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.add(boardOpponent);
	}
	 public BoardPanel getBoardPlayer(){
		 return boardPlayer;
	 }
	 
	 public void repaintControlPanel() {
		 controlPanel.repaint();
	 }
	 
	 public BoardPanel getBoardOpponent(){
		 return boardOpponent;
	 }
	 
	 public JButton getStartKnop(){
		 return start;
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
	 
	 public String getPlayer1() {
		 return player1.getText();
	 }
	 
	 public String getPlayer2() {
		 return player2.getText();
	 }
	 
	 public String getNamePlayer() {
		 return namePlayer;
	 }
	 
	 public String getNameOpponent() {
		 return nameOpponent;
	 }

	public void update(int scorePlayer, int scoreOpponent) {
		player1.setText(namePlayer + ": Score: " + scorePlayer);
		player2.setText(nameOpponent + ": Score: " + scoreOpponent);
	}

}
