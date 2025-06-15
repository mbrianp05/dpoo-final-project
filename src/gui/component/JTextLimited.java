package gui.component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextLimited extends JTextField{
	
	private static final long serialVersionUID = 1L;
	private int limite;
	
	public JTextLimited () {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				JTextField text = (JTextField) e.getSource();
				
				if (text.getText().length() == limite || !Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
	}

	public int getLimite() {
		return this.limite;
		}
	public void setLimite (int limite) {
		if (limite >= -1)
			this.limite = limite;
	}
}
