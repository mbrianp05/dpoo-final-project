package gui.component;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemporaryMessage extends JPanel {
	private static final long serialVersionUID = -2195902792908911659L;
	private JLabel lblNewLabel;
	private Timer timer;
	private int cameoTime;
	private int count;
	
	public TemporaryMessage(int count) {
		setForeground(new Color(51, 102, 51));
		setFont(new Font("Segoe UI", Font.PLAIN, 15));
		setBackground(new Color(102, 204, 153));
		setLayout(new BorderLayout(0, 0));
		add(getLblNewLabel(), BorderLayout.CENTER);
		
		getTimer();
		
		setCounter(count);
		setVisible(false);
	}
	
	public TemporaryMessage() {
		this(3000);
	}

	public void appear() {
		setVisible(true);
		timer.start();
	}
	
	private void setCounter(int count) {
		if (count <= 0) throw new IllegalArgumentException("Seconds counter has to be over 0s");
		
		this.cameoTime = count;
		this.count = count;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("El investigador ha sido registrado correctamente");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(51, 102, 102));
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNewLabel;
	}

	public void setText(String text) {
		lblNewLabel.setText(text);
	}
	/**
	 * @wbp.nonvisual location=24,334
	 */
	private Timer getTimer() {
		if (timer == null) {
			timer = new Timer(0, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					count -= timer.getDelay();
					
					if (count <= 0) {
						timer.stop();
						count = cameoTime;
						setVisible(false);
					}
				}
			});
			timer.setDelay(1000);
		}
		return timer;
	}
}
