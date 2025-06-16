package gui;

import gui.component.ErrorLabel;
import gui.component.TitleLabel;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.Email;
import utils.EmailSenderThread;
import utils.Validation;

public class SetCredentialsPanel extends JLayeredPane {
	private static final long serialVersionUID = 1L;

	private TitleLabel lblAuthorization;
	private JLabel lblIngresaElCdigo;
	private ErrorLabel errorPassword;
	private JPasswordField passcode;
	private JLabel lblContrasea;
	private JTextField textFieldUsername;
	private JButton btnNext;
	private JPanel panel;
	private JButton btnExit;

	private OnCloseApp onCloseListener;
	private OnSetCredentials credentialsListener;

	private ErrorLabel errorUsername;
	private JLabel lblConfirmaLaContrasea;
	private JPasswordField textFieldRepeat;
	private ErrorLabel errorConfirmation;
	private ErrorLabel errorConnection;
	private JLabel lblNewLabel;
	private JLabel gif;
	private JPanel overlayPanel;

	public SetCredentialsPanel() {
		Email.removeCode();
		setSize(600, 500);

		JPanel wrapper = new JPanel();
		wrapper.setBounds(0, 0, 600, 500);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 0, 0, 70, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 30, 30, 35, 40, 0, 35, 40, 0, 35, 40, 45, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		wrapper.setLayout(gridBagLayout);

		GridBagConstraints gbc_lblAuthorization = new GridBagConstraints();
		gbc_lblAuthorization.gridwidth = 2;
		gbc_lblAuthorization.fill = GridBagConstraints.BOTH;
		gbc_lblAuthorization.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthorization.gridx = 1;
		gbc_lblAuthorization.gridy = 1;
		wrapper.add(getLblAuthorization(), gbc_lblAuthorization);

		GridBagConstraints gbc_lblIngresaElCdigo = new GridBagConstraints();
		gbc_lblIngresaElCdigo.gridwidth = 2;
		gbc_lblIngresaElCdigo.fill = GridBagConstraints.BOTH;
		gbc_lblIngresaElCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresaElCdigo.gridx = 1;
		gbc_lblIngresaElCdigo.gridy = 3;
		wrapper.add(getLblIngresaElCdigo(), gbc_lblIngresaElCdigo);

		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.gridwidth = 2;
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsername.fill = GridBagConstraints.BOTH;
		gbc_textFieldUsername.gridx = 1;
		gbc_textFieldUsername.gridy = 4;
		wrapper.add(getTextFieldUsername(), gbc_textFieldUsername);

		GridBagConstraints gbc_errorUsername = new GridBagConstraints();
		gbc_errorUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorUsername.gridwidth = 2;
		gbc_errorUsername.insets = new Insets(0, 0, 5, 5);
		gbc_errorUsername.gridx = 1;
		gbc_errorUsername.gridy = 5;
		wrapper.add(getErrorUsername(), gbc_errorUsername);

		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.gridwidth = 2;
		gbc_lblContrasea.fill = GridBagConstraints.BOTH;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 6;
		wrapper.add(getLblContrasea(), gbc_lblContrasea);

		GridBagConstraints gbc_passcode = new GridBagConstraints();
		gbc_passcode.gridwidth = 2;
		gbc_passcode.insets = new Insets(0, 0, 5, 5);
		gbc_passcode.fill = GridBagConstraints.BOTH;
		gbc_passcode.gridx = 1;
		gbc_passcode.gridy = 7;
		wrapper.add(getPasscode(), gbc_passcode);

		GridBagConstraints gbc_errorPassword = new GridBagConstraints();
		gbc_errorPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorPassword.gridwidth = 2;
		gbc_errorPassword.anchor = GridBagConstraints.NORTH;
		gbc_errorPassword.insets = new Insets(0, 0, 5, 5);
		gbc_errorPassword.gridx = 1;
		gbc_errorPassword.gridy = 8;
		wrapper.add(getErrorPassword(), gbc_errorPassword);

		GridBagConstraints gbc_lblConfirmaLaContrasea = new GridBagConstraints();
		gbc_lblConfirmaLaContrasea.fill = GridBagConstraints.BOTH;
		gbc_lblConfirmaLaContrasea.gridwidth = 2;
		gbc_lblConfirmaLaContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmaLaContrasea.gridx = 1;
		gbc_lblConfirmaLaContrasea.gridy = 9;
		wrapper.add(getLblConfirmaLaContrasea(), gbc_lblConfirmaLaContrasea);

		GridBagConstraints gbc_textFieldRepeat = new GridBagConstraints();
		gbc_textFieldRepeat.gridwidth = 2;
		gbc_textFieldRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRepeat.fill = GridBagConstraints.BOTH;
		gbc_textFieldRepeat.gridx = 1;
		gbc_textFieldRepeat.gridy = 10;
		wrapper.add(getTextFieldRepeat(), gbc_textFieldRepeat);

		GridBagConstraints gbc_errorConfirmation = new GridBagConstraints();
		gbc_errorConfirmation.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorConfirmation.gridwidth = 2;
		gbc_errorConfirmation.insets = new Insets(0, 0, 5, 5);
		gbc_errorConfirmation.gridx = 1;
		gbc_errorConfirmation.gridy = 11;
		wrapper.add(getErrorConfirmation(), gbc_errorConfirmation);

		GridBagConstraints gbc_errorConnection = new GridBagConstraints();
		gbc_errorConnection.fill = GridBagConstraints.BOTH;
		gbc_errorConnection.insets = new Insets(0, 0, 5, 5);
		gbc_errorConnection.gridx = 1;
		gbc_errorConnection.gridy = 12;
		wrapper.add(getErrorConnection(), gbc_errorConnection);

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 12;

		wrapper.add(getPanel(), gbc_panel);

		overlayPanel = new JPanel();

		overlayPanel.setBackground(new Color(50, 50, 50));
		overlayPanel.setBounds(0, 0, 600, 500);

		add(wrapper, JLayeredPane.DEFAULT_LAYER);
		GridBagLayout gbl_overlayPanel = new GridBagLayout();
		gbl_overlayPanel.columnWidths = new int[]{600, 0};
		gbl_overlayPanel.rowHeights = new int[]{220, 60, 0};
		gbl_overlayPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_overlayPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		overlayPanel.setLayout(gbl_overlayPanel);
		add(overlayPanel, JLayeredPane.PALETTE_LAYER);
		GridBagConstraints gbc_gif = new GridBagConstraints();
		gbc_gif.fill = GridBagConstraints.VERTICAL;
		gbc_gif.insets = new Insets(0, 0, 5, 0);
		gbc_gif.gridx = 0;
		gbc_gif.gridy = 0;
		overlayPanel.add(getGif(), gbc_gif);

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		overlayPanel.add(getLblNewLabel(), gbc_lblNewLabel);

		overlayPanel.setVisible(false);
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
			lblAuthorization.setText("Registrarse");
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}

		return lblAuthorization;
	}

	private JLabel getLblIngresaElCdigo() {
		if (lblIngresaElCdigo == null) {
			ImageIcon icon = new ImageIcon(SetCredentialsPanel.class.getResource("/resources/images/user-alt.png"));
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
			ImageIcon icon = new ImageIcon(SetCredentialsPanel.class.getResource("/resources/images/lock.png"));
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

	private void resetErrors() {
		errorUsername.setVisible(false);
		errorPassword.setVisible(false);
		errorConfirmation.setVisible(false);
	}

	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Siguiente");
			btnNext.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean valid = true;
					resetErrors();

					final String email = textFieldUsername.getText();
					final String password = String.valueOf(passcode.getPassword());
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
						passcode.setText("");
						textFieldRepeat.setText("");
						textFieldUsername.setText("");

						textFieldUsername.setEnabled(false);
						passcode.setEnabled(false);
						textFieldRepeat.setEnabled(false);
						btnExit.setEnabled(false);
						btnNext.setEnabled(false);
						overlayPanel.setVisible(true);

						EmailSenderThread thread = new EmailSenderThread(email) {
							protected void done() {
								try {
									get();
									reactivateForm();
									// Ejecutar una vez que se haya mandado el email
									credentialsListener.newCredentials(email, password);
								} catch (Exception e) {
									reactivateForm();
									errorConnection.setVisible(true);
								}
							};
						};
						thread.execute();
					}
				}
			});
			btnNext.setBackground(Color.WHITE);
			btnNext.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return btnNext;
	}

	private void reactivateForm() {
		overlayPanel.setVisible(false);
		textFieldUsername.setEnabled(true);
		passcode.setEnabled(true);
		textFieldRepeat.setEnabled(true);
		btnExit.setEnabled(true);
		btnNext.setEnabled(true);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0, 0));
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{61, 95, 0};
			gbl_panel.rowHeights = new int[]{29, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_btnExit = new GridBagConstraints();
			gbc_btnExit.fill = GridBagConstraints.BOTH;
			gbc_btnExit.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnExit.insets = new Insets(0, 0, 0, 5);
			gbc_btnExit.gridx = 0;
			gbc_btnExit.gridy = 0;
			panel.add(getBtnExit(), gbc_btnExit);
			GridBagConstraints gbc_btnNext = new GridBagConstraints();
			gbc_btnNext.fill = GridBagConstraints.BOTH;
			gbc_btnNext.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnNext.gridx = 1;
			gbc_btnNext.gridy = 0;
			panel.add(getBtnNext(), gbc_btnNext);
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

			ImageIcon icon = new ImageIcon(SetCredentialsPanel.class.getResource("/resources/images/confirm.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			lblConfirmaLaContrasea.setIcon(icon);
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
	private ErrorLabel getErrorConnection() {
		if (errorConnection == null) {
			errorConnection = new ErrorLabel();
			errorConnection.setVisible(false);
			errorConnection.setText("Verifica tu conexi\u00F3n a Internet");
		}
		return errorConnection;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Enviando email");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 42));
			lblNewLabel.setForeground(Color.WHITE);
		}
		return lblNewLabel;
	}
	private JLabel getGif() {
		if (gif == null) {
			gif = new JLabel("");
			ImageIcon icon = new ImageIcon(SetCredentialsPanel.class.getResource("/resources/images/loader-spinner.gif"));
			final ImageIcon scaled = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_FAST));

			gif.setIcon(scaled);
		}
		return gif;
	}
}
