package gui.component;

import gui.report.views.BestResearchersJDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ErrorLabel extends JLabel {
	private static final long serialVersionUID = -708839185751921074L;

	public ErrorLabel() {
		ImageIcon icon = new ImageIcon(BestResearchersJDialog.class.getResource("/resources/images/error.png"));
		icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		
		setIcon(icon);
		setForeground(new Color(255, 0, 51));
		setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
}
