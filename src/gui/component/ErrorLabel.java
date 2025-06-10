package gui.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import utils.Icons;

public class ErrorLabel extends JLabel {
	private static final long serialVersionUID = -708839185751921074L;

	public ErrorLabel() {
		setIcon(Icons.getErrorIcon());
		setForeground(new Color(255, 0, 51));
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
}
