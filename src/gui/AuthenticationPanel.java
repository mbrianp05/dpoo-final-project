package gui;

import gui.event.OnAuthenticate;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import auth.Authentication;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AuthenticationPanel extends JPanel {
	private JLabel lblAuthorization;
	private JLabel lblIngresaElCdigo;
	private JLabel errorMsg;
	private LengthSecretInput passcode;
	private JProgressBar progressBar;
	private OnAuthenticate onAuthenticateEvent;

	public AuthenticationPanel() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(204, 0, 102), 2, true));
		setLayout(null);
		add(getLblAuthorization());
		add(getLblIngresaElCdigo());
		add(getErrorMsg());
		add(getPasscode());
		add(getProgressBar());
	}

	public void listenTo(OnAuthenticate listener) {
		onAuthenticateEvent = listener;
	}
	
	private void verifyPasscode() {
		if (Authentication.authorize(passcode.getText())) {
			onAuthenticateEvent.granted();
		} else {
			passcode.setText("");
			errorMsg.setVisible(true);
			progressBar.setValue(0);
		}
	}
	
	private JLabel getLblAuthorization() {
		if (lblAuthorization == null) {
			lblAuthorization = new JLabel("Autorizaci\u00F3n");
			lblAuthorization.setBounds(27, 13, 199, 32);
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
		}

		return lblAuthorization;
	}

	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			lblIngresaElCdigo = new JLabel("Ingresa el c\u00F3digo de acceso");
			lblIngresaElCdigo.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lblIngresaElCdigo.setBounds(27, 45, 188, 32);
			lblIngresaElCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		}

		return lblIngresaElCdigo;
	}

	private JLabel getErrorMsg() {
		if (errorMsg == null) {
			errorMsg = new JLabel("El código no es correcto");
			errorMsg.setBackground(Color.WHITE);
			errorMsg.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			errorMsg.setForeground(new Color(204, 102, 102));
			errorMsg.setBounds(27, 80, 215, 16);
			errorMsg.setVisible(false);
		}

		return errorMsg;
	}
	
	private LengthSecretInput getPasscode() {
		if (passcode == null) {
			passcode = new LengthSecretInput();
			passcode.setMaxLength(Authentication.accessCodeLength());
			passcode.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					progressBar.setValue(passcode.getText().length());
					
					if (passcode.getText().length() == passcode.getMaxLength()) {
						
						verifyPasscode();
					}
				}
			});
			passcode.setBounds(27, 109, 215, 32);
		}
		return passcode;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBackground(Color.WHITE);
			progressBar.setBounds(27, 154, 215, 14);
			progressBar.setMaximum(Authentication.accessCodeLength());
		}
		return progressBar;
	}
}
