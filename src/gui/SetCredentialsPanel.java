package gui;

import gui.component.ErrorLabel;
import gui.event.OnCloseApp;
import gui.event.OnSetCredentials;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.Validation;
import gui.component.TitleLabel;

public class SetCredentialsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private TitleLabel lblAuthorization;
	private JLabel lblIngresaElCdigo;
	private ErrorLabel errorPassword;
	private JPasswordField passcode;
	private JLabel lblContrasea;
	private JTextField textFieldUsername;
	private JButton btnAcceder;
	private JPanel panel;
	private JButton btnExit;

	private OnCloseApp onCloseListener;
	private OnSetCredentials credentialsListener;
	
	private ErrorLabel errorUsername;
	private JLabel lblConfirmaLaContrasea;
	private JPasswordField textFieldRepeat;
	private ErrorLabel errorConfirmation;
	
	public SetCredentialsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 400, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 0, 30, 35, 40, 0, 35, 40, 0, 35, 40, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAuthorization = new GridBagConstraints();
		gbc_lblAuthorization.gridwidth = 2;
		gbc_lblAuthorization.fill = GridBagConstraints.BOTH;
		gbc_lblAuthorization.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthorization.gridx = 1;
		gbc_lblAuthorization.gridy = 1;
		add(getLblAuthorization(), gbc_lblAuthorization);
		GridBagConstraints gbc_lblIngresaElCdigo = new GridBagConstraints();
		gbc_lblIngresaElCdigo.gridwidth = 2;
		gbc_lblIngresaElCdigo.fill = GridBagConstraints.BOTH;
		gbc_lblIngresaElCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresaElCdigo.gridx = 1;
		gbc_lblIngresaElCdigo.gridy = 3;
		add(getLblIngresaElCdigo(), gbc_lblIngresaElCdigo);
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.gridwidth = 2;
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsername.fill = GridBagConstraints.BOTH;
		gbc_textFieldUsername.gridx = 1;
		gbc_textFieldUsername.gridy = 4;
		add(getTextFieldUsername(), gbc_textFieldUsername);
		GridBagConstraints gbc_errorUsername = new GridBagConstraints();
		gbc_errorUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorUsername.gridwidth = 2;
		gbc_errorUsername.insets = new Insets(0, 0, 5, 5);
		gbc_errorUsername.gridx = 1;
		gbc_errorUsername.gridy = 5;
		add(getErrorUsername(), gbc_errorUsername);
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.gridwidth = 2;
		gbc_lblContrasea.fill = GridBagConstraints.BOTH;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 6;
		add(getLblContrasea(), gbc_lblContrasea);
		GridBagConstraints gbc_passcode = new GridBagConstraints();
		gbc_passcode.gridwidth = 2;
		gbc_passcode.insets = new Insets(0, 0, 5, 5);
		gbc_passcode.fill = GridBagConstraints.BOTH;
		gbc_passcode.gridx = 1;
		gbc_passcode.gridy = 7;
		add(getPasscode(), gbc_passcode);
		GridBagConstraints gbc_errorPassword = new GridBagConstraints();
		gbc_errorPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorPassword.gridwidth = 2;
		gbc_errorPassword.anchor = GridBagConstraints.NORTH;
		gbc_errorPassword.insets = new Insets(0, 0, 5, 5);
		gbc_errorPassword.gridx = 1;
		gbc_errorPassword.gridy = 8;
		add(getErrorPassword(), gbc_errorPassword);
		GridBagConstraints gbc_lblConfirmaLaContrasea = new GridBagConstraints();
		gbc_lblConfirmaLaContrasea.fill = GridBagConstraints.BOTH;
		gbc_lblConfirmaLaContrasea.gridwidth = 2;
		gbc_lblConfirmaLaContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmaLaContrasea.gridx = 1;
		gbc_lblConfirmaLaContrasea.gridy = 9;
		add(getLblConfirmaLaContrasea(), gbc_lblConfirmaLaContrasea);
		GridBagConstraints gbc_textFieldRepeat = new GridBagConstraints();
		gbc_textFieldRepeat.gridwidth = 2;
		gbc_textFieldRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRepeat.fill = GridBagConstraints.BOTH;
		gbc_textFieldRepeat.gridx = 1;
		gbc_textFieldRepeat.gridy = 10;
		add(getTextFieldRepeat(), gbc_textFieldRepeat);
		GridBagConstraints gbc_errorConfirmation = new GridBagConstraints();
		gbc_errorConfirmation.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorConfirmation.gridwidth = 2;
		gbc_errorConfirmation.insets = new Insets(0, 0, 5, 5);
		gbc_errorConfirmation.gridx = 1;
		gbc_errorConfirmation.gridy = 11;
		add(getErrorConfirmation(), gbc_errorConfirmation);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 12;
		add(getPanel(), gbc_panel);
	}
	
	public void listenTo(OnCloseApp listener) {
		onCloseListener = listener;
	}
	
	public void listenTo(OnSetCredentials listener) {
		credentialsListener = listener;
	}
	
	private TitleLabel getLblAuthorization() {
		if (lblAuthorization == null) {
			lblAuthorization = new TitleLabel();
			lblAuthorization.setText("Establecer credenciales");
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}

		return lblAuthorization;
	}

	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			ImageIcon icon = new ImageIcon(AuthenticationPanel.class.getResource("/resources/images/user-alt.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			lblIngresaElCdigo = new JLabel("Nombre de usuario");
			lblIngresaElCdigo.setIcon(icon);
			lblIngresaElCdigo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblIngresaElCdigo.setHorizontalAlignment(SwingConstants.LEFT);
		}

		return lblIngresaElCdigo;
	}

	private ErrorLabel getErrorPassword() {
		if (errorPassword == null) {
			errorPassword = new ErrorLabel();
			errorPassword.setText("La contrase\u00F1a debe tener al menos 8 caracteres");
			errorPassword.setVisible(false);
		}

		return errorPassword;
	}
	
	private JPasswordField getPasscode() {
		if (passcode == null) {
			passcode = new JPasswordField();
			passcode.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return passcode;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contraseña");
			ImageIcon icon = new ImageIcon(AuthenticationPanel.class.getResource("/resources/images/lock.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			lblContrasea.setIcon(icon);
			lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
			lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblContrasea;
	}
	private JTextField getTextFieldUsername() {
		if (textFieldUsername == null) {
			textFieldUsername = new JTextField();
			textFieldUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldUsername.setColumns(10);
		}
		return textFieldUsername;
	}
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("Siguiente");
			btnAcceder.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean valid = true;
					
					errorUsername.setVisible(false);
					errorPassword.setVisible(false);
					errorConfirmation.setVisible(false);
					
					String password = String.valueOf(passcode.getPassword());
					String confirmation = String.valueOf(textFieldRepeat.getPassword());
					
					if (!Validation.validGmail(textFieldUsername.getText())) {
						errorUsername.setVisible(true);
						valid = false;
					}
					
					if (!Validation.validPassword(password)) {
						errorPassword.setVisible(true);
						valid = false;
					}
					
					if (!password.equals(confirmation)) {
						errorConfirmation.setVisible(true);
						valid = false;
					}
					
					if (valid && credentialsListener != null) {
						credentialsListener.newCredentials(textFieldUsername.getText(), password);
					}
				}
			});
			btnAcceder.setBackground(Color.WHITE);
			btnAcceder.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnAcceder;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0, 0));
			panel.add(getBtnAcceder());
			panel.add(getBtnExit());
		}
		return panel;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Salir");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					onCloseListener.actionPerformed();
				}
			});
			btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnExit.setHorizontalAlignment(SwingConstants.LEFT);
			btnExit.setBackground(Color.WHITE);
		}
		return btnExit;
	}
	private ErrorLabel getErrorUsername() {
		if (errorUsername == null) {
			errorUsername = new ErrorLabel();
			errorUsername.setText("El nombre de usuario debe ser una cuenta de Gmail v\u00E1lida");
			errorUsername.setVisible(false);
		}
		return errorUsername;
	}
	private JLabel getLblConfirmaLaContrasea() {
		if (lblConfirmaLaContrasea == null) {
			lblConfirmaLaContrasea = new JLabel("Confirma la contrase\u00F1a");
			lblConfirmaLaContrasea.setHorizontalAlignment(SwingConstants.LEFT);
			lblConfirmaLaContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblConfirmaLaContrasea;
	}
	private JPasswordField getTextFieldRepeat() {
		if (textFieldRepeat == null) {
			textFieldRepeat = new JPasswordField();
			textFieldRepeat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return textFieldRepeat;
	}
	private ErrorLabel getErrorConfirmation() {
		if (errorConfirmation == null) {
			errorConfirmation = new ErrorLabel();
			errorConfirmation.setText("Las contrase\u00F1as no coinciden");
			errorConfirmation.setVisible(false);
		}
		return errorConfirmation;
	}
}
