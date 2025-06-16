package gui;

import gui.component.ErrorLabel;
import gui.component.JTextLimited;
import gui.component.TitleLabel;
import gui.event.OnBackEvent;
import gui.event.OnCodeConfirmed;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import utils.Constants;
import utils.Email;
import utils.EmailSenderThread;

public class ConfirmationCodePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private TitleLabel lblAuthorization;
	private JLabel lblSeHaEnviado;
	private String email;
	private JLabel lblIntroduceElCdigo;

	private JTextLimited[] fields = new JTextLimited[6];

	private JPanel panel;
	private JButton btnBack;
	private JButton btnAccept;
	private ErrorLabel errroCode;
	private JLabel lblExpiration;
	private Timer timer;

	private OnCodeConfirmed listener;
	private OnBackEvent goBackListener;

	private int expirationTime;
	private JPanel panel_1;
	private JButton btnResend;

	public ConfirmationCodePanel(String email) {
		this.email = email;
		setExpirationTime();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 70, 70, 70, 70, 70, 70, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 30, 0, 0, 30, 45, 35, 40, 0, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAuthorization = new GridBagConstraints();
		gbc_lblAuthorization.gridwidth = 6;
		gbc_lblAuthorization.fill = GridBagConstraints.BOTH;
		gbc_lblAuthorization.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthorization.gridx = 1;
		gbc_lblAuthorization.gridy = 1;
		add(getLblAuthorization(), gbc_lblAuthorization);
		GridBagConstraints gbc_lblSeHaEnviado = new GridBagConstraints();
		gbc_lblSeHaEnviado.fill = GridBagConstraints.BOTH;
		gbc_lblSeHaEnviado.gridwidth = 6;
		gbc_lblSeHaEnviado.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeHaEnviado.gridx = 1;
		gbc_lblSeHaEnviado.gridy = 3;
		add(getLblSeHaEnviado(), gbc_lblSeHaEnviado);
		GridBagConstraints gbc_lblIntroduceElCdigo = new GridBagConstraints();
		gbc_lblIntroduceElCdigo.fill = GridBagConstraints.BOTH;
		gbc_lblIntroduceElCdigo.gridwidth = 6;
		gbc_lblIntroduceElCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroduceElCdigo.gridx = 1;
		gbc_lblIntroduceElCdigo.gridy = 4;
		add(getLblIntroduceElCdigo(), gbc_lblIntroduceElCdigo);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		add(getPanel_1(), gbc_panel_1);

		for (int i = 0; i < fields.length; i++) {
			fields[i] = new JTextLimited();
			fields[i].setText("");
			fields[i].setLimite(1);
			fields[i].setHorizontalAlignment(JTextField.CENTER);
			fields[i].setFont(Constants.getLabelFont());

			GridBagConstraints gbc_firstDigit = new GridBagConstraints();

			gbc_firstDigit.insets = new Insets(0, 0, 5, 5);
			gbc_firstDigit.fill = GridBagConstraints.BOTH;
			gbc_firstDigit.gridx = i + 1;
			gbc_firstDigit.gridy = 7;

			add(fields[i], gbc_firstDigit);
		}

		GridBagConstraints gbc_errroCode = new GridBagConstraints();
		gbc_errroCode.fill = GridBagConstraints.BOTH;
		gbc_errroCode.gridwidth = 6;
		gbc_errroCode.insets = new Insets(0, 0, 5, 5);
		gbc_errroCode.gridx = 1;
		gbc_errroCode.gridy = 8;
		add(getErrroCode(), gbc_errroCode);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 10;
		add(getPanel(), gbc_panel);

		getTimer();
		timer.start();
	}

	public void listenTo(OnBackEvent listener) {
		goBackListener = listener;
	}

	private void setExpirationTime() {
		expirationTime = 180;
	}

	public void listenTo(OnCodeConfirmed listener) {
		this.listener = listener;
	}

	private TitleLabel getLblAuthorization() {
		if (lblAuthorization == null) {
			lblAuthorization = new TitleLabel();
			lblAuthorization.setText("Confirmar correo electr\u00F3nico");
			lblAuthorization.setHorizontalAlignment(SwingConstants.LEFT);
			lblAuthorization.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}

		return lblAuthorization;
	}
	private JLabel getLblSeHaEnviado() {
		if (lblSeHaEnviado == null) {
			lblSeHaEnviado = new JLabel("Se ha enviado un email a ");
			lblSeHaEnviado.setText(lblSeHaEnviado.getText() + email);
			lblSeHaEnviado.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblSeHaEnviado;
	}
	private JLabel getLblIntroduceElCdigo() {
		if (lblIntroduceElCdigo == null) {
			lblIntroduceElCdigo = new JLabel("Introduce el c\u00F3digo de confirmaci\u00F3n");
			lblIntroduceElCdigo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblIntroduceElCdigo;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{128, 87, 95, 0};
			gbl_panel.rowHeights = new int[]{29, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_btnBack = new GridBagConstraints();
			gbc_btnBack.fill = GridBagConstraints.BOTH;
			gbc_btnBack.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnBack.insets = new Insets(0, 0, 0, 5);
			gbc_btnBack.gridx = 1;
			gbc_btnBack.gridy = 0;
			panel.add(getBtnBack(), gbc_btnBack);
			GridBagConstraints gbc_btnAccept = new GridBagConstraints();
			gbc_btnAccept.fill = GridBagConstraints.BOTH;
			gbc_btnAccept.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnAccept.gridx = 2;
			gbc_btnAccept.gridy = 0;
			panel.add(getBtnAccept(), gbc_btnAccept);
		}
		return panel;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Atr\u00E1s");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					goBackListener.navigate();
				}
			});
			btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return btnBack;
	}

	public String getCode() {
		String code = "";

		for (int i = 0; i < fields.length; i++) {
			code += fields[i].getText();
		}

		return code;
	}

	private void verify() {
		if(Email.verifyCode(getCode())) {
			errroCode.setVisible(false);
			if (listener != null) listener.confirmed();
		} else {
			errroCode.setVisible(true);
		}
	}

	private JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("Aceptar");
			btnAccept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					verify();
				}
			});
			btnAccept.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return btnAccept;
	}
	private ErrorLabel getErrroCode() {
		if (errroCode == null) {
			errroCode = new ErrorLabel();
			errroCode.setText("El c\u00F3digo no es correcto");
			errroCode.setVisible(false);
		}
		return errroCode;
	}
	private JLabel getLblExpiration() {
		if (lblExpiration == null) {
			lblExpiration = new JLabel("El c\u00F3digo expira en");
			lblExpiration.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblExpiration;
	}

	private String formatTime() {
		String format = "";
		int minutes = expirationTime / 60;

		String seconds = String.valueOf(expirationTime % 60);

		format += "0" + String.valueOf(minutes) + ":";

		if (seconds.length() == 1) {
			format += "0";
		}

		format += seconds;

		return format;
	}

	private Timer getTimer() {
		if (timer == null) {
			timer = new Timer(0, new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					expirationTime -= 1;
					lblExpiration.setText("El c\u00F3digo expira en " + formatTime());

					if (expirationTime == 0) {
						lblExpiration.setText("El c\u00F3digo ya expiró");

						for (JTextLimited field: fields) {
							field.setText("");
							field.setEnabled(false);
						}

						timer.stop();

						btnAccept.setEnabled(false);
						btnResend.setVisible(true);
					}
				}
			});
			timer.setDelay(1000);
		}
		return timer;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{128, 150, 0};
			gbl_panel_1.rowHeights = new int[]{45, 0};
			gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_lblExpiration = new GridBagConstraints();
			gbc_lblExpiration.insets = new Insets(0, 0, 0, 5);
			gbc_lblExpiration.fill = GridBagConstraints.BOTH;
			gbc_lblExpiration.gridx = 0;
			gbc_lblExpiration.gridy = 0;
			panel_1.add(getLblExpiration(), gbc_lblExpiration);
			GridBagConstraints gbc_btnResend = new GridBagConstraints();
			gbc_btnResend.fill = GridBagConstraints.VERTICAL;
			gbc_btnResend.gridx = 1;
			gbc_btnResend.gridy = 0;
			panel_1.add(getBtnResend(), gbc_btnResend);
		}
		return panel_1;
	}
	private JButton getBtnResend() {
		if (btnResend == null) {

			btnResend = new JButton("Reenviar c\u00F3digo");
			btnResend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ImageIcon icon = new ImageIcon(SetCredentialsPanel.class.getResource("/resources/images/loader-spinner.gif"));
					final ImageIcon scaled = new ImageIcon(icon.getImage().getScaledInstance(33, 33, Image.SCALE_FAST));

					btnResend.setText("Enviando email");
					btnResend.setIcon(scaled);
					btnResend.setEnabled(false);

					EmailSenderThread sender = new EmailSenderThread(email) {
						@Override
						protected void done() {
							for (JTextLimited field: fields) {
								field.setEnabled(false);
							}

							btnAccept.setEnabled(true);

							setExpirationTime();
							timer.start();

							ImageIcon icon = new ImageIcon(ConfirmationCodePanel.class.getResource("/resources/images/resend-email.png"));
							icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

							btnResend.setEnabled(true);
							btnResend.setText("Reenviar c\u00F3digo");
							btnResend.setIcon(icon);
							btnResend.setVisible(false);
						}
					};

					sender.execute();
				}
			});

			ImageIcon icon = new ImageIcon(ConfirmationCodePanel.class.getResource("/resources/images/resend-email.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			btnResend.setIcon(icon);
			btnResend.setVisible(false);
		}
		return btnResend;
	}
}
