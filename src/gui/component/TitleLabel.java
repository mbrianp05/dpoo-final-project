package gui.component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TitleLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public TitleLabel() {
		setBackground(Color.WHITE);
		setFont(new Font("Segoe UI", Font.PLAIN, 25));
	}
}
