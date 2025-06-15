package gui;

import gui.component.ErrorLabel;
import gui.component.TitleLabel;
import gui.event.OnCodeConfirmed;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import utils.Email;
import gui.component.JTextLimited;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfirmationCodePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private TitleLabel lblAuthorization;
	private JLabel lblSeHaEnviado;
	private String email;
	private JLabel lblIntroduceElCdigo;
	private JTextLimited textField;
	private JTextLimited textField_1;
	private JTextLimited textField_2;
	private JTextLimited textField_3;
	private JTextLimited textField_4;
	private JTextLimited textField_5;
	private JPanel panel;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private ErrorLabel errroCode;
	private JLabel lblExpiration;
	private Timer timer;
	
	private OnCodeConfirmed listener;
	
	private int expirationTime;
	private ErrorLabel rlblNoTienesConexin;
	
	public ConfirmationCodePanel(String email) {
		this.email = email;
		Email.sendConfirmationEmail(email);
		expirationTime = 90;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 0, 0, 0, 0, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 30, 0, 0, 30, 30, 35, 40, 0, 40, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_rlblNoTienesConexin = new GridBagConstraints();
		gbc_rlblNoTienesConexin.fill = GridBagConstraints.BOTH;
		gbc_rlblNoTienesConexin.gridwidth = 6;
		gbc_rlblNoTienesConexin.insets = new Insets(0, 0, 5, 5);
		gbc_rlblNoTienesConexin.gridx = 1;
		gbc_rlblNoTienesConexin.gridy = 5;
		add(getRlblNoTienesConexin(), gbc_rlblNoTienesConexin);
		GridBagConstraints gbc_lblExpiration = new GridBagConstraints();
		gbc_lblExpiration.fill = GridBagConstraints.BOTH;
		gbc_lblExpiration.gridwidth = 6;
		gbc_lblExpiration.insets = new Insets(0, 0, 5, 5);
		gbc_lblExpiration.gridx = 1;
		gbc_lblExpiration.gridy = 6;
		add(getLblExpiration(), gbc_lblExpiration);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 7;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		add(getTextField_1(), gbc_textField_1);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 7;
		add(getTextField_2(), gbc_textField_2);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 7;
		add(getTextField_3(), gbc_textField_3);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 5;
		gbc_textField_4.gridy = 7;
		add(getTextField_4(), gbc_textField_4);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 6;
		gbc_textField_5.gridy = 7;
		add(getTextField_5(), gbc_textField_5);
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
	private JTextLimited getTextField() {
		if (textField == null) {
			textField = new JTextLimited();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if (textField.getText().length() == textField.getLimite()) {
						textField_1.requestFocus();
					}
				}
			});
			textField.setLimite(1);
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextLimited getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextLimited();
			textField_1.requestFocus();
			textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						textField.requestFocus();
					}
					
					if (textField_1.getText().length() == textField_2.getLimite()) {
						textField_2.requestFocus();
					}
				}
			});
			textField_1.setLimite(1);
			textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextLimited getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextLimited();
			textField_2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						textField_1.requestFocus();
					}
					
					if (textField_2.getText().length() == textField_2.getLimite()) {
						textField_3.requestFocus();
					}
				}
			});
			textField_2.setLimite(1);
			textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextLimited getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextLimited();
			textField_3.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						textField_2.requestFocus();
					}
					
					if (textField_3.getText().length() == textField_3.getLimite()) {
						textField_4.requestFocus();
					}
				}
			});
			textField_3.setLimite(1);
			textField_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextLimited getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextLimited();
			textField_4.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						textField_3.requestFocus();
					}
					
					if (textField_4.getText().length() == textField_4.getLimite()) {
						textField_5.requestFocus();
					}
				}
			});
			textField_4.setLimite(1);
			textField_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextLimited getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextLimited();
			textField_5.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						textField_4.requestFocus();
					}
					
					if (textField_5.getText().length() == textField_5.getLimite()) {
						verify();
					}
				}
			});
			textField_5.setLimite(1);
			textField_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_5.setColumns(10);
		}
		return textField_5;
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
			GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
			gbc_btnAnterior.fill = GridBagConstraints.BOTH;
			gbc_btnAnterior.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnAnterior.insets = new Insets(0, 0, 0, 5);
			gbc_btnAnterior.gridx = 1;
			gbc_btnAnterior.gridy = 0;
			panel.add(getBtnAnterior(), gbc_btnAnterior);
			GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
			gbc_btnSiguiente.fill = GridBagConstraints.BOTH;
			gbc_btnSiguiente.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnSiguiente.gridx = 2;
			gbc_btnSiguiente.gridy = 0;
			panel.add(getBtnSiguiente(), gbc_btnSiguiente);
		}
		return panel;
	}
	private JButton getBtnAnterior() {
		if (btnAnterior == null) {
			btnAnterior = new JButton("Atr\u00E1s");
			btnAnterior.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return btnAnterior;
	}
	
	public String getCode() {
		String code = "";
		
		code += textField.getText();
		code += textField_1.getText();
		code += textField_2.getText();
		code += textField_3.getText();
		code += textField_4.getText();
		code += textField_5.getText();
		
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
	
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Aceptar");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					verify();
				}
			});
			btnSiguiente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return btnSiguiente;
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
						
						textField.setEnabled(false);
						textField_1.setEnabled(false);
						textField_2.setEnabled(false);
						textField_3.setEnabled(false);
						textField_4.setEnabled(false);
						textField_5.setEnabled(false);
						
						timer.stop();
					}
				}
			});
			timer.setDelay(1000);
		}
		return timer;
	}
	private ErrorLabel getRlblNoTienesConexin() {
		if (rlblNoTienesConexin == null) {
			rlblNoTienesConexin = new ErrorLabel();
			rlblNoTienesConexin.setText("No tienes conexi\u00F3n en estos momentos");
			rlblNoTienesConexin.setVisible(false);
		}
		return rlblNoTienesConexin;
	}
}
