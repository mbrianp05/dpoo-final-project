package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

public class MenuPanel extends JPanel {
	private JButton btnNewButton;
	
	public MenuPanel() {
		setLayout(null);
		add(getBtnNewButton());
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(12, 13, 97, 25);
		}
		return btnNewButton;
	}
}
