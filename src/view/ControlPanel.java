package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints constraints = new GridBagConstraints();
	private JLabel name = new JLabel(JOptionPane.showInputDialog("Geef je username op."));
	private JLabel computer = new JLabel("Computer");
	
	public ControlPanel() {
		this.setLayout(new GridBagLayout());
		this.add(name);
		this.add(computer);
	}
	
}
