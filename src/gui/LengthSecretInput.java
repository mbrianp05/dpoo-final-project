package gui;

import javax.swing.JPasswordField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LengthSecretInput extends JPasswordField {
	private int maxLength = -1;

	public LengthSecretInput() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				if (getText().length() == maxLength) {
					event.consume();
				}
			}
		});
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		if (maxLength >= -1)
			this.maxLength = maxLength;
	}
}
