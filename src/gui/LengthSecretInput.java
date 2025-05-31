package gui;

import javax.swing.JPasswordField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LengthSecretInput extends JPasswordField {
	private static final long serialVersionUID = 7109352312097286818L;
	private int maxLength = -1;

	public LengthSecretInput() {
		addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
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
