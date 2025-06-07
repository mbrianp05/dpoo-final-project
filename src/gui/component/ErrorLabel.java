package gui.component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ErrorLabel extends JLabel {
	private static final long serialVersionUID = -708839185751921074L;

	public ErrorLabel() {
		setBackground(Color.WHITE);
		setForeground(new Color(255, 0, 51));
		setFont(new Font("Segoe UI", Font.PLAIN, 15));
	}
}
