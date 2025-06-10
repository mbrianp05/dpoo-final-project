package gui;

import gui.event.OnAuthenticate;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import auth.Authentication;

public class AuthenticationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblAuthorization;
	private JLabel lblIngresaElCdigo;
	private JLabel errorMsg;
	private JPasswordField passcode;
	private OnAuthenticate onAuthenticateEvent;
	private JLabel lblContrasea;
	private JTextField textFieldUsername;
	private JButton btnAcceder;

	public AuthenticationPanel() {
		setBorder(new LineBorder(new Color(0, 51, 255), 2, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 400, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 30, 30, 40, 30, 0, 40, 50, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAuthorization = new GridBagConstraints();
		gbc_lblAuthorization.fill = GridBagConstraints.BOTH;
		gbc_lblAuthorization.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthorization.gridx = 1;
		gbc_lblAuthorization.gridy = 1;
		add(getLblAuthorization(), gbc_lblAuthorization);
		GridBagConstraints gbc_lblIngresaElCdigo = new GridBagConstraints();
		gbc_lblIngresaElCdigo.fill = GridBagConstraints.BOTH;
		gbc_lblIngresaElCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresaElCdigo.gridx = 1;
		gbc_lblIngresaElCdigo.gridy = 3;
		add(getLblIngresaElCdigo(), gbc_lblIngresaElCdigo);
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsername.fill = GridBagConstraints.BOTH;
		gbc_textFieldUsername.gridx = 1;
		gbc_textFieldUsername.gridy = 4;
		add(getTextFieldUsername(), gbc_textFieldUsername);
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.fill = GridBagConstraints.BOTH;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 6;
		add(getLblContrasea(), gbc_lblContrasea);
		GridBagConstraints gbc_passcode = new GridBagConstraints();
		gbc_passcode.insets = new Insets(0, 0, 5, 5);
		gbc_passcode.fill = GridBagConstraints.BOTH;
		gbc_passcode.gridx = 1;
		gbc_passcode.gridy = 7;
		add(getPasscode(), gbc_passcode);
		GridBagConstraints gbc_errorMsg = new GridBagConstraints();
		gbc_errorMsg.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorMsg.insets = new Insets(0, 0, 5, 5);
		gbc_errorMsg.gridx = 1;
		gbc_errorMsg.gridy = 8;
		add(getErrorMsg(), gbc_errorMsg);
		GridBagConstraints gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.anchor = GridBagConstraints.EAST;
		gbc_btnAcceder.fill = GridBagConstraints.VERTICAL;
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridx = 1;
		gbc_btnAcceder.gridy = 9;
		add(getBtnAcceder(), gbc_btnAcceder);
	}

	public void listenTo(OnAuthenticate listener) {
		onAuthenticateEvent = listener;
	}
	
	private void verifyCredentials() {
		if (Authentication.authorize(textFieldUsername.getText(), String.valueOf(passcode.getPassword()))) {
			if (onAuthenticateEvent != null)
				onAuthenticateEvent.granted();
		} else {
			passcode.setText("");
			errorMsg.setVisible(true);
		}
	}
	
	private JLabel getLblAuthorization() {
		if (lblAuthorization == null) {
			lblAuthorization = new JLabel("Autorizaci\u00F3n");
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}

		return lblAuthorization;
	}

	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			lblIngresaElCdigo = new JLabel("Nombre de usuario");
			lblIngresaElCdigo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblIngresaElCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		}

		return lblIngresaElCdigo;
	}

	private JLabel getErrorMsg() {
		if (errorMsg == null) {
			errorMsg = new JLabel("Credenciales no válidas");
			errorMsg.setBackground(Color.WHITE);
			errorMsg.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			errorMsg.setForeground(new Color(204, 102, 102));
			errorMsg.setVisible(false);
		}

		return errorMsg;
	}
	
	private JPasswordField getPasscode() {
		if (passcode == null) {
			passcode = new JPasswordField();
		}
		return passcode;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contraseña");
			lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
			lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblContrasea;
	}
	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setColumns(10);
		}
		return textFieldUsername;
	}
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("Acceder");
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					verifyCredentials();
				}
			});
			btnAcceder.setBackground(Color.WHITE);
			btnAcceder.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnAcceder;
	}
}
