package gui;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class LengthTextField extends JTextField {
	private int maxLength = -1;

	public LengthTextField() {
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
