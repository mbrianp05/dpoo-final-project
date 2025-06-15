package gui;

import gui.component.ErrorLabel;
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import utils.Email;
import utils.EmailSenderThread;
import gui.component.JTextLimited;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class ConfirmationCodePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private TitleLabel lblAuthorization;
	private JLabel lblSeHaEnviado;
	private String email;
	private JLabel lblIntroduceElCdigo;
	private JTextLimited firstDigit;
	private JTextLimited secondDigit;
	private JTextLimited thirdDigit;
	private JTextLimited fourthDigit;
	private JTextLimited fifthDigit;
	private JTextLimited sixthDigit;
	private JPanel panel;
	private JButton btnBack;
	private JButton btnSiguiente;
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
		gridBagLayout.columnWidths = new int[]{40, 0, 0, 0, 0, 0, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 30, 0, 0, 30, 45, 35, 40, 0, 40, 40, 0};
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
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 6;
		add(getPanel_1(), gbc_panel_1);
		GridBagConstraints gbc_firstDigit = new GridBagConstraints();
		gbc_firstDigit.insets = new Insets(0, 0, 5, 5);
		gbc_firstDigit.fill = GridBagConstraints.BOTH;
		gbc_firstDigit.gridx = 1;
		gbc_firstDigit.gridy = 7;
		add(getFirstDigit(), gbc_firstDigit);
		GridBagConstraints gbc_secondDigit = new GridBagConstraints();
		gbc_secondDigit.insets = new Insets(0, 0, 5, 5);
		gbc_secondDigit.fill = GridBagConstraints.BOTH;
		gbc_secondDigit.gridx = 2;
		gbc_secondDigit.gridy = 7;
		add(getSecondDigit(), gbc_secondDigit);
		GridBagConstraints gbc_thirdDigit = new GridBagConstraints();
		gbc_thirdDigit.insets = new Insets(0, 0, 5, 5);
		gbc_thirdDigit.fill = GridBagConstraints.BOTH;
		gbc_thirdDigit.gridx = 3;
		gbc_thirdDigit.gridy = 7;
		add(getThirdDigit(), gbc_thirdDigit);
		GridBagConstraints gbc_fourthDigit = new GridBagConstraints();
		gbc_fourthDigit.insets = new Insets(0, 0, 5, 5);
		gbc_fourthDigit.fill = GridBagConstraints.BOTH;
		gbc_fourthDigit.gridx = 4;
		gbc_fourthDigit.gridy = 7;
		add(getFourthDigit(), gbc_fourthDigit);
		GridBagConstraints gbc_fifthDigit = new GridBagConstraints();
		gbc_fifthDigit.insets = new Insets(0, 0, 5, 5);
		gbc_fifthDigit.fill = GridBagConstraints.BOTH;
		gbc_fifthDigit.gridx = 5;
		gbc_fifthDigit.gridy = 7;
		add(getFifthDigit(), gbc_fifthDigit);
		GridBagConstraints gbc_sixthDigit = new GridBagConstraints();
		gbc_sixthDigit.insets = new Insets(0, 0, 5, 5);
		gbc_sixthDigit.fill = GridBagConstraints.BOTH;
		gbc_sixthDigit.gridx = 6;
		gbc_sixthDigit.gridy = 7;
		add(getSixthDigit(), gbc_sixthDigit);
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
	private JTextLimited getFirstDigit() {
		if (firstDigit == null) {
			firstDigit = new JTextLimited();
			firstDigit.requestFocus();
			firstDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if (firstDigit.getText().length() == firstDigit.getLimite()) {
						secondDigit.requestFocus();
					}
				}
			});
			firstDigit.setLimite(1);
			firstDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			firstDigit.setHorizontalAlignment(SwingConstants.CENTER);
			firstDigit.setColumns(10);
		}
		return firstDigit;
	}
	private JTextLimited getSecondDigit() {
		if (secondDigit == null) {
			secondDigit = new JTextLimited();
			secondDigit.requestFocus();
			secondDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						firstDigit.requestFocus();
					}
					
					if (secondDigit.getText().length() == thirdDigit.getLimite()) {
						thirdDigit.requestFocus();
					}
				}
			});
			secondDigit.setLimite(1);
			secondDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			secondDigit.setHorizontalAlignment(SwingConstants.CENTER);
			secondDigit.setColumns(10);
		}
		return secondDigit;
	}
	private JTextLimited getThirdDigit() {
		if (thirdDigit == null) {
			thirdDigit = new JTextLimited();
			thirdDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						secondDigit.requestFocus();
					}
					
					if (thirdDigit.getText().length() == thirdDigit.getLimite()) {
						fourthDigit.requestFocus();
					}
				}
			});
			thirdDigit.setLimite(1);
			thirdDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			thirdDigit.setHorizontalAlignment(SwingConstants.CENTER);
			thirdDigit.setColumns(10);
		}
		return thirdDigit;
	}
	private JTextLimited getFourthDigit() {
		if (fourthDigit == null) {
			fourthDigit = new JTextLimited();
			fourthDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						thirdDigit.requestFocus();
					}
					
					if (fourthDigit.getText().length() == fourthDigit.getLimite()) {
						fifthDigit.requestFocus();
					}
				}
			});
			fourthDigit.setLimite(1);
			fourthDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			fourthDigit.setHorizontalAlignment(SwingConstants.CENTER);
			fourthDigit.setColumns(10);
		}
		return fourthDigit;
	}
	private JTextLimited getFifthDigit() {
		if (fifthDigit == null) {
			fifthDigit = new JTextLimited();
			fifthDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						fourthDigit.requestFocus();
					}
					
					if (fifthDigit.getText().length() == fifthDigit.getLimite()) {
						sixthDigit.requestFocus();
					}
				}
			});
			fifthDigit.setLimite(1);
			fifthDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			fifthDigit.setHorizontalAlignment(SwingConstants.CENTER);
			fifthDigit.setColumns(10);
		}
		return fifthDigit;
	}
	private JTextLimited getSixthDigit() {
		if (sixthDigit == null) {
			sixthDigit = new JTextLimited();
			sixthDigit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 8) {
						fifthDigit.requestFocus();
					}
					
					if (sixthDigit.getText().length() == sixthDigit.getLimite()) {
						verify();
					}
				}
			});
			sixthDigit.setLimite(1);
			sixthDigit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			sixthDigit.setHorizontalAlignment(SwingConstants.CENTER);
			sixthDigit.setColumns(10);
		}
		return sixthDigit;
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
			GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
			gbc_btnSiguiente.fill = GridBagConstraints.BOTH;
			gbc_btnSiguiente.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnSiguiente.gridx = 2;
			gbc_btnSiguiente.gridy = 0;
			panel.add(getBtnSiguiente(), gbc_btnSiguiente);
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
		
		code += firstDigit.getText();
		code += secondDigit.getText();
		code += thirdDigit.getText();
		code += fourthDigit.getText();
		code += fifthDigit.getText();
		code += sixthDigit.getText();
		
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
						
						firstDigit.setText("");
						firstDigit.setEnabled(false);
						
						secondDigit.setText("");
						secondDigit.setEnabled(false);
						
						thirdDigit.setText("");
						thirdDigit.setEnabled(false);
						
						fourthDigit.setText("");
						fourthDigit.setEnabled(false);
						
						fifthDigit.setText("");
						fifthDigit.setEnabled(false);
						
						sixthDigit.setText("");
						sixthDigit.setEnabled(false);
						
						timer.stop();
						
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
							firstDigit.setEnabled(true);
							secondDigit.setEnabled(true);
							thirdDigit.setEnabled(true);
							fourthDigit.setEnabled(true);
							fifthDigit.setEnabled(true);
							sixthDigit.setEnabled(true);
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
